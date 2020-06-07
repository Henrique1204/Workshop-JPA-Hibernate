package com.paulo.projeto.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.paulo.projeto.entidades.Order;
import com.paulo.projeto.entidades.User;
import com.paulo.projeto.entidades.enums.OrderStatus;
import com.paulo.projeto.repositories.OrderRepository;
import com.paulo.projeto.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner
{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception
	{
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "12345678", "senha");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "87654321", "senha");

		userRepository.saveAll(Arrays.asList(u1, u2));

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.SHIPPED, u2);
		Order o3 = new Order(null, Instant.parse("2019-06-22T15:21:22Z"), OrderStatus.DELIVERED, u1);

		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
}