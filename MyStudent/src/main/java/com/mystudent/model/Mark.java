/**
 * 
 */
package com.mystudent.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Phuc Tran
 *
 */

@Entity
@Table(name="Mark")
public class Mark {
	
	@EmbeddedId
	private MarkKey id;
	
	private Double studentmark;

	public MarkKey getId() {
		return id;
	}

	public void setId(MarkKey id) {
		this.id = id;
	}

	public Double getStudentmark() {
		return studentmark;
	}

	public void setStudentmark(Double studentmark) {
		this.studentmark = studentmark;
	}

}
