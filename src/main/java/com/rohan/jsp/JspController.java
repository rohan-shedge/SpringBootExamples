package com.rohan.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JspController {
	@GetMapping(path = "contacts")
	public String getOutput() {
		System.out.println("This is a contacts page");
		return "contact";
	}
}
