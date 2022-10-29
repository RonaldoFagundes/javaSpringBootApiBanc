package com.rfagundes.digitalbanc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfagundes.digitalbanc.domain.Investimentos;
import com.rfagundes.digitalbanc.repositories.InvestimentosRepository;
import com.rfagundes.digitalbanc.service.exceptions.ObjectNotFoundException;



@Service
public class InvestimentosService {

	
	@Autowired
	private InvestimentosRepository repository ;
	
	
	
	public Investimentos findById (Integer id) {
		
		Optional<Investimentos> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Transação não encontrada! Id: "
				+id+" , Tipo "+Investimentos.class.getName()));
				
	}
	
	
	
	public List <Investimentos> findAll(){
		return repository.findAll();  
	}
	
	
	
	public Investimentos update(Integer id, Investimentos obj) {		
		Investimentos newObj = findById(id);
		updateData(newObj,obj);
		return repository.save(newObj);
	}



	private void updateData(Investimentos newObj, Investimentos obj) {
	   newObj.setNome(obj.getNome());
	   newObj.setTaxa(obj.getTaxa());
	}
	
	
	
	
	public Investimentos create(Investimentos obj) {
		obj.setId(null);
		return repository.save(obj);
	}


	public void delete(Integer id) {
	    Investimentos obj = findById(id);
	    repository.delete(obj);		
	}
	
	
}
