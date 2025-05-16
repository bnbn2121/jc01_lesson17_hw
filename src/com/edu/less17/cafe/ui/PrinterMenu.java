package com.edu.less17.cafe.ui;

import com.edu.less17.cafe.model.DrinkType;
import com.edu.less17.cafe.model.Ingridient;
import com.edu.less17.cafe.model.Portion;
import com.edu.less17.cafe.repository.Cafe;

public class PrinterMenu {
	private Cafe cafe;
	
	public PrinterMenu(Cafe cafe) {
		this.cafe = cafe;
	}
	public int printMenu0() {
		System.out.println("Главное меню:");
		System.out.println("1. Управление кофейней");
		System.out.println("2. Управление кофемашиной:");
		System.out.println("0. Выход из приложения");
		return 2;
	}
	public int printMenu01() {
		System.out.println();
		System.out.println("Меню управления кофейней:");
		System.out.println("1. Добавить кофемашину");
		System.out.println("2. Удалить кофемашину:");
		System.out.println("0. Выход в предыдущее меню");
		return 2;
	}
	public int printMenu02() {
		System.out.println();
		int allMachines = cafe.getCoffeeMachines().size();
		if (allMachines>0) {
			System.out.println("Выберите кофемашину:");
			for (int i=0;i<allMachines;i++) {
				System.out.println(i+1 + ". Выбрать кофемашину №" + cafe.getCoffeeMachines().get(i).getId());
			}	
		} else {
			System.out.println("Нет ни одной кофемашины");
		}
		System.out.println("0. Выход в предыдущее меню");
		return allMachines;
		
	}
	public int printMenu020(int indexCoffeeMachine) {
		System.out.println();
		System.out.println("Меню управления кофемашиной #" + cafe.getCoffeeMachines().get(indexCoffeeMachine).getId());
		System.out.println("1. Приготовить напиток");
		System.out.println("2. Отобразить информацию по кофемашине");
		System.out.println("3. Добавить ингридиенты");
		System.out.println("0. Выход в предыдущее меню");
		return 3;
	}
	
	public int printMenu0201() {
		System.out.println();
		System.out.println("Меню выбора напитка:");
		int countDrinks = DrinkType.values().length;
		for (int i=0;i<countDrinks;i++) {
			System.out.println(i+1 + ". " + DrinkType.values()[i].getName());
		}
		System.out.println("0. Выход в предыдущее меню");
		return countDrinks;
	}
	public int printMenu02010() {
		System.out.println();
		System.out.println("Выбор размера напитка:");
		int countPortions = Portion.values().length;
		for (int i=0;i<countPortions;i++) {
			System.out.println(i+1 + ". " + Portion.values()[i].getSize());
		}
		System.out.println("0. Выход в предыдущее меню");
		return countPortions;
	}
	public int printMenu020100() {
		System.out.println();
		System.out.println("Введите количество сахара (пакетиков):");
		return 10;
	}
	public int printMenu0203() {
		System.out.println();
		System.out.println("Меню выбора ингридиента для добавления:");
		int countIngridients = Ingridient.values().length;
		for (int i=0;i<countIngridients;i++) {
			System.out.println(i+1 + ". " + Ingridient.values()[i].getName());
		}
		System.out.println(countIngridients+1 + ". заполнить все ингридиенты до max");
		System.out.println("0. Выход в предыдущее меню");
		return countIngridients+1;
	}
	public int printMenu02030() {
		System.out.println();
		System.out.println("Введите количество грамм:");
		return 9999;
	}
	
	public int printMenu012() {
		return printMenu02();
	}
	
	
	
	
}
