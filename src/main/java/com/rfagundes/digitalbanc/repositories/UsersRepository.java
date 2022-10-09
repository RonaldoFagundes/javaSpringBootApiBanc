package com.rfagundes.digitalbanc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rfagundes.digitalbanc.domain.Users;


@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{	
	
}
