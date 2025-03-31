package com.kintado.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Dati.Rubrica;
import Dati.Contatto;

@RestController
@RequestMapping("/contatti")
public class MioController {
	
	
	@GetMapping("/")
	public List<Contatto> getContatti() {
		System.out.println("Chiamata GET a / ... restituisce la lista di contatti");
		Rubrica rubrica = new Rubrica();
		if (rubrica != null) {
			return rubrica.getContatti();
		} 
		return null;
	}
	
	@GetMapping("/{id}")
	public Contatto getContatto(@PathVariable("id") int id) {
		
		System.out.println("Chiamata a /api/contatti/" + id);
		
		Rubrica rubrica = new Rubrica();
		if (rubrica != null) {
			return rubrica.getContatto(id);
		}
		return null;
	}
	
	@PostMapping("/")
	public Contatto addContatto(@RequestBody Contatto contatto) {
		Contatto res = null;
		
		if (contatto.getId()==null)
		{
			System.out.println("Chiamata POST SALVA  un contatto");
			Rubrica rubrica = new Rubrica();
			if (rubrica != null) {
				System.out.println("Pronto a salvare il contatto");
				res = rubrica.saveContatto(contatto);
			}
		}
		return res;	
	}
	
	
	@PutMapping("/{id}")
	public Contatto updateContatto(@PathVariable("id") int id, @RequestBody Contatto contatto)
	{
		System.out.println("Chiamata POST per modificare il contatto con id = " + id);
		Contatto res = null;		
		contatto.setId(id);
        System.out.println("Chiamata POST per modificare il contatto con id = " + id);
        Rubrica rubrica = new Rubrica();
        if (rubrica != null) {
            System.out.println("Pronto a modificare il contatto");
            res = rubrica.saveContatto(contatto);
        }
		return res;
	}
	
	
	@DeleteMapping("/{id}")
	public int deleteContatto(@PathVariable("id") int id) {
		System.out.println("Chiamata DELETE per eliminare il contatto con id = " + id);
		Rubrica rubrica = new Rubrica();
		if (rubrica != null) {
			rubrica.deleteContatto(id);
			return 1;
		}
		return 0;
	}

}