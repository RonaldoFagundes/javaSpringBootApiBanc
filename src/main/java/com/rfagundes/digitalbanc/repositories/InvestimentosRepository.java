package com.rfagundes.digitalbanc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rfagundes.digitalbanc.domain.Investimentos;


@Repository
public interface InvestimentosRepository extends JpaRepository<Investimentos, Integer> {
	
}
