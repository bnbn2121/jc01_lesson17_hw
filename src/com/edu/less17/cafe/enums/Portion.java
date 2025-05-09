package com.edu.less17.cafe.enums;

public enum Portion {

	ONE("стандартная порция"), 
	DOUBLE("двойная порция");

	private String size;

	private Portion(String size) {
		this.size = size;
	}

	public String getSize() {
		return size;
	}

}
