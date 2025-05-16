package com.edu.less17.cafe.repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.edu.less17.cafe.model.CoffeeMachine;
import com.edu.less17.cafe.model.DrinkType;
import com.edu.less17.cafe.model.Ingridient;

public class Cafe {
	private String name;
	private List<CoffeeMachine> coffeeMachines;

	public Cafe(String name, List<CoffeeMachine> coffeeMachines) {
		this.name = name;
		this.coffeeMachines = coffeeMachines;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CoffeeMachine> getCoffeeMachines() {
		return coffeeMachines;
	}

	public void setCoffeeMachines(List<CoffeeMachine> coffeeMachines) {
		this.coffeeMachines = coffeeMachines;
	}

	public void addCoffeeMachine(Map<Ingridient, Integer> limit, Map<Ingridient, Integer> available,
			Map<DrinkType, Integer> history) {
		coffeeMachines.add(new CoffeeMachine(limit, available, history));
	}

	public void removeCoffeeMachine(int indexRemove) {
		coffeeMachines.remove(indexRemove);
	}

	@Override
	public int hashCode() {
		return Objects.hash(coffeeMachines, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cafe other = (Cafe) obj;
		return Objects.equals(coffeeMachines, other.coffeeMachines) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Cafe [" + (name != null ? "name=" + name + ", " : "")
				+ (coffeeMachines != null ? "coffeeMachines=" + coffeeMachines : "") + "]";
	}

}
