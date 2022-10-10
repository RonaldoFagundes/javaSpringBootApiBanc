package com.rfagundes.digitalbanc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rfagundes.digitalbanc.domain.Movimentacao;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer>{

	
	@Query("SELECT obj FROM Movimentacao obj WHERE obj.contas.id = :id_conta")
	List<Movimentacao> findAllByConta(@Param (value = "id_conta") Integer id_conta);
}
