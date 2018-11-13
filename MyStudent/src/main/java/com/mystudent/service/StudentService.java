package com.mystudent.service;

import java.util.List;
import java.util.Optional;

import com.mystudent.model.Student;

public interface StudentService {
	
	Iterable<Student> getAll();

    List<Student> search(String q);

    Optional<Student> getOne(Integer id);
    
    Student getForMark(Integer id);
    
    void save(Student contact);

    void delete(Integer id);
    
}
