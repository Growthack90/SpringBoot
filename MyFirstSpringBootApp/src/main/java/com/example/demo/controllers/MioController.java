package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MioController {

    @GetMapping("/search")
    public String search(@RequestParam(value = "query", defaultValue = "") String searchQuery) {
        if (searchQuery.isEmpty()) {
            return "Nessun parametro di ricerca fornito.";
        }
        return "Risultati per: " + searchQuery;
    }
}
