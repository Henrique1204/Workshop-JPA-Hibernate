 package com.paulo.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paulo.projeto.entidades.User;

public interface UserRepository extends JpaRepository<User, Long>
{
	
}