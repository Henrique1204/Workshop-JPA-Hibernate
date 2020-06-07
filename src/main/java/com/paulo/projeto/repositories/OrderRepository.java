 package com.paulo.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paulo.projeto.entidades.Order;

public interface OrderRepository extends JpaRepository<Order, Long>
{
	
}