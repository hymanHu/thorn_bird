package com.sfac.springMvc.module.test.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.sfac.springMvc.module.common.entity.ResultEntity;
import com.sfac.springMvc.module.common.entity.SearchBean;
import com.sfac.springMvc.module.test.entity.Student;

/**
 * @Description: Student Service
 * @author: HymanHu
 * @date: 2021年1月16日
 */
public interface StudentService {

	ResultEntity<Student> insertStudentForHibernate(Student student);
	
	ResultEntity<Student> updateStudentForHibernate(Student student);
	
	ResultEntity<Object> deleteStudentForHibernate(Integer id);
	
	Student getStudentByIdForHibernate(Integer id);
	
	Student getStudentByNameForHibernate(String studentName);
	
	List<Student> getStudentsByNameForHibernate(String studentName);
	
	ResultEntity<Student> insertStudentForJpa(Student student);
	
	ResultEntity<Student> updateStudentForJpa(Student student);
	
	ResultEntity<Object> deleteStudentForJpa(Integer id);
	
	Student getStudentByIdForJpa(Integer id);
	
	Student getStudentByNameForJpa(String studentName);
	
	List<Student> getStudentsForJpa();
	
	Page<Student> getStudentsBySearchBeanForJpa(SearchBean searchBean);
	
	Student getStudentByIdV2ForJpa(Integer id);
	
	ResultEntity<Student> updateStudentNameForJpa(Student student);
}
