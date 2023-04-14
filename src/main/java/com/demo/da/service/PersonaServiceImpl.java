package com.demo.da.service;

import com.demo.da.dao.IPersonaDao;
import com.demo.da.model.Persona;
import com.demo.da.response.PersonaResponseRest;
import com.demo.da.response.ResponseRest;
import com.demo.da.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements IPersonaService{
    private static final Logger log = LoggerFactory.getLogger(PersonaServiceImpl.class);
    @Autowired
    private IPersonaDao personaDao;
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<PersonaResponseRest> buscarPersonas() {
        log.info("inicio metodo buscarPersona()");
        PersonaResponseRest response = new PersonaResponseRest();
        try{
            List<Persona> personas =(List<Persona>) personaDao.findAll();
            response.getPersonaResponse().setPersona(personas);
            response.setMetadata("200","Success","Respuesta exitosa");

        }catch (Exception e){
            response.setMetadata("500","Internal server error","Respuesta erronea");
            log.error("Error al consultar personas: ", e.getMessage());
            e.getStackTrace();
            new ResponseEntity<PersonaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<PersonaResponseRest>(response, HttpStatus.OK);
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<ResponseRest> buscarPorRut(String rut, String fecha) {
        log.info("inicio metodo buscarPorRut()");
        ResponseRest response = new ResponseRest();
        try{
            if(!Utils.verificarFecha(fecha)){
                log.error("Error con la fecha");
                response.setMetadata("400","Bad request","Fecha formato incorrecto. Prueba con dd-mm-yyyy");
                return new ResponseEntity<ResponseRest>(response, HttpStatus.BAD_REQUEST);
            }
            String dv = Utils.digitoVerificador(rut);
            if(dv=="400"){
                log.error("Error con el Rut");
                response.setMetadata("400","Bad request","Rut formato incorrecto.");
                return new ResponseEntity<ResponseRest>(response, HttpStatus.BAD_REQUEST);
            }
            rut = rut+"-"+dv;
            log.info("Rut a consultar es el siguiente: ",rut);
            Optional<Persona> persona = personaDao.findById(rut);
            if(persona.isPresent()){
                String fechaNacimiento = persona.get().getFechaNacimiento();
                if (fechaNacimiento.equals(fecha)){
                    response.setMetadata("200","Succes","Persona y fechas coinciden");
                    return new ResponseEntity<ResponseRest>(response, HttpStatus.OK);
                }
                log.error("Error al consultar la persona");
                response.setMetadata("404","Not found","Persona no coincide con la fecha");
                return new ResponseEntity<ResponseRest>(response, HttpStatus.NOT_FOUND);
            }
            log.error("Error al consultar la persona");
            response.setMetadata("404","Not found","Persona no encontrada");
            return new ResponseEntity<ResponseRest>(response, HttpStatus.NOT_FOUND);
        }catch (Exception e){
            response.setMetadata("500","Internal server error","Respuesta erronea");
            log.error("Error al consultar personas: ", e.getMessage());
            e.getStackTrace();
            return new ResponseEntity<ResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
