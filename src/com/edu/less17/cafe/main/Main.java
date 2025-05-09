package com.edu.less17.cafe.main;

import java.util.ArrayList;

import com.edu.less17.cafe.model.CoffeeMachine;
import com.edu.less17.cafe.repository.Cafe;
import com.edu.less17.cafe.service.ServiceCafe;
import com.edu.less17.cafe.ui.ConsoleUI;

public class Main {

	public static void main(String[] args) {
		Cafe myCafe = new Cafe("Заря", new ArrayList<CoffeeMachine>());
		ServiceCafe service = new ServiceCafe(myCafe);
		ConsoleUI ui = new ConsoleUI(service);
		ui.start();
	}

}
