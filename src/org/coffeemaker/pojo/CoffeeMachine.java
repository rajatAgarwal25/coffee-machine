package org.coffeemaker.pojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.coffeemaker.beverages.BeverageType;
import org.coffeemaker.ingredients.Ingredient;

public class CoffeeMachine {
	
	private List<Slot> slots;
	
	private List<Ingredient> ingredients;

	private CoffeeMachine(Builder builder) {
		this.slots = builder.slots;
		this.ingredients = builder.ingredients;
	}

	public Slot getAvailableSlot(BeverageType type) {
		while(true) {
			for(Slot s : slots) {
				synchronized (this) {
					if(!s.isUnderUse()) {
						System.out.println("picking slot : " + s.getId() + " for " + type.name());
						s.setUnderUse(true);
						return s;
					}
				}
			}
		}
	}
	
	public static Builder builder() {
		return new Builder();
	}
	
	public List<Slot> getSlots() {
		return slots;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public static final class Builder {
		private List<Slot> slots = Collections.emptyList();
		private List<Ingredient> ingredients = Collections.emptyList();

		private Builder() {
		}

		public Builder withSlots(int n) {
			List<Slot> slots = new ArrayList<Slot>();
			for(int i = 1; i<=n; i++) {
				slots.add(new Slot(i));
			}
			this.slots = slots;
			return this;
		}

		public Builder withIngredients(List<Ingredient> ingredients) {
			this.ingredients = ingredients;
			return this;
		}

		public CoffeeMachine build() {
			return new CoffeeMachine(this);
		}
	}

}
