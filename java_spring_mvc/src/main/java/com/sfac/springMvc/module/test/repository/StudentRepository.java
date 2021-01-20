package com.sfac.springMvc.module.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.sfac.springMvc.module.test.entity.Student;

/**
 * Description: Student Repository
 * @author HymanHu
 * @date 2021-01-18 14:13:24
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>, JpaSpecificationExecutor<Student> {
	
	List<Student> findByStudentName(String studentName);
	
}
