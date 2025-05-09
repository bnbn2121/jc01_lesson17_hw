package com.edu.less17.cafe.enums;

public enum Status {
	ERROR_LIMIT_INGRIDIENT("Емкость полностью заполнена"), 
	ERROR_EMPTY_INGRIDIENT("Емкость пустая"),
	ERROR_NOT_ENOUGH_INGRIDIENT("Ингридиента недостаточно"), 
	ERROR_DRINK("Не удалось приготовить напиток"),
	DONE_DRINK("Напиток готов"), 
	DONE_ADD("Ингридиент пополнен"), 
	DONE_NEW_MACHINE("Новая кофемашина добавлена"),
	DONE_REMOVE_MACHINE("Кофемашина удалена"), 
	SPEND_INGRIDIENT("Добавляем ингридиент");

	private String message;

	private Status(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
