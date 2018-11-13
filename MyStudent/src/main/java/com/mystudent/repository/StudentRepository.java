package com.mystudent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mystudent.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByNameContaining(String q);
    
//    @Query(value="INSERT INTO student (name,dob,major_id) VALUES (?1,?2,?3)", nativeQuery=true)
//    void create(String name, String dob, Major major);

}