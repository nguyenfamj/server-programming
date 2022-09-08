package com.server_programming.handling_list.controller;

import com.server_programming.handling_list.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class StudentController {

	@RequestMapping("/hello")
	public String students(Model model) {
		Student[] studentArray = new Student[] { new Student("Kate", "Cole"), new Student("Dan", "Brown"),
				new Student("Mike", "Mars") };
		model.addAttribute("students", studentArray);

		return "hello";
	}
}
