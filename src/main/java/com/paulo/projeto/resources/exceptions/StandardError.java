package com.paulo.projeto.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StandardError implements Serializable
{
	private static final long serialVersionUID = 1L;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant timeInstant;
	private Integer status;
	private String error;
	private String message;
	private String path;

	// Construtores
	public StandardError() {}

	public StandardError(Instant timeInstant, Integer status, String error, String message, String path)
	{
		this.setTimeInstant(timeInstant);
		this.setStatus(status);
		this.setError(error);
		this.setMessage(message);
		this.setPath(path);
	}

	// Getters
	public Instant getTimeInstant()
	{
		return this.timeInstant;
	}

	public Integer getStatus()
	{
		return this.status;
	}

	public String getError()
	{
		return this.error;
	}

	public String getMessage()
	{
		return this.message;
	}

	public String getPath()
	{
		return this.path;
	}

	// Setters
	public void setTimeInstant(Instant timeInstant)
	{
		this.timeInstant = timeInstant;
	}

	public void setStatus(Integer status)
	{
		this.status = status;
	}

	public void setError(String error)
	{
		this.error = error;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public void setPath(String path)
	{
		this.path = path;
	}	
}