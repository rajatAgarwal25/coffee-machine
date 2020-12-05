package org.coffeemaker.ingredients;

import org.coffeemaker.beverages.Beverage;

public class HotWater implements Ingredient, Beverage {

	private static long quantityAvailable = 500;

	private long quantity;

	private HotWater(Builder builder) {
		this.quantity = builder.quantity;
	}
	
	public HotWater(long qty) {
		quantityAvailable = qty;
	}
	
	public long getQuantity() {
		return quantity;
	}
	
	public static void reserveQty(long qty) {
		quantityAvailable -= qty;
	}

	public static long getQuantityAvailable() {
		return quantityAvailable;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private long quantity;

		private Builder() {
		}

		public Builder withQuantity(long quantity) {
			this.quantity = quantity;
			return this;
		}

		public HotWater build() {
			return new HotWater(this);
		}
	}

}
