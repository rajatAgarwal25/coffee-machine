package org.coffeemaker.factory;

import org.coffeemaker.beverages.Beverage;
import org.coffeemaker.beverages.BeverageType;
import org.coffeemaker.beverages.BlackTea;
import org.coffeemaker.beverages.Coffee;
import org.coffeemaker.beverages.ElaichiTea;
import org.coffeemaker.beverages.GingerTea;
import org.coffeemaker.beverages.GreenTea;
import org.coffeemaker.ingredients.GingerSyrup;
import org.coffeemaker.ingredients.GreenMixture;
import org.coffeemaker.ingredients.HotMilk;
import org.coffeemaker.ingredients.HotWater;
import org.coffeemaker.ingredients.SugarSyrup;
import org.coffeemaker.ingredients.TeaLeavesSyrup;
import org.coffeemaker.pojo.Composition;

public class BeverageFactory {

	private BeverageFactory() {
	}

	public static Beverage getInstance(BeverageType beverageType, Composition composition) {
		try {
			Thread.sleep(5000); //Adding fixed wait time
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Beverage beverage = null;
		switch (beverageType) {
		case HOT_MILK:
			beverage = HotMilk.builder().withQuantity(composition.getHotmilk()).build();
			break;
		case HOT_WATER:
			beverage = HotWater.builder().withQuantity(composition.getHotWater()).build();
			break;
		case GINGER_TEA:
			beverage = GingerTea.builder().withGingerSyrup(composition.getGingerSyrup())
					.withMilk(composition.getHotmilk()).withWater(composition.getHotWater())
					.withSugarSyrup(composition.getSugarSyrup()).withTeaLeavesSyrup(composition.getTeaLeavesSyrup())
					.build();
			break;
		case COFFEE:
			beverage = Coffee.builder().withMilk(composition.getHotmilk()).withCoffeeSyrup(composition.getCoffeeSyrup())
					.withWater(composition.getHotWater()).withSugarSyrup(composition.getSugarSyrup()).build();
			break;
		case ELAICHI_TEA:
			beverage = ElaichiTea.builder().withElaichiSyrup(composition.getGingerSyrup())
					.withMilk(composition.getHotmilk()).withWater(composition.getHotWater())
					.withSugarSyrup(composition.getSugarSyrup()).withTeaLeavesSyrup(composition.getTeaLeavesSyrup())
					.build();
			break;
		case BLACK_TEA:
			beverage = BlackTea.builder()
					.withGingerSyrup(GingerSyrup.builder().withQuantity(composition.getGingerSyrup()).build())
					.withWater(HotWater.builder().withQuantity(composition.getHotWater()).build())
					.withSugarSyrup(SugarSyrup.builder().withQuantity(composition.getSugarSyrup()).build())
					.withTeaLeavesSyrup(TeaLeavesSyrup.builder().withQuantity(composition.getTeaLeavesSyrup()).build())
					.build();
			break;
		case GREEN_TEA:
			beverage = GreenTea.builder()
					.withGingerSyrup(GingerSyrup.builder().withQuantity(composition.getGingerSyrup()).build())
					.withWater(HotWater.builder().withQuantity(composition.getHotWater()).build())
					.withSugarSyrup(SugarSyrup.builder().withQuantity(composition.getSugarSyrup()).build())
					.withGreenMixture(GreenMixture.builder().withQuantity(composition.getGreenMixture()).build())
					.build();
			break;
		default:
			break;
		}
		return beverage;
	}

}
