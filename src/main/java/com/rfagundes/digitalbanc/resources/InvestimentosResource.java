package com.rfagundes.digitalbanc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rfagundes.digitalbanc.domain.Investimentos;
import com.rfagundes.digitalbanc.service.InvestimentosService;



@RestController
@RequestMapping(value="/investimentos")
public class InvestimentosResource {
	
	@Autowired
	private InvestimentosService service ;
	
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Investimentos>findById(@PathVariable Integer id){
		
		Investimentos obj = service.findById(id);
		 
		 return ResponseEntity.ok(obj);	
	}

}
