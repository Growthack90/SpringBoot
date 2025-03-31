package com.kintado.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Dati.Rubrica;
import Dati.Contatto;

@RestController
@RequestMapping("/api")
public class MioController {
	
	
	@GetMapping("/contatti")
	public List<Contatto> getContatti() {
		System.out.println("Chiamata a /api/cont");
		Rubrica rubrica = new Rubrica();
		if (rubrica != null) {
			return rubrica.getContatti();
		} 
		return null;
	}
	
	@GetMapping("/contatti/{id}")
	public Contatto getContatto(@PathVariable("id") int id) {
		
		System.out.println("Chiamata a /api/contatti/" + id);
		
		Rubrica rubrica = new Rubrica();
		if (rubrica != null) {
			return rubrica.getContatto(id);
		}
		return null;
	}
	

}
