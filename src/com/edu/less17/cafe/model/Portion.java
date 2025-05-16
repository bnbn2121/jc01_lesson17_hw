package com.edu.less17.cafe.model;

public enum Portion {

	ONE("standart portion"), 
	DOUBLE("double portion");

	private String size;

	private Portion(String size) {
		this.size = size;
	}

	public String getSize() {
		return size;
	}

}
