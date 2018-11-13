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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mystudent.model.Major;
import com.mystudent.model.Student;
import com.mystudent.service.MajorService;

/**
 * @author Phuc Tran
 *
 */

@Controller
public class MajorController {

	private MajorService majorService;
	
	/**
	 * 
	 */
	public MajorController(MajorService majorService) {
		this.majorService = majorService;
	}
	
	@GetMapping("/major/create")
	public String createMajor(Model major) {
		major.addAttribute("major", new Major());
		return "form-major";
	}
	
	//to save MAJOR
	@PostMapping("/major/save")
	public String saveMajor(@Valid Major major, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "form-major";
		}
		majorService.save(major);
		return "redirect:/home";
	}
}
