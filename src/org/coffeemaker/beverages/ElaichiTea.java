package org.coffeemaker.beverages;

import org.coffeemaker.ingredients.ElaichiSyrup;
import org.coffeemaker.ingredients.HotMilk;
import org.coffeemaker.ingredients.HotWater;
import org.coffeemaker.ingredients.SugarSyrup;
import org.coffeemaker.ingredients.TeaLeavesSyrup;

public class ElaichiTea implements Beverage {

	private HotMilk milk;
	private HotWater water;
	private TeaLeavesSyrup teaLeavesSyrup;
	private ElaichiSyrup elaichiSyrup;
	private SugarSyrup sugarSyrup;

	private ElaichiTea(Builder builder) {
		this.milk = builder.milk;
		this.water = builder.water;
		this.teaLeavesSyrup = builder.teaLeavesSyrup;
		this.elaichiSyrup = builder.elaichiSyrup;
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

	public ElaichiSyrup getElaichiSyrup() {
		return elaichiSyrup;
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
		private ElaichiSyrup elaichiSyrup;
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

		public Builder withElaichiSyrup(long elaichiSyrup) {
			this.elaichiSyrup = ElaichiSyrup.builder().withQuantity(elaichiSyrup).build();
			return this;
		}

		public Builder withSugarSyrup(long sugarSyrup) {
			this.sugarSyrup = SugarSyrup.builder().withQuantity(sugarSyrup).build();
			return this;
		}

		public ElaichiTea build() {
			return new ElaichiTea(this);
		}
	}

}
