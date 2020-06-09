 package com.paulo.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paulo.projeto.entidades.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>
{
	
}