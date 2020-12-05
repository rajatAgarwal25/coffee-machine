package org.coffeemaker.beverages;

import javax.annotation.Generated;

import org.coffeemaker.ingredients.GingerSyrup;
import org.coffeemaker.ingredients.HotWater;
import org.coffeemaker.ingredients.SugarSyrup;
import org.coffeemaker.ingredients.TeaLeavesSyrup;

public class BlackTea implements Beverage {

	private TeaLeavesSyrup teaLeavesSyrup;
	private GingerSyrup gingerSyrup;
	private HotWater water;
	private SugarSyrup sugarSyrup;

	@Generated("SparkTools")
	private BlackTea(Builder builder) {
		this.teaLeavesSyrup = builder.teaLeavesSyrup;
		this.gingerSyrup = builder.gingerSyrup;
		this.water = builder.water;
		this.sugarSyrup = builder.sugarSyrup;
	}

	public TeaLeavesSyrup getTeaLeavesSyrup() {
		return teaLeavesSyrup;
	}

	public GingerSyrup getGingerSyrup() {
		return gingerSyrup;
	}

	public HotWater getWater() {
		return water;
	}

	public SugarSyrup getSugarSyrup() {
		return sugarSyrup;
	}

	/**
	 * Creates builder to build {@link BlackTea}.
	 * 
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link BlackTea}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private TeaLeavesSyrup teaLeavesSyrup;
		private GingerSyrup gingerSyrup;
		private HotWater water;
		private SugarSyrup sugarSyrup;

		private Builder() {
		}

		public Builder withTeaLeavesSyrup(TeaLeavesSyrup teaLeavesSyrup) {
			this.teaLeavesSyrup = teaLeavesSyrup;
			return this;
		}

		public Builder withGingerSyrup(GingerSyrup gingerSyrup) {
			this.gingerSyrup = gingerSyrup;
			return this;
		}

		public Builder withWater(HotWater water) {
			this.water = water;
			return this;
		}

		public Builder withSugarSyrup(SugarSyrup sugarSyrup) {
			this.sugarSyrup = sugarSyrup;
			return this;
		}

		public BlackTea build() {
			return new BlackTea(this);
		}
	}

}
