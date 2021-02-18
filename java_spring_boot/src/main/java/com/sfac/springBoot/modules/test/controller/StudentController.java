package com.sfac.springBoot.modules.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sfac.springBoot.modules.common.entity.ResultEntity;
import com.sfac.springBoot.modules.common.entity.SearchBean;
import com.sfac.springBoot.modules.test.entity.Student;
import com.sfac.springBoot.modules.test.service.StudentService;

/**
 * @Description: Student Controller
 * @author: HymanHu
 * @date: 2021年1月16日
 */
@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	/**
	 * 127.0.0.1/api/jpa/student ---- post
	 * {"studentName":"HymanHu"}
	 * {"studentName":"HymanHu", "studentCard":{"cardNo":"studentCard001"}}
	 */
	@PostMapping(value = "/jpa/student", consumes = "application/json")
	public ResultEntity<Student> insertStudentForJpa(@RequestBody Student student) {
		return studentService.insertStudentForJpa(student);
	}
	
	/**
	 * 127.0.0.1/api/jpa/student ---- put
	 * {"id":"2","studentName":"HymanHu1"}
	 * {"id":"2","studentName":"HymanHu1","studentCard":{"id":"1","cardNo":"studentCard002"}}
	 */
	@PutMapping(value = "/jpa/student", consumes = "application/json")
	public ResultEntity<Student> updateStudentForJpa(@RequestBody Student student) {
		return studentService.updateStudentForJpa(student);
	}
	
	/**
	 * 127.0.0.1/api/jpa/student/2 ---- delete
	 */
	@DeleteMapping("/jpa/student/{id}")
	public ResultEntity<Object> deleteStudentForJpa(@PathVariable Integer id) {
		return studentService.deleteStudentForJpa(id);
	}
	
	/**
	 * 127.0.0.1/api/jpa/student/9 ---- get
	 */
	@GetMapping("/jpa/student/{id}")
	public Student getStudentByIdForJpa(@PathVariable Integer id) {
		return studentService.getStudentByIdForJpa(id);
	}
	
	/**
	 * 127.0.0.1/api/jpa/student?studentName=HymanHu ---- get
	 */
	@GetMapping("/jpa/student")
	public Student getStudentByNameForJpa(@RequestParam String studentName) {
		return studentService.getStudentByNameForJpa(studentName);
	}
	
	/**
	 * 127.0.0.1/api/jpa/students ---- get
	 */
	@GetMapping("/jpa/students")
	public List<Student> getStudentsForJpa(@RequestParam(required = false) String studentName) {
		return studentService.getStudentsForJpa();
	}
	
	/**
	 * 127.0.0.1/api/jpa/students ---- post
	 * {"currentPage":1, "pageSize":5, "keyWord":"hy", "orderBy":"id", "direction":"desc"}
	 * 
	 */
	@PostMapping(value = "/jpa/students", consumes = "application/json")
	public Page<Student> getStudentsBySearchBeanForJpa(@RequestBody SearchBean searchBean) {
		return studentService.getStudentsBySearchBeanForJpa(searchBean);
	}
	
	/**
	 * 127.0.0.1/api/jpa/student/2/v2 ---- get
	 */
	@GetMapping("/jpa/student/{id}/v2")
	public Student getStudentByIdV2ForJpa(@PathVariable Integer id) {
		return studentService.getStudentByIdV2ForJpa(id);
	}
	
	/**
	 * 127.0.0.1/api/jpa/student/v2 ---- put
	 * {"id":"1","studentName":"HymanHu1"}
	 */
	@PutMapping(value = "/jpa/student/v2",consumes = "application/json")
	public ResultEntity<Student> updateStudentNameForJpa(@RequestBody Student student) {
		return studentService.updateStudentNameForJpa(student);
	}
}
