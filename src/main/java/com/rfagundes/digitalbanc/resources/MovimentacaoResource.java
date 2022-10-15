package com.rfagundes.digitalbanc.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rfagundes.digitalbanc.domain.Movimentacao;
import com.rfagundes.digitalbanc.dtos.MovimentacaoDTO;
import com.rfagundes.digitalbanc.service.MovimentacaoService;


@CrossOrigin("*")
@RestController
@RequestMapping(value="/movimentacao")
public class MovimentacaoResource {

	
	
	@Autowired
	private MovimentacaoService service ;
	
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Movimentacao> findById(@PathVariable Integer id){
	 
		 Movimentacao obj = service.findById(id);
		 
		 return ResponseEntity.ok(obj);	
	}  
	
	
	
	@GetMapping
	public ResponseEntity<List<MovimentacaoDTO>> findAll(@RequestParam(value="contas",defaultValue = "0")Integer id_conta){
		List<Movimentacao>list = service.findAll(id_conta);
		List<MovimentacaoDTO> listDTO = list.stream().map(obj -> new MovimentacaoDTO (obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Movimentacao> update(@PathVariable Integer id, @RequestBody Movimentacao obj){
		Movimentacao newObj = service.update(id,obj);
		return ResponseEntity.ok().body(newObj);
	}
	 
	
	
	@PostMapping
	public ResponseEntity<Movimentacao>create(@RequestParam(value="contas", defaultValue = "0") Integer id_conta,
			@RequestBody Movimentacao obj){
		Movimentacao newObj = service.create(id_conta, obj);
		  URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/movimentacao/{id}").buildAndExpand(newObj.getId()).toUri();
		  return ResponseEntity.created(uri).build();
	 }
	
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void>delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
	
	
	
}
