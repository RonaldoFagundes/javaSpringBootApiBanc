package com.rfagundes.digitalbanc.service;

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
	
	
	
	
}
