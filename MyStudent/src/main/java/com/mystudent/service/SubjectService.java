/**
 * 
 */
package com.mystudent.service;

import java.util.List;
import java.util.Optional;

import com.mystudent.model.Student;
import com.mystudent.model.Subject;

/**
 * @author Phuc Tran
 *
 */
public interface SubjectService {
	
	Iterable<Subject> getAll();
	
	Optional<Subject> getOne(Integer id);
	
	void save(Subject subject);
	
//	List<Student> getStudentFrom();

}
