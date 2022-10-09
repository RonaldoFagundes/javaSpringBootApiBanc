package com.rfagundes.digitalbanc.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfagundes.digitalbanc.domain.Contas;
import com.rfagundes.digitalbanc.domain.Investimentos;
import com.rfagundes.digitalbanc.domain.Movimentacao;
import com.rfagundes.digitalbanc.domain.Users;
import com.rfagundes.digitalbanc.repositories.ContaRepository;
import com.rfagundes.digitalbanc.repositories.InvestimentosRepository;
import com.rfagundes.digitalbanc.repositories.MovimentacaoRepository;
import com.rfagundes.digitalbanc.repositories.UsersRepository;

@Service
public class DBService {
	
	
	@Autowired
	private UsersRepository userRepository ;
	
	@Autowired
	private ContaRepository contaRepository ;	
		
	@Autowired
	private MovimentacaoRepository movimentacaoRepository ;
	
	@Autowired
	private InvestimentosRepository investimentosRepository;
	
	
	
	
	
	
	public void instanciaBaseDeDados() {
		
        Users user_one = new Users(null, "Nikolau Tesla", "cAlternada", "123");	        
       // Users user_two = new Users(null, "Thomas Edison", "cContinua", "456");        
		
		Contas conta_one = new Contas(null, "Investimento", "1313", 900, user_one) ;
		Contas conta_two = new Contas(null, "Popança", "8247", 600, user_one) ; 
		
		Movimentacao movi_one = new Movimentacao(null, "Salário", "mes 09", 1200, conta_one);
		Movimentacao movi_two = new Movimentacao(null, "Gerador", "mes 06", 1800, conta_two);
		
		
		Investimentos invest_one = new Investimentos(null,"Selic", 13.5);
				
				
		user_one.getContas().addAll(Arrays.asList(conta_one));		
		conta_one.getMovimentacao().addAll(Arrays.asList(movi_one, movi_two));
		
		
        user_one.getContas().addAll(Arrays.asList(conta_two));		
		//conta_two.getMovimentacao().addAll(Arrays.asList(movi_two));
		
		
		
		
		
		this.userRepository.saveAll(Arrays.asList(user_one));
		
		this.contaRepository.saveAll(Arrays.asList(conta_one));
		
		this.movimentacaoRepository.saveAll(Arrays.asList(movi_one));	
		
		
		this.investimentosRepository.saveAll(Arrays.asList(invest_one));
		
		
		
		
      //  this.userRepository.saveAll(Arrays.asList(user_two));
		
		this.contaRepository.saveAll(Arrays.asList(conta_two));
		
		//this.movimentacaoRepository.saveAll(Arrays.asList(movi_two));		  
		
		
	}

}
