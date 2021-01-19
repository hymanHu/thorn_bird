package com.sfac.springMvc.module.test.service.impl;

import java.security.cert.PKIXRevocationChecker.Option;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sfac.springMvc.module.common.entity.ResultEntity;
import com.sfac.springMvc.module.common.entity.ResultEntity.ResultStatus;
import com.sfac.springMvc.module.test.entity.Student;
import com.sfac.springMvc.module.test.repository.StudentRepository;
import com.sfac.springMvc.module.test.service.StudentService;

import jdk.nashorn.internal.runtime.options.Options;

/**
 * @Description: Student Service Impl
 * @author: HymanHu
 * @date: 2021年1月16日
 */
@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Autowired
	private StudentRepository studentRepository;

	@Override
	@Transactional("hibernateTransactionManager")
	public ResultEntity<Student> insertStudent(Student student) {
		hibernateTemplate.saveOrUpdate(student);
		return new ResultEntity<Student>(ResultStatus.SUCCESS.status, "Insert success.", student);
	}

	@Override
	@Transactional("hibernateTransactionManager")
	public ResultEntity<Student> updateStudent(Student student) {
		hibernateTemplate.saveOrUpdate(student);
//		int i = 1 / 0;
		return new ResultEntity<Student>(ResultStatus.SUCCESS.status, "Update success.", student);
	}

	@Override
	@Transactional("hibernateTransactionManager")
	public ResultEntity<Object> deleteStudent(Integer id) {
		Student student = new Student();
		student.setId(id);
		hibernateTemplate.delete(student);
		return new ResultEntity<Object>(ResultStatus.SUCCESS.status, "Delete success.");
	}

	@Override
	public Student getStudentById(Integer id) {
		return hibernateTemplate.get(Student.class, id);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public Student getStudentByName(String studentName) {
		// Example 查询
		Student example = new Student();
		example.setStudentName(studentName);
		List<Student> students = hibernateTemplate.findByExample(example);
		// Hql 查询
		students = (List<Student>) hibernateTemplate.find("from Student where studentName like ?0", 
				String.format("%%%s%%", studentName));
		return students.isEmpty() ? null : students.get(0);
	}

	/**
	 * criteria 多条件查询，示例 sql
	 * select * from test_student where ( studentName like ? and ( id between ? and ? or this_.card_id is null))
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getStudentsByName(String studentName) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Student.class);
		criteria.add(
			Restrictions.and(
				Restrictions.like("studentName", studentName, MatchMode.ANYWHERE),
				Restrictions.or(
					Restrictions.between("id", 1, 10),
					Restrictions.isNull("studentCard")
				)
			)
		);
		return (List<Student>) hibernateTemplate.findByCriteria(criteria);
	}

	@Override
	@Transactional("jpaTransactionManager")
	public ResultEntity<Student> insertStudentForJpa(Student student) {
		studentRepository.saveAndFlush(student);
		return new ResultEntity<Student>(ResultStatus.SUCCESS.status, "Insert success.", student);
	}

	@Override
	@Transactional("jpaTransactionManager")
	public ResultEntity<Student> updateStudentForJpa(Student student) {
		studentRepository.saveAndFlush(student);
		int i = 1 / 0;
		return new ResultEntity<Student>(ResultStatus.SUCCESS.status, "Update success.", student);
	}

	@Override
	public ResultEntity<Object> deleteStudentForJpa(Integer id) {
		studentRepository.delete(id);
		return new ResultEntity<Object>(ResultStatus.SUCCESS.status, "Delete success.");
	}

	@Override
	public Student getStudentByIdForJpa(Integer id) {
		return studentRepository.findOne(id);
	}

	@Override
	public Student getStudentByNameForJpa(String studentName) {
		List<Student> students = Optional.ofNullable(studentRepository.findByStudentName(studentName))
				.orElse(Collections.emptyList());
		return students.isEmpty() ? null : students.get(0);
	}

	@Override
	public List<Student> getStudentsForJpa() {
		return studentRepository.findAll();
	}
	
}
