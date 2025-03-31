package com.kintado.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kintado.entities.Corso;
import com.kintado.entities.Studente;
import com.kintado.repositories.CorsoRepository;
import com.kintado.repositories.StudenteRepository;

@Service
public class CorsoService {
	
	@Autowired
	private CorsoRepository corsoRepository;
	
	public List<Corso> getAllCorsi() {
        return corsoRepository.findAll();
    }

}
