package com.rfagundes.digitalbanc.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfagundes.digitalbanc.domain.Contas;
import com.rfagundes.digitalbanc.dtos.ContasDTO;
import com.rfagundes.digitalbanc.service.ContasService;

@RestController
@RequestMapping(value="/contas")
public class ContasResource {

	
	@Autowired
	private ContasService service ;
	
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Contas> findById(@PathVariable Integer id){	 
		 Contas obj = service.findById(id);		 
		 return ResponseEntity.ok(obj);	
	}  
	
	
	@GetMapping
	public ResponseEntity<List<ContasDTO>> findAll(@RequestParam(value="users",defaultValue = "0")Integer id_user){
		
		List<Contas>list = service.findAll(id_user);
		List<ContasDTO> listDTO = list.stream().map(obj -> new ContasDTO (obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	
	
	
}
