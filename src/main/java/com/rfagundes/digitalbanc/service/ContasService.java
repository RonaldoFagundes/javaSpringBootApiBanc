package com.rfagundes.digitalbanc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfagundes.digitalbanc.domain.Contas;
import com.rfagundes.digitalbanc.domain.Users;
import com.rfagundes.digitalbanc.repositories.ContaRepository;
import com.rfagundes.digitalbanc.service.exceptions.DataIntegrityViolationException;
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



	public Contas update(Integer id, Contas obj) {		
		Contas newObj = findById(id);
		updateData(newObj,obj);
		return repository.save(newObj);
	}



	private void updateData(Contas newObj, Contas obj) {
	  newObj.setNumero(obj.getNumero());	
	  newObj.setTipo(obj.getTipo());
	  newObj.setSaldo(obj.getSaldo());
		
	}



	public Contas create(Integer id_user, Contas obj) {
		obj.setId(null);
		Users use = usersService.findById(id_user);
		obj.setUsers(use);
		return repository.save(obj);
	}


	
	
   /*
	public void delete(Integer id) {
		Contas obj = findById(id);
		repository.delete(obj);		
	}	
	*/
	
	
	
	 public void delete(Integer id) {		
		findById(id);
		
		try {
			repository.deleteById(id);	
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException(" Dado não pode ser deletado possui movimentação !");
		}
		
	}
	

	
	
	
	
	
	
}
