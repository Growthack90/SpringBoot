package com.kintado.controllers;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kintado.services.CorsoService;
import com.kintado.services.StudenteService;
import com.kintado.services.UtenteService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.kintado.DTO.SessionUserDTO;
import com.kintado.DTO.UtenteDTO;
import com.kintado.entities.Corso;
import com.kintado.entities.Studente;
import com.kintado.entities.Utente;

@RestController
@RequestMapping("/api")
public class ControllerDelProfFIGO {
	
	@Autowired
	private StudenteService studenteService;
	
	@Autowired
	private CorsoService corsoService;
	
	@Autowired
	private UtenteService utenteService;

	
	@GetMapping("/tuttiglistudenti")
	public List<Studente> getAllStudenti() {
		return studenteService.getAllStudenti();
	}
	
	@GetMapping("/tuttiicorsi")
	public List<Corso> getAllCorsi() {
		return corsoService.getAllCorsi();
	}
	
	 @GetMapping("/encrypt")
	    public String encrypt(@RequestParam String text) {
	        // Usiamo BCrypt per "criptare" (in realtà hashare) il testo
		 	return BCrypt.hashpw(text, BCrypt.gensalt());
	    }
	/*
	 @PostMapping("/add")
	    public Utente addUser(@RequestBody Utente utente) {
		 	Utente savedUser = utente;
	        // Il service cripta la password internamente, quindi basta passare l'utente con la password in chiaro.
	     //   Utente 
		 	savedUser = utenteService.saveUtente(utente);
	        //return ResponseEntity.ok(savedUser);
	        return savedUser;
	    }
	  
*/
 	 @PostMapping("/add")

	 public UtenteDTO addUser(@RequestBody Utente utente) {
	     Utente savedUser = utenteService.saveUtente(utente);
	     return new UtenteDTO(savedUser.getId(), savedUser.getEmail(), savedUser.getActive());
	 }

	
	 @GetMapping("/tuttiutenti")
	 public List<UtenteDTO> getAllUtenti() {
	   
		return utenteService.getAllUtenti().stream()
	         .map(u -> new UtenteDTO(u.getId(), u.getEmail(), u.getActive()))
	         .collect(Collectors.toList());
	        
	 }
	/* 
	 @PostMapping("/login")
		public SessionUserDTO login(@RequestBody Utente utente) {
		 	SessionUserDTO loggedUser  = utenteService.login(utente.getEmail(), utente.getPassword());
		 	         
		 	return loggedUser;            
        }
		 
	 }
	 */

}
