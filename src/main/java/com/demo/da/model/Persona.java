package com.demo.da.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="personas")
public class Persona implements Serializable {

    @Id
    @GeneratedValue
    private String rut;
    private String nombre;
    private String fechaNacimiento;

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

}
