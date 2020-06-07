package com.paulo.projeto.entidades.enums;

public enum OrderStatus
{
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);

	private int cod;

	// Construtor
	private OrderStatus(int cod)
	{
		this.cod = cod;
	}

	public int getCod()
	{
		return this.cod;
	}

	public static OrderStatus valueOf(int cod)
	{
		for (OrderStatus value : OrderStatus.values())
		{
			if (value.getCod() == cod)
			{
				return value;
			}
		}

		throw new IllegalArgumentException("Este codigo e invalido");
	}
}