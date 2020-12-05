package org.coffeemaker.ingredients;

import org.coffeemaker.beverages.Beverage;

public class HotMilk implements Ingredient, Beverage {

	private static long quantityAvailable = 0;

	private long quantity;

	private HotMilk(Builder builder) {
		this.quantity = builder.quantity;
	}
	
	public HotMilk(long qty) {
		quantityAvailable = qty;
	}

	public long getQuantity() {
		return quantity;
	}

	public static long getQuantityAvailable() {
		return quantityAvailable;
	}
	
	public static void reserveQty(long qty) {
		quantityAvailable -= qty;
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

		public HotMilk build() {
			return new HotMilk(this);
		}
	}

}
