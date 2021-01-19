package com.sfac.springMvc.module.test.service;

import java.util.List;

import com.github.pagehelper.Page;
import com.sfac.springMvc.module.common.entity.ResultEntity;
import com.sfac.springMvc.module.common.entity.SearchBean;
import com.sfac.springMvc.module.test.entity.Student;

/**
 * @Description: Student Service
 * @author: HymanHu
 * @date: 2021年1月16日
 */
public interface StudentService {

	ResultEntity<Student> insertStudent(Student student);
	
	ResultEntity<Student> updateStudent(Student student);
	
	ResultEntity<Object> deleteStudent(Integer id);
	
	Student getStudentById(Integer id);
	
	Student getStudentByName(String studentName);
	
	List<Student> getStudentsByName(String studentName);
	
	ResultEntity<Student> insertStudentForJpa(Student student);
	
	ResultEntity<Student> updateStudentForJpa(Student student);
	
	ResultEntity<Object> deleteStudentForJpa(Integer id);
	
	Student getStudentByIdForJpa(Integer id);
	
	Student getStudentByNameForJpa(String studentName);
	
	List<Student> getStudentsForJpa();
	
	Page<Student> getStudentsBySearchBeanForJpa(SearchBean searchBean);
}
