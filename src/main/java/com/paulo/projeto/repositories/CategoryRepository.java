 package com.paulo.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paulo.projeto.entidades.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>
{
	
}