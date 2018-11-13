/**
 * 
 */
package com.mystudent.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

/**
 * @author Phuc Tran
 *
 */

@Embeddable
public class MarkKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "student_id")
	private Integer studentId;
	
	@Column(name = "subject_id")
	private Integer subjectId;
	
	public MarkKey() {}
	
	public MarkKey(Integer studentid, Integer subjectid) {
		this.studentId=studentid;
		this.subjectId=subjectid;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass()) 
            return false;
 
        MarkKey that = (MarkKey) o;
        return Objects.equals(studentId, that.studentId) && 
               Objects.equals(subjectId, that.subjectId);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(studentId, subjectId);
    }
	
	public Integer getStudentid() {
		return studentId;
	}

	public void setStudentid(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getSubjectid() {
		return subjectId;
	}

	public void setSubjectid(Integer subjectId) {
		this.subjectId = subjectId;
	}
	
}
