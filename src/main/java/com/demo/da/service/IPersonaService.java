package com.demo.da.service;

import com.demo.da.response.PersonaResponseRest;
import com.demo.da.response.ResponseRest;
import org.springframework.http.ResponseEntity;

public interface IPersonaService {

    public ResponseEntity<PersonaResponseRest> buscarPersonas();
    public ResponseEntity<ResponseRest> buscarPorRut(String rut, String fecha);
}
