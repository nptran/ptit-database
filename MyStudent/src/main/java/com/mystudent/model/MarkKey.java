/**
 * 
 */
package com.mystudent.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Phuc Tran
 *
 */

@Embeddable
public class MarkKey implements Serializable {

	@Column(name="std_id", nullable=false)
	private Integer studentid;
	
	@Column(name="sub_id", nullable=false)
	private Integer subjectid;

	public Integer getStudentid() {
		return studentid;
	}

	public void setStudentid(Integer studentid) {
		this.studentid = studentid;
	}

	public Integer getSubjectid() {
		return subjectid;
	}

	public void setSubjectid(Integer subjectid) {
		this.subjectid = subjectid;
	}

}
