/**
 * 
 */
package com.mystudent.controller;

import javax.persistence.PrePersist;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mystudent.model.Mark;
import com.mystudent.model.MarkKey;
import com.mystudent.service.MarkService;
import com.mystudent.service.StudentService;
import com.mystudent.service.SubjectService;

/**
 * @author Phuc Tran
 *
 */

@Controller
public class MarkController {

	
	private SubjectService subjectService;
	
	private StudentService studentService;
	
	private MarkService markService;
	
	@Autowired
	public MarkController(SubjectService subjectService, StudentService studentService, MarkService markService) {
		this.subjectService = subjectService;
		this.studentService = studentService;
		this.markService = markService;
	}
	
	@GetMapping("/mark/add")
	public String createMark(Model mark) {
		mark.addAttribute("mark", new Mark());
		return "form-mark";
	}
	
	//to save SUBJECT
	@PostMapping("/mark/save")
	public String saveMark(@Valid Mark mark, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "redirect:/mark/add";
		}
		
		markService.save(mark);
		return "redirect:/home";
	}

	
}
