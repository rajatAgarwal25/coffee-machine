package org.coffeemaker.beverages;

import org.coffeemaker.ingredients.GingerSyrup;
import org.coffeemaker.ingredients.HotMilk;
import org.coffeemaker.ingredients.HotWater;
import org.coffeemaker.ingredients.SugarSyrup;
import org.coffeemaker.ingredients.TeaLeavesSyrup;

public class GingerTea implements Beverage {

	private HotMilk milk;
	private HotWater water;
	private TeaLeavesSyrup teaLeavesSyrup;
	private GingerSyrup gingerSyrup;
	private SugarSyrup sugarSyrup;

	private GingerTea(Builder builder) {
		this.milk = builder.milk;
		this.water = builder.water;
		this.teaLeavesSyrup = builder.teaLeavesSyrup;
		this.gingerSyrup = builder.gingerSyrup;
		this.sugarSyrup = builder.sugarSyrup;
	}

	public HotMilk getMilk() {
		return milk;
	}

	public HotWater getWater() {
		return water;
	}

	public TeaLeavesSyrup getTeaLeavesSyrup() {
		return teaLeavesSyrup;
	}

	public GingerSyrup getGingerSyrup() {
		return gingerSyrup;
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
		private TeaLeavesSyrup teaLeavesSyrup;
		private GingerSyrup gingerSyrup;
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

		public Builder withTeaLeavesSyrup(long teaLeavesSyrup) {
			this.teaLeavesSyrup = TeaLeavesSyrup.builder().withQuantity(teaLeavesSyrup).build();
			return this;
		}

		public Builder withGingerSyrup(long gingerSyrup) {
			this.gingerSyrup = GingerSyrup.builder().withQuantity(gingerSyrup).build();
			return this;
		}

		public Builder withSugarSyrup(long sugarSyrup) {
			this.sugarSyrup = SugarSyrup.builder().withQuantity(sugarSyrup).build();
			return this;
		}

		public GingerTea build() {
			return new GingerTea(this);
		}
	}

}
