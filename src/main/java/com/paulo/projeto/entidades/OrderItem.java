package com.paulo.projeto.entidades;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.paulo.projeto.entidades.pk.OrderItemPK;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable
{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderItemPK id = new OrderItemPK();

	private Integer quantidade;
	private Double preco;

	// Construtores
	public OrderItem() {}

	public OrderItem(Order order, Product product, Integer quantidade, Double preco)
	{
		this.id.setOrder(order);
		this.id.setProduct(product);

		this.setQuantidade(quantidade);
		this.setPreco(preco);
	}

	// Getters
	public Integer getQuantidade()
	{
		return this.quantidade;
	}

	public Double getPreco()
	{
		return this.preco;
	}

	@JsonIgnore
	public Order getORder()
	{
		return this.id.getOrder();
	}

	public Product getProduct()
	{
		return this.id.getProduct();
	}

	// Setters
	public void setQuantidade(Integer quantidade)
	{
		this.quantidade = quantidade;
	}

	public void setPreco(Double preco)
	{
		this.preco = preco;
	}

	public void setOrder(Order order)
	{
		this.id.setOrder(order);
	}

	public void setProduct(Product product)
	{
		this.id.setProduct(product);
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

		OrderItem other = (OrderItem) obj;

		if (id == null)
		{
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;

		return true;
	}

	
}