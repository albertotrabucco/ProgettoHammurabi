package com.example.progettohammurabi.controller;


import com.example.progettohammurabi.model.Hammurabi;
import com.example.progettohammurabi.model.repository.HammurabiRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    /*public String creaTabella(){
        return HammurabiRepository.createTable();
    }*/

    @GetMapping("/dati")
    public List<Hammurabi> dati(){
        return HammurabiRepository.getDati();
    }
}
