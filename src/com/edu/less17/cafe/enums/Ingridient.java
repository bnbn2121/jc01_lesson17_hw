package com.edu.less17.cafe.enums;

public enum Ingridient {
	WATER("вода"), 
	COFFEE("кофе"), 
	MILK("молоко"), 
	TEA("чай"), 
	SUGAR("сахар");

	private final String name;

	private Ingridient(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
