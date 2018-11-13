package com.mystudent.model;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mystudent.repository.Processor;

@Entity
@Table(name = "student")
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	
	@Column(name = "name", nullable=false)
	@Size(min = 2, max = 30, message = "Bịa tên khác đi, từ 2-30 ký tự")
	@NotNull(message = "Nhập tên vào đã, đi đâu mà vội")
	private String name;

	@Column(name = "dob")
	private String dob;
	
	@OneToMany(mappedBy="student", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Mark> marks = new ArrayList<>();
	
	@JsonIgnoreProperties("students")
	@ManyToOne(fetch = FetchType.LAZY, targetEntity=Major.class, cascade=CascadeType.REFRESH)
	@JoinColumn(name = "MAJOR_ID", foreignKey = @ForeignKey (name="MAJOR_FK"), nullable=false, referencedColumnName="ID")
	private Major major;
	
	public Student() {
		super();
	}

	public Student(Integer id, String name, String dob) {
		this.id = id;
		this.name = name;
		this.dob = dob;
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
		this.name = Processor.processName(name);
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public List<Mark> getMarks() {
		return marks;
	}

	public void setMarks(List<Mark> marks) {
		this.marks = marks;
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major=major;
	}

}