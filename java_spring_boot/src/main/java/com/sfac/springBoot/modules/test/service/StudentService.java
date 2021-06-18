package com.sfac.springBoot.modules.test.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.sfac.springBoot.modules.common.entity.ResultEntity;
import com.sfac.springBoot.modules.common.entity.SearchBean;
import com.sfac.springBoot.modules.test.entity.Student;

/**
 * @Description: Student Service
 * @author: HymanHu
 * @date: 2021年1月16日
 */
public interface StudentService {

	ResultEntity<Student> insertStudentForJpa(Student student);
	
	ResultEntity<Student> updateStudentForJpa(Student student);
	
	ResultEntity<Object> deleteStudentForJpa(Integer id);
	
	Student getStudentByIdForJpa(Integer id);
	
	Student getStudentByNameForJpa(String studentName);
	
	List<Student> getStudentsForJpa();
	
	Page<Student> getStudentsBySearchBeanForJpa(SearchBean searchBean);
	
	Student getStudentByIdV2ForJpa(Integer id);
	
	ResultEntity<Student> updateStudentNameForJpa(Student student);
	
	ResultEntity<List<Student>> batchInsertStudentsForJpa(List<Student> students);
}
