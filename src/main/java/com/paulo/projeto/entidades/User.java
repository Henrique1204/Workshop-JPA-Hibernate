package com.paulo.projeto.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_user")
public class User implements Serializable
{
	// Versão Serializable
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String fone;
	private String senha;

	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<Order> pedidos = new ArrayList<>();

	// Construtores
	public User() {}

	public User(Long id, String nome, String email, String fone, String senha)
	{
		this.setId(id);
		this.setNome(nome);
		this.setEmail(email);
		this.setFone(fone);
		this.setSenha(senha);
	}

	// Getters
	public Long getId()
	{
		return this.id;
	}

	public String getNome()
	{
		return this.nome;
	}

	public String getEmail()
	{
		return this.email;
	}

	public String getFone()
	{
		return this.fone;
	}

	public String getSenha()
	{
		return this.senha;
	}

	public List<Order> getPedidos() {
		return this.pedidos;
	}

	// Setters
	public void setId(Long id)
	{
		this.id = id;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public void setFone(String fone)
	{
		this.fone = fone;
	}

	public void setSenha(String senha)
	{
		this.senha = senha;
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

		User other = (User) obj;

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