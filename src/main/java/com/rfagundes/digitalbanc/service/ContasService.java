package com.rfagundes.digitalbanc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfagundes.digitalbanc.domain.Contas;
import com.rfagundes.digitalbanc.repositories.ContaRepository;
import com.rfagundes.digitalbanc.service.exceptions.ObjectNotFoundException;

@Service
public class ContasService {

	
	@Autowired
	private ContaRepository repository ;
	
	@Autowired
	private UsersService usersService ;
	
	
	public Contas findById (Integer id) {
		
		Optional<Contas> obj = repository.findById(id);
return obj.orElseThrow(() -> new ObjectNotFoundException("Conta não encontrada! Id: "
		+id+" , Tipo "+Contas.class.getName()));
		
	}


  
	public List<Contas> findAll(Integer id_user) {
		usersService.findById(id_user);
		return repository.findAllByUser(id_user);
	}
	
	
	
	
	
	
}
