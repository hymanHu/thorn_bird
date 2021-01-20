package com.sfac.springMvc.module.test.controller;

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

import com.sfac.springMvc.module.common.entity.ResultEntity;
import com.sfac.springMvc.module.common.entity.SearchBean;
import com.sfac.springMvc.module.test.entity.Student;
import com.sfac.springMvc.module.test.service.StudentService;

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
	 * 127.0.0.1/api/student ---- post
	 * {"studentName":"HymanHu"}
	 * {"studentName":"HymanHu", "studentCard":{"cardNo":"studentCard001"}}
	 */
	@PostMapping(value = "/student", consumes = "application/json")
	public ResultEntity<Student> insertStudent(@RequestBody Student student) {
//		return studentService.insertStudent(student);
		return studentService.insertStudentForJpa(student);
	}
	
	/**
	 * 127.0.0.1/api/student ---- put
	 * {"id":"2","studentName":"HymanHu1"}
	 * {"id":"2","studentName":"HymanHu1","studentCard":{"id":"1","cardNo":"studentCard002"}}
	 */
	@PutMapping(value = "/student", consumes = "application/json")
	public ResultEntity<Student> updateStudent(@RequestBody Student student) {
//		return studentService.updateStudent(student);
		return studentService.updateStudentForJpa(student);
	}
	
	/**
	 * 127.0.0.1/api/student/2 ---- delete
	 */
	@DeleteMapping("/student/{id}")
	public ResultEntity<Object> deleteStudent(@PathVariable Integer id) {
//		return studentService.deleteStudent(id);
		return studentService.deleteStudentForJpa(id);
	}
	
	/**
	 * 127.0.0.1/api/student/9 ---- get
	 */
	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable Integer id) {
//		return studentService.getStudentById(id);
		return studentService.getStudentByIdForJpa(id);
	}
	
	/**
	 * 127.0.0.1/api/student?studentName=HymanHu ---- get
	 */
	@GetMapping("/student")
	public Student getStudentByName(@RequestParam String studentName) {
//		return studentService.getStudentByName(studentName);
		return studentService.getStudentByNameForJpa(studentName);
	}
	
	/**
	 * 127.0.0.1/api/students?studentName=HymanHu ---- get
	 */
	@GetMapping("/students")
	public List<Student> getStudents(@RequestParam(required = false) String studentName) {
//		return studentService.getStudentsByName(studentName);
		return studentService.getStudentsForJpa();
	}
	
	/**
	 * 127.0.0.1/api/students ---- post
	 * {"currentPage":1, "pageSize":5, "keyWord":"hy", "orderBy":"id", "direction":"desc"}
	 * 
	 */
	@PostMapping(value = "/students", consumes = "application/json")
	public Page<Student> getStudentsBySearchBeanForJpa(@RequestBody SearchBean searchBean) {
		return studentService.getStudentsBySearchBeanForJpa(searchBean);
	}
	
	/**
	 * 127.0.0.1/api/student/v2 ---- put
	 * {"id":"1","studentName":"HymanHu1"}
	 */
	@PutMapping(value = "/student/v2",consumes = "application/json")
	public ResultEntity<Student> updateStudentNameForJpa(@RequestBody Student student) {
		return studentService.updateStudentNameForJpa(student);
	}
}
