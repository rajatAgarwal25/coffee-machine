package org.coffeemaker.ingredients;

public class GreenMixture implements Ingredient {

	private static long quantityAvailable = 500;

	private long quantity;

	private GreenMixture(Builder builder) {
		this.quantity = builder.quantity;
	}
	
	public GreenMixture(long qty) {
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

		public GreenMixture build() {
			return new GreenMixture(this);
		}
	}

}
