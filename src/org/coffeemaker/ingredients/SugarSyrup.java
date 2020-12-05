package org.coffeemaker.ingredients;

public class SugarSyrup implements Ingredient {

	private static long quantityAvailable = 500;

	private long quantity;

	private SugarSyrup(Builder builder) {
		this.quantity = builder.quantity;
	}
	
	public SugarSyrup(long qty) {
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

		public SugarSyrup build() {
			return new SugarSyrup(this);
		}
	}

}
