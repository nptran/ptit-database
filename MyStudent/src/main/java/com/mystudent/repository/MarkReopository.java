/**
 * 
 */
package com.mystudent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mystudent.model.Mark;
import com.mystudent.model.MarkKey;

/**
 * @author Phuc Tran
 *
 */

public interface MarkReopository extends JpaRepository<Mark, MarkKey> {

	@Query(value="INSERT INTO `mark` (`studentmark`, `student_id`, `subject_id`) VALUES (?, ?, ?)",nativeQuery=true)
	void insertMark(Integer studentmark, Integer student, Integer subject);
	
}
