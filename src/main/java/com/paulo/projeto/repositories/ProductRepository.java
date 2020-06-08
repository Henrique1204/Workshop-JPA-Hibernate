 package com.paulo.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paulo.projeto.entidades.Product;

public interface ProductRepository extends JpaRepository<Product, Long>
{
	
}