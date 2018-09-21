package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}
	
	@RequestMapping("/challenge")
	public String challenge(@RequestParam(value="name") String name, Model model) {
		model.addAttribute("name",name);
		return "challenge";
	}
	
	@RequestMapping("/challenge/{name}")
	public String challengePath(@PathVariable String name, Model model) {
		model.addAttribute("name", name);
		return "challenge";
	}
	
	@RequestMapping("/generator")
	public String viralGenerator(@RequestParam(value = "a", required = false, defaultValue = "0") int a,
			@RequestParam(value = "b", required = false, defaultValue = "0") int b, Model model) {
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		String m = "m";
		String h = "h";
		String hasil = "";
		
		for (int i = 0 ; i < b ; i++) {
			hasil += h;
			for(int j = 0 ; j < a  ; j++) {
				hasil += m;
			}
			hasil += " ";
		}
			
		model.addAttribute("hm", hasil);
		
		
		return "generator";
	}
	
	
}
