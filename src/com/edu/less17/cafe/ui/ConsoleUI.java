package com.edu.less17.cafe.ui;

import java.util.Scanner;

import com.edu.less17.cafe.enums.Drink;
import com.edu.less17.cafe.enums.Ingridient;
import com.edu.less17.cafe.enums.Portion;
import com.edu.less17.cafe.model.CoffeeMachine;
import com.edu.less17.cafe.service.ServiceCafe;

public class ConsoleUI {
	private ServiceCafe service;
	private PrinterMenu printerMenu;
	private static Scanner scanner = new Scanner(System.in);

	public ConsoleUI(ServiceCafe service) {
		this.service = service;
		printerMenu = new PrinterMenu(service.getCafe());
	}

	public void start() {
		menu0();
	}

	public int userInput(int limitNumber) {
		System.out.println("\nВведите число от 0 до " + limitNumber + ":");
		int num;
		while (true) {
			while (!scanner.hasNextInt()) {
				scanner.nextLine();
				System.out.println("некорректный ввод");
			}
			num = scanner.nextInt();
			scanner.nextLine();
			if (num >= 0 && num <= limitNumber) {
				return num;
			} else {
				System.out.println("некорректный ввод");
			}
		}
	}

	public void menu0() {
		int inputLimit = printerMenu.printMenu0();
		int userInput = userInput(inputLimit);
		switch (userInput) {
		case 0 -> {
			return;
		}
		case 1 -> menu01();
		case 2 -> menu02();
		}
	}

	public void menu01() {
		int inputLimit = printerMenu.printMenu01();
		int userInput = userInput(inputLimit);
		switch (userInput) {
		case 0 -> menu0();
		case 1 -> {
			service.addCoffeeMachine();
			System.out.println();
			menu0();
		}
		case 2 -> menu012();
		}
	}

	public void menu02() {
		int inputLimit = printerMenu.printMenu02();
		int userInput = userInput(inputLimit);
		switch (userInput) {
		case 0 -> menu0();
		default -> {
			System.out.println(
					"Выбрана кофемашина № " + service.getCafe().getCoffeeMachines().get(userInput - 1).getId());
			menu020(userInput - 1);
		}
		}
	}

	public void menu020(int indexCoffeeMachine) {
		int inputLimit = printerMenu.printMenu020(indexCoffeeMachine);
		int userInput = userInput(inputLimit);
		switch (userInput) {
		case 0 -> menu02();
		case 1 -> menu0201(indexCoffeeMachine);
		case 2 -> menu0202(indexCoffeeMachine);
		case 3 -> menu0203(indexCoffeeMachine);
		}
	}

	public void menu0201(int indexCoffeeMachine) {
		int inputLimit = printerMenu.printMenu0201();
		int userInput = userInput(inputLimit);
		switch (userInput) {
		case 0 -> menu020(indexCoffeeMachine);
		default -> menu02010(indexCoffeeMachine, userInput - 1);
		}
	}

	public void menu02010(int indexCoffeeMachine, int indexDrink) {
		int inputLimit = printerMenu.printMenu02010();
		int userInput = userInput(inputLimit);
		switch (userInput) {
		case 0 -> menu0201(indexCoffeeMachine);
		default -> menu020100(indexCoffeeMachine, indexDrink, userInput - 1);
		}
	}

	public void menu020100(int indexCoffeeMachine, int indexDrink, int indexPortion) {
		int inputLimit = printerMenu.printMenu020100();
		int userInput = userInput(inputLimit);
		CoffeeMachine currentCoffeeMachine = service.getCafe().getCoffeeMachines().get(indexCoffeeMachine);
		Drink currentDrink = Drink.values()[indexDrink];
		Portion currentPortion = Portion.values()[indexPortion];
		int currentSugarPortions = userInput;
		service.doDrink(currentCoffeeMachine, currentDrink, currentPortion, currentSugarPortions);
		System.out.println();
		menu020(indexCoffeeMachine);
	}

	public void menu0202(int indexCoffeeMachine) {
		CoffeeMachine currentCoffeeMachine = service.getCafe().getCoffeeMachines().get(indexCoffeeMachine);
		System.out.println(service.getCoffeeMachineInfo(currentCoffeeMachine));
		menu020(indexCoffeeMachine);
	}

	public void menu0203(int indexCoffeeMachine) {
		int inputLimit = printerMenu.printMenu0203();
		int userInput = userInput(inputLimit);
		if (userInput == inputLimit) {
			CoffeeMachine currentCoffeeMachine = service.getCafe().getCoffeeMachines().get(indexCoffeeMachine);
			service.fillAll(currentCoffeeMachine);
			menu020(indexCoffeeMachine);
			return;
		}
		switch (userInput) {
		case 0 -> menu020(indexCoffeeMachine);
		default -> {
			System.out.println("Выбран ингридиент - " + Ingridient.values()[userInput - 1]);
			menu02030(indexCoffeeMachine, userInput - 1);
		}
		}
	}

	public void menu02030(int indexCoffeeMachine, int indexIngridient) {
		int inputLimit = printerMenu.printMenu02030();
		int userInput = userInput(inputLimit);
		CoffeeMachine currentCoffeeMachine = service.getCafe().getCoffeeMachines().get(indexCoffeeMachine);
		Ingridient currentIngridient = Ingridient.values()[indexIngridient];
		service.fillIngridient(currentCoffeeMachine, currentIngridient, userInput);
		menu0203(indexCoffeeMachine);
	}

	public void menu012() {
		int inputLimit = printerMenu.printMenu012();
		int userInput = userInput(inputLimit);
		service.removeCoffeeMachine(userInput - 1);
		System.out.println();
		menu0();
	}

}
