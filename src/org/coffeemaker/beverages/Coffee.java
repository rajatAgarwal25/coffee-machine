package org.coffeemaker.beverages;

import org.coffeemaker.ingredients.CoffeeSyrup;
import org.coffeemaker.ingredients.HotMilk;
import org.coffeemaker.ingredients.HotWater;
import org.coffeemaker.ingredients.SugarSyrup;

public class Coffee implements Beverage {

	private HotMilk milk;
	private HotWater water;
	private CoffeeSyrup coffeeSyrup;
	private SugarSyrup sugarSyrup;

	private Coffee(Builder builder) {
		this.milk = builder.milk;
		this.water = builder.water;
		this.coffeeSyrup = builder.coffeeSyrup;
		this.sugarSyrup = builder.sugarSyrup;
	}

	public HotMilk getMilk() {
		return milk;
	}

	public HotWater getWater() {
		return water;
	}

	public CoffeeSyrup getCoffeeSyrup() {
		return coffeeSyrup;
	}

	public SugarSyrup getSugarSyrup() {
		return sugarSyrup;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private HotMilk milk;
		private HotWater water;
		private CoffeeSyrup coffeeSyrup;
		private SugarSyrup sugarSyrup;

		private Builder() {
		}

		public Builder withMilk(long milk) {
			this.milk = HotMilk.builder().withQuantity(milk).build();
			return this;
		}

		public Builder withWater(long water) {
			this.water = HotWater.builder().withQuantity(water).build();
			return this;
		}

		public Builder withCoffeeSyrup(long coffeeSyrup) {
			this.coffeeSyrup = CoffeeSyrup.builder().withQuantity(coffeeSyrup).build();
			return this;
		}

		public Builder withSugarSyrup(long sugarSyrup) {
			this.sugarSyrup = SugarSyrup.builder().withQuantity(sugarSyrup).build();
			return this;
		}

		public Coffee build() {
			return new Coffee(this);
		}
	}

}
