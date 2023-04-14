package com.demo.da.dao;

import com.demo.da.model.Persona;
import org.springframework.data.repository.CrudRepository;

public interface IPersonaDao extends CrudRepository<Persona,String> {
}
