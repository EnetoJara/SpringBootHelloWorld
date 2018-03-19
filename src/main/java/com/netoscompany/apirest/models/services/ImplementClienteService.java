package com.netoscompany.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netoscompany.apirest.models.dao.ClienteDAO;
import com.netoscompany.apirest.models.entity.Cliente;

@Service
public class ImplementClienteService implements ClienteService {

	@Autowired
	private ClienteDAO dao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return (List<Cliente>) dao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		// TODO Auto-generated method stub
		return dao.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		dao.deleteById(id);
	}
	
}
