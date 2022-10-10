package com.rfagundes.digitalbanc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rfagundes.digitalbanc.domain.Contas;




@Repository
public interface ContaRepository extends JpaRepository<Contas, Integer>{
    
	@Query("SELECT obj FROM Contas obj WHERE obj.users.id = :id_user")
	List<Contas> findAllByUser(@Param (value = "id_user") Integer id_user);

}
