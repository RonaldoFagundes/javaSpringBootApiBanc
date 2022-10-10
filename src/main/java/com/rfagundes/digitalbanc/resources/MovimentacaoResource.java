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

import com.rfagundes.digitalbanc.domain.Movimentacao;
import com.rfagundes.digitalbanc.dtos.MovimentacaoDTO;
import com.rfagundes.digitalbanc.service.MovimentacaoService;



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
	
	
	 
	
}
