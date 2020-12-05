package org.coffeemaker.ingredients;

public class CoffeeSyrup implements Ingredient {

	private static long quantityAvailable = 0;

	private long quantity;

	private CoffeeSyrup(Builder builder) {
		this.quantity = builder.quantity;
	}
	
	public CoffeeSyrup(long qty) {
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

		public CoffeeSyrup build() {
			return new CoffeeSyrup(this);
		}
	}

}
