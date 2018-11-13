/**
 * 
 */
package com.mystudent.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

/**
 * @author Phuc Tran
 *
 */

@Entity
@Table(name="subject")
public class Subject implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	@Size(min = 2, max = 50, message="Tên môn học từ 2-50 ký tự")
	private String name;
	
	@OneToMany(mappedBy="subject", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Mark> marks = new ArrayList<>();
	
	@Transient
	private String major_id;
	
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name = "SUBJECT_MAJORS", joinColumns = { @JoinColumn(name = "SUBJECT_ID")}, 
								inverseJoinColumns = {	@JoinColumn(name = "MAJOR_ID")})
	private Set<Major> majors;
	
	public Subject() {
		super();
	}
	
	public Subject(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Mark> getMarks() {
		return marks;
	}

	public void setMarks(List<Mark> marks) {
		this.marks = marks;
	}

	public Set<Major> getMajors() {
		return majors;
	}

	public void setMajors(Set<Major> majors) {
		this.majors = majors;
	}

	public String getMajor_id() {
		return major_id;
	}

	public void setMajor_id(String major_id) {
		this.major_id = major_id;
	}
	
}
