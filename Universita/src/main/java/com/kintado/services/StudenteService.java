package com.kintado.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kintado.entities.Studente;
import com.kintado.repositories.StudenteRepository;

@Service
public class StudenteService {
	
	@Autowired
	private StudenteRepository studenteRepository;
	
	public List<Studente> getAllStudenti() {
        return studenteRepository.findAll();
    }

}
