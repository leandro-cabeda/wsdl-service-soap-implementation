package com.wsservice.repositories.h2jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.wsservice.entities.Userrs;


@Transactional(readOnly = true)
public interface UsersRepository extends JpaRepository<Userrs, Integer>{

	Userrs findById(int id);
	
}
