package com.paulo.projeto.entidades;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.paulo.projeto.entidades.enums.OrderStatus;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant momento;

	private Integer orderStatus;

	@ManyToOne
	@JoinColumn(name = "ClienteId")
	private User cliente;

	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items = new HashSet<>();

	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Payment payment;

	// Construtores
	public Order() {}

	public Order(Long id, Instant momento, OrderStatus orderStatus, User cliente)
	{
		this.setId(id);
		this.setMomento(momento);
		this.setOrderStatus(orderStatus);
		this.setCliente(cliente);
	}

	// Getters
	public Long getId()
	{
		return this.id;
	}

	public Instant getMomento()
	{
		return this.momento;
	}

	public User getCliente()
	{
		return this.cliente;
	}

	public OrderStatus getOrderStatus()
	{
		return OrderStatus.valueOf(this.orderStatus);
	}

	public Payment getPayment()
	{
		return this.payment;
	}

	public Set<OrderItem> getItems()
	{
		return this.items;
	}

	// Setters
	public void setId(Long id)
	{
		this.id = id;
	}

	public void setMomento(Instant momento)
	{
		this.momento = momento;
	}

	public void setCliente(User cliente)
	{
		this.cliente = cliente;
	}

	public void setOrderStatus(OrderStatus orderStatus)
	{
		if (orderStatus != null)
		{
			this.orderStatus = orderStatus.getCod();	
		}
	}

	public void setPayment(Payment payment)
	{
		this.payment = payment;
	}

	// HashCode e Equals
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		Order other = (Order) obj;

		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;

		return true;
	}
}