package com.edu.less17.cafe.model;

import java.util.Map;
import java.util.Objects;

import com.edu.less17.cafe.ui.Status;

public class CoffeeMachine {
	private int id;
	private Map<Ingridient, Integer> limit;
	private Map<Ingridient, Integer> available;
	private Map<DrinkType, Integer> history;
	private StringBuilder log;
	private static int countCoffeeMachines;

	public CoffeeMachine(Map<Ingridient, Integer> limit, Map<Ingridient, Integer> available,
			Map<DrinkType, Integer> history) {
		this.id = ++countCoffeeMachines;
		this.limit = limit;
		this.available = available;
		this.history = history;
		this.log = new StringBuilder();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Map<Ingridient, Integer> getLimit() {
		return limit;
	}

	public void setLimit(Map<Ingridient, Integer> limit) {
		this.limit = limit;
	}

	public Map<Ingridient, Integer> getAvailable() {
		return available;
	}

	public void setAvailable(Map<Ingridient, Integer> available) {
		this.available = available;
	}

	public StringBuilder getLog() {
		return log;
	}

	public static int getCountCoffeeMachines() {
		return countCoffeeMachines;
	}

	public static void setCountCoffeeMachines(int countCoffeeMachines) {
		CoffeeMachine.countCoffeeMachines = countCoffeeMachines;
	}

	public void setHistory(Map<DrinkType, Integer> history) {
		this.history = history;
	}

	public Map<DrinkType, Integer> getHistory() {
		return history;
	}

	public Drink doDrink(DrinkType drink, Portion portion, int sugarCountPortion) {
		int sugarOnePortion = 5;
		if (checkIngridients(drink, portion) & isEnoughIngridient(Ingridient.SUGAR, sugarCountPortion * sugarOnePortion)) {
			int multiply = switch (portion) {
			case ONE -> 1;
			case DOUBLE -> 2;
			};
			log.append(Status.DONE_START_MACHINE.getMessage()).append("\n");
			for (Ingridient x : drink.getCompound().keySet()) {
				int needIngridient = drink.getCompound().get(x) * multiply;
				spendIngridient(x, needIngridient);
			}
			spendIngridient(Ingridient.SUGAR, sugarCountPortion * sugarOnePortion);
			history.put(drink, history.get(drink) + 1);
			Drink preparedDrink = Drink.valueOf(drink.name());
			log.append(Status.DONE_DRINK.getMessage()).append(": ").append(preparedDrink.getName().toLowerCase());
			return preparedDrink;
		} else {
			log.append(Status.ERROR_DRINK.getMessage());
			throw new RuntimeException("исключение во время приготовления напитка");
		}
	}

	private boolean checkIngridients(DrinkType drink, Portion portion) {
		int multiply = switch (portion) {
		case ONE -> 1;
		case DOUBLE -> 2;
		};

		boolean checkStatus = true;
		for (Ingridient x : drink.getCompound().keySet()) {
			int needIngridient = drink.getCompound().get(x) * multiply;
			if (!isEnoughIngridient(x, needIngridient)) {
				checkStatus = false;
			}
		}
		return checkStatus;
	}

	private boolean isEnoughIngridient(Ingridient ingridient, int need) {
		if (available.get(ingridient) < need) {
			log.append(
					String.format("%s: %s\n", Status.ERROR_NOT_ENOUGH_INGRIDIENT.getMessage(), ingridient.getName()));
			return false;
		}
		return true;
	}

	private void spendIngridient(Ingridient ingridient, int need) {
		available.put(ingridient, available.get(ingridient) - need);
		log.append(
				String.format("%s: %s - %d грамм\n", Status.SPEND_INGRIDIENT.getMessage(), ingridient.getName(), need));
	}

	public void clearLog() {
		log.setLength(0);
	}

	public void fillIngridient(Ingridient ingridient, int gramm) {
		int maxLimit = limit.get(ingridient);
		int currentGramm = available.get(ingridient);
		int added;
		if (currentGramm == maxLimit) {
			added = 0;
			log.append(Status.ERROR_LIMIT_INGRIDIENT.getMessage()).append("\n");
		} else {
			if (currentGramm + gramm > maxLimit) {
				added = maxLimit - currentGramm;
			} else {
				added = gramm;
			}
			log.append(String.format("%s: %s - добавлено %d грамм\n", Status.DONE_ADD.getMessage(),
					ingridient.getName(), added));
		}
		available.put(ingridient, currentGramm + added);
	}

	public String getInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append("Информация о кофемашине №" + id).append("\n");
		sb.append("Наличие ингридиентов:").append("\n");
		for (Ingridient ingr : limit.keySet()) {
			sb.append(String.format("%s : %d / %d\n", ingr.getName(), available.get(ingr), limit.get(ingr)));
		}
		sb.append("Всего приготовлено напитков:").append("\n");
		for (DrinkType dr : history.keySet()) {
			sb.append(String.format("%s : %d\n", dr.getName(), history.get(dr)));
		}
		return sb.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(available, history, id, limit, log);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CoffeeMachine other = (CoffeeMachine) obj;
		return Objects.equals(available, other.available) && Objects.equals(history, other.history) && id == other.id
				&& Objects.equals(limit, other.limit) && Objects.equals(log, other.log);
	}

	@Override
	public String toString() {
		return "CoffeeMachine [id=" + id + ", " + (limit != null ? "limit=" + limit + ", " : "")
				+ (available != null ? "available=" + available + ", " : "")
				+ (history != null ? "history=" + history + ", " : "") + (log != null ? "log=" + log : "") + "]";
	}

}
