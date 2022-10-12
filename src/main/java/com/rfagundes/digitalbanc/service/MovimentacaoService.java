package com.rfagundes.digitalbanc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfagundes.digitalbanc.domain.Contas;
import com.rfagundes.digitalbanc.domain.Movimentacao;
import com.rfagundes.digitalbanc.repositories.MovimentacaoRepository;
import com.rfagundes.digitalbanc.service.exceptions.ObjectNotFoundException;



@Service
public class MovimentacaoService {

	
	
	@Autowired
	private MovimentacaoRepository repository ;
	
	
	@Autowired
	private ContasService contasService ;
	
	
	public Movimentacao findById (Integer id) {
		
		Optional<Movimentacao> obj = repository.findById(id);
return obj.orElseThrow(() -> new ObjectNotFoundException("Transação não encontrada! Id: "
		+id+" , Tipo "+Movimentacao.class.getName()));
		
	}
	
	
	public List<Movimentacao> findAll(Integer id_conta) {
		contasService.findById(id_conta);
		return repository.findAllByConta(id_conta);
	}
	

	
	public Movimentacao update(Integer id, Movimentacao obj) {		
		Movimentacao newObj = findById(id);
		updateData(newObj,obj);
		return repository.save(newObj);
	}



	private void updateData(Movimentacao newObj, Movimentacao obj) {
		newObj.setDescricao(obj.getDescricao());
		newObj.setTipo(obj.getTipo());
		newObj.setValor(obj.getValor()); 
	}
	
	
	public Movimentacao create(Integer id_conta, Movimentacao obj) {
		obj.setId(null);
		Contas conta = contasService.findById(id_conta);
		obj.setContas(conta);
		return repository.save(obj);
	}


	
}
