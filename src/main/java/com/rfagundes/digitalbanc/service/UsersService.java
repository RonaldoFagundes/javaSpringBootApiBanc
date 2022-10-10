package com.rfagundes.digitalbanc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfagundes.digitalbanc.domain.Users;
import com.rfagundes.digitalbanc.dtos.UsersDTO;
import com.rfagundes.digitalbanc.repositories.UsersRepository;
import com.rfagundes.digitalbanc.service.exceptions.DataIntegrityViolationException;
import com.rfagundes.digitalbanc.service.exceptions.ObjectNotFoundException;

@Service
public class UsersService {

	
	@Autowired
	private UsersRepository repository ;
	
	
	
	
	public Users findById(Integer id) {
		
		Optional<Users> obj = repository.findById(id);
		
		 return obj.orElseThrow( ()-> new ObjectNotFoundException(" User não encontrado! id: "+
		 id+" , Tipo: "+Users.class.getName() ) );
	}
	
	
	public List <Users> findAll(){
		return repository.findAll();  
	}
	
	
	public Users create(Users obj) {
		obj.setId(null);
		return repository.save(obj);
	}


	public Users update(Integer id, UsersDTO objDto) {
		Users obj = findById(id);				
		obj.setName(objDto.getName());
		obj.setLogin(objDto.getLogin());
		obj.setPassword(objDto.getPassword());		
		return repository.save(obj);
	}

	
	

	public void delete(Integer id) {		
		findById(id);
		
		try {
			repository.deleteById(id);	
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException(" Dado não pode ser deletado possui conta aberta !");
		}
		
	}
	
	
	
}
