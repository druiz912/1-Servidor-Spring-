package com.peliculeo.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListaPelisController {
	@GetMapping("/listaPelis")
	public String listaPelis() {
		return "listaPelis";
	}
}