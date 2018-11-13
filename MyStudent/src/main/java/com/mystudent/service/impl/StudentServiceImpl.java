package com.mystudent.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mystudent.model.Student;
import com.mystudent.repository.StudentRepository;
import com.mystudent.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
    public void save(Student student) {
    	em.persist(student);
    }
	
	@Autowired
    private StudentRepository studentRepository;

    @Override
    public Iterable<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> search(String q) {
        return studentRepository.findByNameContaining(q);
    }

    @Override
    public Student getOne(Integer id) {
        return studentRepository.getOne(id);
    }

    @Override
    public void delete(Integer id) {
    	studentRepository.deleteById(id);
    }

}
