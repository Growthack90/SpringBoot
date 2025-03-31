package com.kintado.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kintado.entities.Utente;
import com.kintado.repositories.UtenteRepository;

@Service
public class UtenteService {
	
    private final UtenteRepository utenteRepository;    
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UtenteService(UtenteRepository utenteRepository, PasswordEncoder passwordEncoder) {
        this.utenteRepository = utenteRepository;
        this.passwordEncoder = passwordEncoder;
        

        
    }

    // Salva l'utente con la password criptata
    public Utente saveUtente(Utente utente) {
        // Cripta la password prima del salvataggio
    	utente.setPassword(passwordEncoder.encode(utente.getPassword()));               
        System.out.println("Password criptata: " + utente.getPassword());
        return utenteRepository.save(utente);
    }
    
    public List<Utente> getAllUtenti() {
        return utenteRepository.findAll();
    }
}
