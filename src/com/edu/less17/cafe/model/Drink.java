package com.edu.less17.cafe.model;


public enum Drink {
	CAPPUCCINO("Prepared cappuccino"),
	ESPRESSO("Prepared espresso"),
	AMERICANO("Prepared americano"),
	TEA("Prepared tea");

	private final String name;

	private Drink(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
