package com.paulo.projeto.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paulo.projeto.entidades.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource
{
	@GetMapping
	public ResponseEntity<User> findAll()
	{
		User u = new User(1L, "Maria", "maria@gmail.com", "11111111", "senha");
		return ResponseEntity.ok().body(u);
	}
}