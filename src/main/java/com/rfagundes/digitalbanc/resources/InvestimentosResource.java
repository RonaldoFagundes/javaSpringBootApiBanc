package com.rfagundes.digitalbanc.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Investimentos> update(@PathVariable Integer id, @RequestBody Investimentos obj){
		Investimentos newObj = service.update(id,obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	
	@PostMapping
	public ResponseEntity<Investimentos> create(@RequestBody Investimentos obj) {
	 obj = service.create(obj);
	 URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
	 return ResponseEntity.created(uri).build();		
	}
	
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void>delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	

	
	
}
