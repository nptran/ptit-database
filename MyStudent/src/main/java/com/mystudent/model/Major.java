/**
 * 
 */
package com.mystudent.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Phuc Tran
 *
 */

@Entity
@Table(name="major")
public class Major implements Serializable {

	
	private static Set<String> idList = new HashSet<>();
	
	@Id
	private Integer id;
	
	@Column(name = "name")
	@Size(min = 1, max = 50, message = "Tên phải từ 1 đến 50 ký tự")
	private String name;
	
	@ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	@JoinTable(name = "SUBJECT_MAJORS", joinColumns = { @JoinColumn(name = "MAJOR_ID")}, 
								inverseJoinColumns = {	@JoinColumn(name = "SUBJECT_ID")})
	private Set<Subject> subjects;
	
	@JsonIgnoreProperties("major")
	@OneToMany(mappedBy="major", cascade= CascadeType.ALL)
	private Set<Student> students;
	
	public Major() {
		super();
	}

	public Major(Integer id, String name) {
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
		this.name=name;
	}
	

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

}
