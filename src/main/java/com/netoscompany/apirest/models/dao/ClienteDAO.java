package com.netoscompany.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.netoscompany.apirest.models.entity.Cliente;

public interface ClienteDAO extends CrudRepository<Cliente, Long> {
	
}
