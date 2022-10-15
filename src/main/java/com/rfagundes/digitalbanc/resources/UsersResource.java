package com.rfagundes.digitalbanc.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rfagundes.digitalbanc.domain.Users;
import com.rfagundes.digitalbanc.dtos.UsersDTO;
import com.rfagundes.digitalbanc.service.UsersService;



@RestController
@RequestMapping(value="/users")
public class UsersResource {

	
	@Autowired
	private UsersService service ;
	
	
	@GetMapping(value="/{id}")
	public ResponseEntity <Users> findById(@PathVariable Integer id){		
	   Users obj  = service.findById(id);	   
	   return ResponseEntity.ok().body(obj);
	}
	
	
	@GetMapping
	public ResponseEntity<List<UsersDTO>> findAll() {
		List<Users> list = service.findAll();
		List<UsersDTO> listDTO = list.stream().map(obj -> new UsersDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<Users> create(@Valid @RequestBody Users obj) {
	 obj = service.create(obj);
	 URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
	 return ResponseEntity.created(uri).build();		
	}
	
	
	@PutMapping(value="/{id}")
	public ResponseEntity<UsersDTO> update (@Valid @PathVariable Integer id, @RequestBody UsersDTO objDto ){
		Users newObj = service.update(id, objDto);
		return ResponseEntity.ok().body(new UsersDTO(newObj));
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete (@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
