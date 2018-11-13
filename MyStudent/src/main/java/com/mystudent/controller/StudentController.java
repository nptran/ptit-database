package com.mystudent.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mystudent.model.Student;
import com.mystudent.service.MajorService;
import com.mystudent.service.StudentService;
import com.mystudent.service.SubjectService;

@Controller
public class StudentController {
	
	private StudentService studentService;
	
	private SubjectService subjectService;
	
	private MajorService majorService;
	
	@Autowired
	public StudentController(StudentService studentService, SubjectService subjectService, MajorService majorService) {
		this.studentService = studentService;
		this.subjectService = subjectService;
		this.majorService = majorService;
	}
	
	@RequestMapping(path= {"/", "home"})
	public String home() {
		return "home";
	}
	
	@GetMapping(path = {"/student"})
	public String getAllStudent(Model model) {
		model.addAttribute("students", studentService.getAll());
		return "list";
	}

	@GetMapping("/student/create")
	public String createStudent(Model student, Model major) {
		student.addAttribute("student", new Student());
		major.addAttribute("majorsBind", majorService.getAll());
		return "form";
	}

	@PostMapping("/student/save")
	public String saveStudent(@Valid Student student, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "redirect:/student/create";
		}
		studentService.save(student);
		redirect.addFlashAttribute("success", "Saved student successfully!");
		return "redirect:/student";
	}

	@GetMapping("/student/edit-id={id}")
	public String edit(@PathVariable Integer id, @Valid Model model, Model major) {
		model.addAttribute("student", studentService.getOne(id));
		major.addAttribute("majorsBind",majorService.getAll());
		return "form-student-update";
	}

	@GetMapping("/student/{id}/delete")
	public String deleteStudent(@PathVariable Integer id, RedirectAttributes redirect) {
		studentService.delete(id);
		redirect.addFlashAttribute("success", "Deleted student successfully!");
		return "redirect:/student";
	}

	@GetMapping("/student/search")
	public String searchStudent(@RequestParam("s") String s, Model model) {
		if (s.equals("")) {
			return "redirect:/student";
		}

		model.addAttribute("students", studentService.search(s));
		return "list";
	}
	
	@GetMapping("/student/regiscourse-id={id}")
	public String registCourse(@PathVariable Integer id, @RequestParam Model student, Model subject) {
		student.addAttribute("student", studentService.getOne(id));
		subject.addAttribute("subjectsBind", subjectService.getAll());
		return "form-courseregistration";
	}
	
}