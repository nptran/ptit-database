/**
 * 
 */
package com.mystudent.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mystudent.model.Major;
import com.mystudent.model.Subject;
import com.mystudent.service.MajorService;
import com.mystudent.service.SubjectService;

/**
 * @author Phuc Tran
 *
 */

@Controller
public class SubjectController {
	
	private SubjectService subjectService;
	
	private MajorService majorService;
	
	@Autowired
	public SubjectController(SubjectService subjectService, MajorService majorService) {
		this.subjectService = subjectService;
		this.majorService = majorService;
	}
	
	@GetMapping("/subject/create")
	public String createSubject(Model subject, Model major) {
		major.addAttribute("majorsBind", majorService.getAll());
		subject.addAttribute("subject", new Subject());
		return "form-subject";
	}
	
	//to save SUBJECT
	@PostMapping("/subject/save")
	public String saveSubject(@Valid Subject subject, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "redirect:/subject/create";
		}
		subjectService.save(subject);
		return "redirect:/home";
	}

}
