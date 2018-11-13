/**
 * 
 */
package com.mystudent.service;

import java.util.List;

import com.mystudent.model.Major;
import com.mystudent.model.Student;

/**
 * @author Phuc Tran
 *
 */
public interface MajorService {

	Iterable<Major> getAll();
	
	void save(Major major);
	
	boolean isFound(Integer id);
}
