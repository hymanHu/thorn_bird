package com.sfac.springMvc.module.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
	
//	@Query(nativeQuery = true, value = "select * from test_student where id = :id")
	@Query(value = "from Student where id = :id")
	Student getStudentById(@Param("id") Integer id);
	
	@Modifying
//	@Query(nativeQuery = true, value = "update test_student set student_name = :studentName where id = :id")
	@Query(value = "update Student set studentName = :studentName where id = :id")
	void updateStudentName(@Param("studentName") String studentName, @Param("id") Integer id);
}
