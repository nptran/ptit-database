/**
 * 
 */
package com.mystudent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mystudent.model.Student;
import com.mystudent.model.Subject;

/**
 * @author Phuc Tran
 *
 */
public interface SubjectRepository extends CrudRepository<Subject, Integer>{

}
