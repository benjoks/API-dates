package com.demo.da.controller;

import com.demo.da.response.PersonaResponse;
import com.demo.da.response.PersonaResponseRest;
import com.demo.da.response.ResponseRest;
import com.demo.da.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class PersonaRestController {
    @Autowired
    private IPersonaService service;

    @GetMapping("/personas")
    public ResponseEntity<PersonaResponseRest> consultaPersona() {
        ResponseEntity<PersonaResponseRest> response = service.buscarPersonas();
        return response;
    }
    @GetMapping("/personas/{rut}/nacimiento/{fecha}")
    public ResponseEntity<ResponseRest> consultaPorRut(@PathVariable String rut, @PathVariable String fecha){
        ResponseEntity<ResponseRest> response =service.buscarPorRut(rut,fecha);
        return response;
    }
}
