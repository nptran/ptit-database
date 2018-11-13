/**
 * 
 */
package com.mystudent.service;

import java.util.List;
import java.util.Optional;

import com.mystudent.model.Mark;
import com.mystudent.model.MarkKey;

/**
 * @author Phuc Tran
 *
 */
public interface MarkService {

	Iterable<Mark> getAll();

//	List<String> getTop();
	
    Mark getOne(MarkKey id);
    
    void save(Mark mark);

}
