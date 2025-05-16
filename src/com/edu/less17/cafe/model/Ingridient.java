package com.edu.less17.cafe.model;

public enum Ingridient {
	WATER("water"), 
	COFFEE("coffee"), 
	MILK("milk"), 
	TEA("tea"), 
	SUGAR("sugar");

	private final String name;

	private Ingridient(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
