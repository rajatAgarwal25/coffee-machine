package org.coffeemaker.pojo;

import javax.annotation.Generated;

public class Composition {
    
    private long hotWater;
    
    private long hotmilk;
    
    private long gingerSyrup;
    
    private long sugarSyrup;
    
    private long teaLeavesSyrup;
    
    private long elaichiSyrup;
    
    private long coffeeSyrup;
    
    private long greenMixture;

	@Generated("SparkTools")
	private Composition(Builder builder) {
		this.hotWater = builder.hotWater;
		this.hotmilk = builder.hotmilk;
		this.gingerSyrup = builder.gingerSyrup;
		this.sugarSyrup = builder.sugarSyrup;
		this.teaLeavesSyrup = builder.teaLeavesSyrup;
		this.elaichiSyrup = builder.elaichiSyrup;
		this.coffeeSyrup = builder.coffeeSyrup;
		this.greenMixture = builder.greenMixture;
	}

	public long getHotWater() {
		return hotWater;
	}

	public long getHotmilk() {
		return hotmilk;
	}

	public long getGingerSyrup() {
		return gingerSyrup;
	}

	public long getSugarSyrup() {
		return sugarSyrup;
	}

	public long getTeaLeavesSyrup() {
		return teaLeavesSyrup;
	}

	public long getElaichiSyrup() {
		return elaichiSyrup;
	}

	public long getCoffeeSyrup() {
		return coffeeSyrup;
	}

	public long getGreenMixture() {
		return greenMixture;
	}

	/**
	 * Creates builder to build {@link Composition}.
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link Composition}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private long hotWater;
		private long hotmilk;
		private long gingerSyrup;
		private long sugarSyrup;
		private long teaLeavesSyrup;
		private long elaichiSyrup;
		private long coffeeSyrup;
		private long greenMixture;

		private Builder() {
		}

		public Builder withHotWater(long hotWater) {
			this.hotWater = hotWater;
			return this;
		}

		public Builder withHotmilk(long hotmilk) {
			this.hotmilk = hotmilk;
			return this;
		}

		public Builder withGingerSyrup(long gingerSyrup) {
			this.gingerSyrup = gingerSyrup;
			return this;
		}

		public Builder withSugarSyrup(long sugarSyrup) {
			this.sugarSyrup = sugarSyrup;
			return this;
		}

		public Builder withTeaLeavesSyrup(long teaLeavesSyrup) {
			this.teaLeavesSyrup = teaLeavesSyrup;
			return this;
		}

		public Builder withElaichiSyrup(long elaichiSyrup) {
			this.elaichiSyrup = elaichiSyrup;
			return this;
		}

		public Builder withCoffeeSyrup(long coffeeSyrup) {
			this.coffeeSyrup = coffeeSyrup;
			return this;
		}

		public Builder withGreenMixture(long greenMixture) {
			this.greenMixture = greenMixture;
			return this;
		}

		public Composition build() {
			return new Composition(this);
		}
	}


}
