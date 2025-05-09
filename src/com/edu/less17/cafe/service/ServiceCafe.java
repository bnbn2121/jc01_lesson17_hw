package com.edu.less17.cafe.service;

import java.util.HashMap;
import java.util.Map;

import com.edu.less17.cafe.enums.Drink;
import com.edu.less17.cafe.enums.Ingridient;
import com.edu.less17.cafe.enums.Portion;
import com.edu.less17.cafe.enums.Status;
import com.edu.less17.cafe.model.CoffeeMachine;
import com.edu.less17.cafe.repository.Cafe;

public class ServiceCafe {
	private Cafe cafe;

	public ServiceCafe(Cafe cafe) {
		this.cafe = cafe;
	}

	public Cafe getCafe() {
		return cafe;
	}

	public void setCafe(Cafe cafe) {
		this.cafe = cafe;
	}

	public void addCoffeeMachine() {
		cafe.addCoffeeMachine(
				getTestMapIngridients(3000, 200, 1000, 100, 500), 
				getTestMapIngridients(0, 0, 0, 0, 0),
				getTestMapDrinks(0, 0, 0, 0));
		System.out.println(Status.DONE_NEW_MACHINE.getMessage());
	}

	public void removeCoffeeMachine(int indexRemove) {
		cafe.removeCoffeeMachine(indexRemove);
		System.out.println(Status.DONE_REMOVE_MACHINE.getMessage());
	}

	public void doDrink(CoffeeMachine coffeeMachine, Drink drink, Portion portion, int sugarCount) {
		coffeeMachine.doDrink(drink, portion, sugarCount);
		coffeeMachine.printLog();
		coffeeMachine.clearLog();
	}

	public void fillIngridient(CoffeeMachine coffeeMachine, Ingridient ingridient, int gramm) {
		coffeeMachine.fillIngridient(ingridient, gramm);
		coffeeMachine.printLog();
		coffeeMachine.clearLog();
	}

	public void fillAll(CoffeeMachine coffeeMachine) {
		for (Ingridient i : coffeeMachine.getLimit().keySet()) {
			coffeeMachine.fillIngridient(i, coffeeMachine.getLimit().get(i));
		}
		coffeeMachine.printLog();
		coffeeMachine.clearLog();
	}

	public String getCoffeeMachineInfo(CoffeeMachine coffeeMachine) {
		return coffeeMachine.getInfo();

	}

	public static Map<Ingridient, Integer> getTestMapIngridients(int... num) {
		Map<Ingridient, Integer> map = new HashMap<>();
		for (int i = 0; i < Ingridient.values().length; i++) {
			map.put(Ingridient.values()[i], num[i]);
		}
		return map;
	}

	public static Map<Drink, Integer> getTestMapDrinks(int... num) {
		Map<Drink, Integer> map = new HashMap<>();
		for (int i = 0; i < Drink.values().length; i++) {
			map.put(Drink.values()[i], num[i]);
		}
		return map;
	}

}
