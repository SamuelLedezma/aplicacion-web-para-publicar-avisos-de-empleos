package com.ledezma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/categorias")
public class CategoriasController {
	//@GetMapping("/index")
	@RequestMapping(value= "/index" , method=RequestMethod.GET)
	public String mostrarIndex(Model model) {
		return "categorias/listCategorias";
	}
	//@GetMapping("/create")
	@RequestMapping(value= "/create" , method=RequestMethod.GET)
	public String crear() {
		return "categorias/formCategorias";
	}
	//PostMapping("/salve)
	@RequestMapping(value="/salve" , method=RequestMethod.POST)
	public String guardar() {
		return "categorias/listCategorias";
		
	}
}
