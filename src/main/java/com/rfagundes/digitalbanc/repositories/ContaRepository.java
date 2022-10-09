package com.rfagundes.digitalbanc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rfagundes.digitalbanc.domain.Contas;


@Repository
public interface ContaRepository extends JpaRepository<Contas, Integer>{

}
