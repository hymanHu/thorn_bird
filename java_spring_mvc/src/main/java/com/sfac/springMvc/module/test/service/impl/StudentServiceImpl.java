package com.sfac.springMvc.module.test.service.impl;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sfac.springMvc.module.common.entity.ResultEntity;
import com.sfac.springMvc.module.common.entity.ResultEntity.ResultStatus;
import com.sfac.springMvc.module.common.entity.SearchBean;
import com.sfac.springMvc.module.test.entity.Student;
import com.sfac.springMvc.module.test.repository.StudentRepository;
import com.sfac.springMvc.module.test.service.StudentService;

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
//		int i = 1 / 0;
		return new ResultEntity<Student>(ResultStatus.SUCCESS.status, "Update success.", student);
	}

	@Override
	public ResultEntity<Object> deleteStudentForJpa(Integer id) {
		studentRepository.deleteById(id);
		return new ResultEntity<Object>(ResultStatus.SUCCESS.status, "Delete success.");
	}

	@Override
	public Student getStudentByIdForJpa(Integer id) {
		return studentRepository.findById(id).orElse(null);
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

	@Override
	public Page<Student> getStudentsBySearchBeanForJpa(SearchBean searchBean) {
		searchBean.initSearchBean();
//		Page<Student> page = exampleAndPage(searchBean);
		Page<Student> page = criteriaAndPage(searchBean);
		return page;
	}
	
	/**
	 * -实现方式一：Example + Page 查询
	 */
	public Page<Student> exampleAndPage(SearchBean searchBean) {
		// 创建 Pageable 对象
		String orderBy = StringUtils.isBlank(searchBean.getOrderBy()) ? "id" : searchBean.getOrderBy();
		Sort.Direction direction = StringUtils.isBlank(searchBean.getDirection()) || 
				searchBean.getDirection().equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
		Sort sort = new Sort(direction, orderBy);
		// 当前页起始为 0
		Pageable pageable = PageRequest.of(searchBean.getCurrentPage() - 1, searchBean.getPageSize(), sort);
		
		// 创建 Example 对象
		Student student = new Student();
		student.setStudentName(searchBean.getKeyWord());
		student.setCreateDate(LocalDateTime.of(2021, 1, 19, 0, 0));
		// matchingAny 相当于 or 连接查询条件，matching 相当于 and 连接查询条件
		ExampleMatcher exampleMatcher = ExampleMatcher.matchingAny()
				// 模糊查询，即 %{studentName} %
				.withMatcher("studentName", match -> match.contains())
				// 时间类型不支持模糊查询，生成的语句为createDate=?，同时也不支持 id > startId && id < endId 这样的操作
				.withMatcher("createDate", match -> match.contains())
				// 忽略基本数据类型字段，如果使用包装类则无需忽略
				.withIgnorePaths("id");
		Example<Student> example = Example.of(student, exampleMatcher);
		
		return studentRepository.findAll(example, pageable);
	}
	
	/**
	 * -实现方式：Criteria + Page
	 */
	public Page<Student> criteriaAndPage(SearchBean searchBean) {
		// 创建 Pageable 对象
		String orderBy = StringUtils.isBlank(searchBean.getOrderBy()) ? "id" : searchBean.getOrderBy();
		Sort.Direction direction = StringUtils.isBlank(searchBean.getDirection()) || 
				searchBean.getDirection().equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
		Sort sort = new Sort(direction, orderBy);
		// 当前页起始为 0
		Pageable pageable = PageRequest.of(searchBean.getCurrentPage() - 1, searchBean.getPageSize(), sort);
		
		// 创建 Specification 对象
		Specification<Student> specification = new Specification<Student>() {
			private static final long serialVersionUID = 1L;

			/**
			 * -构造语句 select * from test_student where createDate>=? and 
			 * (studentName like ? or id between 10 and 20) order by id desc limit ?
			 */
			@Override
			public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, 
					CriteriaBuilder criteriaBuilder) {
				
				return criteriaBuilder.and(
					criteriaBuilder.greaterThanOrEqualTo(
						root.get("createDate").as(LocalDateTime.class), 
						LocalDateTime.of(2021, 1, 20, 0, 0)),
					criteriaBuilder.or(
						criteriaBuilder.like(root.get("studentName").as(String.class), 
								String.format("%%%s%%", searchBean.getKeyWord())),
						criteriaBuilder.between(root.get("id"), 10, 20)
					)
				);
			}
		};
		
		return studentRepository.findAll(specification, pageable);
	}

	@Override
	@Transactional("jpaTransactionManager")
	public ResultEntity<Student> updateStudentNameForJpa(Student student) {
		studentRepository.updateStudentName(student.getStudentName(), student.getId());
		return new ResultEntity<Student>(ResultStatus.SUCCESS.status, "Update success.", student);
	}
}
