package org.coffeemaker.ingredients;

public class ElaichiSyrup implements Ingredient {

	private static long quantityAvailable = 500;

	private long quantity;

	private ElaichiSyrup(Builder builder) {
		this.quantity = builder.quantity;
	}
	
	public ElaichiSyrup(long qty) {
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

		public ElaichiSyrup build() {
			return new ElaichiSyrup(this);
		}
	}

}
