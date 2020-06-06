package com.paulo.projeto.entidades;

import java.io.Serializable;

public class User implements Serializable
{
	// Versão Serializable
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String email;
	private String fone;
	private String senha;

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