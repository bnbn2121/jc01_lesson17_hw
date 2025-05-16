package com.edu.less17.cafe.ui;

public enum Status {
	ERROR_LIMIT_INGRIDIENT("Container is full"), 
	ERROR_EMPTY_INGRIDIENT("Container is empty"),
	ERROR_NOT_ENOUGH_INGRIDIENT("Not enough ingredient"), 
	ERROR_DRINK("Failed to prepare the drink"),
	DONE_DRINK("Drink is ready"), 
	DONE_ADD("Ingredient refilled"), 
	DONE_NEW_MACHINE("New coffee machine added"),
	DONE_REMOVE_MACHINE("Coffee machine removed"),
	DONE_START_MACHINE("Starting drink preparation"),
	SPEND_INGRIDIENT("Adding ingredient in cup");

	private String message;

	private Status(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
