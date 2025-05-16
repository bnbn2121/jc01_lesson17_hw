package com.edu.less17.cafe.model;

import java.util.Map;

public enum DrinkType {
	CAPPUCCINO("Сappuccino", Map.of(Ingridient.WATER, 30, Ingridient.COFFEE, 10, Ingridient.MILK, 120)),
	ESPRESSO("Espresso", Map.of(Ingridient.WATER, 30, Ingridient.COFFEE, 10)),
	AMERICANO("Americano", Map.of(Ingridient.WATER, 30 + 120, Ingridient.COFFEE, 10)),
	TEA("Tea", Map.of(Ingridient.WATER, 200, Ingridient.TEA, 3));

	private final String name;
	private final Map<Ingridient, Integer> compound;

	private DrinkType(String name, Map<Ingridient, Integer> compound) {
		this.name = name;
		this.compound = compound;
	}

	public String getName() {
		return name;
	}

	public Map<Ingridient, Integer> getCompound() {
		return compound;
	}

}
