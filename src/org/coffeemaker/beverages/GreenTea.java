package org.coffeemaker.beverages;

import javax.annotation.Generated;

import org.coffeemaker.ingredients.GingerSyrup;
import org.coffeemaker.ingredients.GreenMixture;
import org.coffeemaker.ingredients.HotWater;
import org.coffeemaker.ingredients.SugarSyrup;

public class GreenTea implements Beverage {

	private HotWater water;
	private GreenMixture greenMixture;
	private GingerSyrup gingerSyrup;
	private SugarSyrup sugarSyrup;

	@Generated("SparkTools")
	private GreenTea(Builder builder) {
		this.water = builder.water;
		this.greenMixture = builder.greenMixture;
		this.gingerSyrup = builder.gingerSyrup;
		this.sugarSyrup = builder.sugarSyrup;
	}


	public HotWater getWater() {
		return water;
	}


	public GreenMixture getGreenMixture() {
		return greenMixture;
	}


	public GingerSyrup getGingerSyrup() {
		return gingerSyrup;
	}


	public SugarSyrup getSugarSyrup() {
		return sugarSyrup;
	}


	/**
	 * Creates builder to build {@link GreenTea}.
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link GreenTea}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private HotWater water;
		private GreenMixture greenMixture;
		private GingerSyrup gingerSyrup;
		private SugarSyrup sugarSyrup;

		private Builder() {
		}

		public Builder withWater(HotWater water) {
			this.water = water;
			return this;
		}

		public Builder withGreenMixture(GreenMixture greenMixture) {
			this.greenMixture = greenMixture;
			return this;
		}

		public Builder withGingerSyrup(GingerSyrup gingerSyrup) {
			this.gingerSyrup = gingerSyrup;
			return this;
		}

		public Builder withSugarSyrup(SugarSyrup sugarSyrup) {
			this.sugarSyrup = sugarSyrup;
			return this;
		}

		public GreenTea build() {
			return new GreenTea(this);
		}
	}

}
