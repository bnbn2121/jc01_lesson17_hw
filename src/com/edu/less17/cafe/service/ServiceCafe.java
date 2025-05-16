package com.edu.less17.cafe.service;

import java.util.HashMap;
import java.util.Map;

import com.edu.less17.cafe.model.CoffeeMachine;
import com.edu.less17.cafe.model.DrinkType;
import com.edu.less17.cafe.model.Ingridient;
import com.edu.less17.cafe.model.Portion;
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
	}

	public void removeCoffeeMachine(int indexRemove) {
		cafe.removeCoffeeMachine(indexRemove);
	}

	public void doDrink(CoffeeMachine coffeeMachine, DrinkType drink, Portion portion, int sugarCount) {
		try {
		coffeeMachine.doDrink(drink, portion, sugarCount);
		} catch (RuntimeException e) {
			throw e;
		}
	}

	public void fillIngridient(CoffeeMachine coffeeMachine, Ingridient ingridient, int gramm) {
		coffeeMachine.fillIngridient(ingridient, gramm);
	}

	public void fillAll(CoffeeMachine coffeeMachine) {
		for (Ingridient i : coffeeMachine.getLimit().keySet()) {
			coffeeMachine.fillIngridient(i, coffeeMachine.getLimit().get(i));
		}
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

	public static Map<DrinkType, Integer> getTestMapDrinks(int... num) {
		Map<DrinkType, Integer> map = new HashMap<>();
		for (int i = 0; i < DrinkType.values().length; i++) {
			map.put(DrinkType.values()[i], num[i]);
		}
		return map;
	}

}
