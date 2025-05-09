package com.edu.less17.cafe.enums;

import java.util.Map;

public enum Drink {
	CAPPUCCINO("Капучино", Map.of(Ingridient.WATER, 30, Ingridient.COFFEE, 10, Ingridient.MILK, 120)),
	ESPRESSO("Эспрессо", Map.of(Ingridient.WATER, 30, Ingridient.COFFEE, 10)),
	AMERICANO("Американо", Map.of(Ingridient.WATER, 30 + 120, Ingridient.COFFEE, 10)),
	TEA("Чай", Map.of(Ingridient.WATER, 200, Ingridient.TEA, 3));

	private final String name;
	private final Map<Ingridient, Integer> compound;

	private Drink(String name, Map<Ingridient, Integer> compound) {
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
