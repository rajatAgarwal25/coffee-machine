package org.coffeemaker.pojo;

import org.coffeemaker.beverages.Beverage;
import org.coffeemaker.beverages.BeverageType;
import org.coffeemaker.factory.BeverageFactory;
import org.coffeemaker.ingredients.CoffeeSyrup;
import org.coffeemaker.ingredients.ElaichiSyrup;
import org.coffeemaker.ingredients.GingerSyrup;
import org.coffeemaker.ingredients.GreenMixture;
import org.coffeemaker.ingredients.HotMilk;
import org.coffeemaker.ingredients.HotWater;
import org.coffeemaker.ingredients.SugarSyrup;
import org.coffeemaker.ingredients.TeaLeavesSyrup;

public class Slot {

	private boolean underUse;

	private int id;
	
	public Slot(int id) {
		this.id = id;
	}

	public boolean isUnderUse() {
		return underUse;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUnderUse(boolean underUse) {
		this.underUse = underUse;
	}

	public Beverage prepareBeverage(BeverageType beverageType, Composition comp) {
		if (haveSufficientQuantity(beverageType, comp)) {
			Beverage beverage = BeverageFactory.getInstance(beverageType, comp);
			System.out.println(beverageType.toString() + " is prepared");
			return beverage;
		}
		return null;
	
	}

	private boolean haveSufficientQuantity(BeverageType beverageType, Composition comp) {
		synchronized (Slot.class) {
			System.out.println("preparing : " + beverageType.name());
			if (comp.getCoffeeSyrup() != 0 && CoffeeSyrup.getQuantityAvailable() < comp.getCoffeeSyrup()) {
				System.out.println(beverageType.name() + " cannot be prepared because coffee_syrup is not available");
				return false;
			}
			if (comp.getElaichiSyrup() != 0 && ElaichiSyrup.getQuantityAvailable() < comp.getElaichiSyrup()) {
				System.out.println(beverageType.name() + " cannot be prepared because elaichi_syrup is not available");
				return false;
			}
			if (comp.getGingerSyrup() != 0 && GingerSyrup.getQuantityAvailable() < comp.getGingerSyrup()) {
				System.out.println(beverageType.name() + " cannot be prepared because ginger_syrup is not available");
				return false;
			}
			if (comp.getGreenMixture() != 0 && GreenMixture.getQuantityAvailable() < comp.getGreenMixture()) {
				System.out.println(beverageType.name() + " cannot be prepared because green_mixture is not available");
				return false;
			}
			if (comp.getHotmilk() != 0 && HotMilk.getQuantityAvailable() < comp.getHotmilk()) {
				System.out.println(beverageType.name() + " cannot be prepared because hot_milk is not available");
				return false;
			}
			if (comp.getHotWater() != 0 && HotWater.getQuantityAvailable() < comp.getHotWater()) {
				System.out.println(beverageType.name() + " cannot be prepared because hot_water is not available");
				return false;
			}
			if (comp.getSugarSyrup() != 0 && SugarSyrup.getQuantityAvailable() < comp.getSugarSyrup()) {
				System.out.println(beverageType.name() + " cannot be prepared because sugar_syrup is not available");
				return false;
			}
			if (comp.getTeaLeavesSyrup() != 0 && TeaLeavesSyrup.getQuantityAvailable() < comp.getTeaLeavesSyrup()) {
				System.out.println(beverageType.name() + " cannot be prepared because tea_leaves_syrup is not available");
				return false;
			}
			CoffeeSyrup.reserveQty(comp.getCoffeeSyrup());
			TeaLeavesSyrup.reserveQty(comp.getTeaLeavesSyrup());
			SugarSyrup.reserveQty(comp.getSugarSyrup());
			HotWater.reserveQty(comp.getHotWater());
			HotMilk.reserveQty(comp.getHotmilk());
			GreenMixture.reserveQty(comp.getGreenMixture());
			GingerSyrup.reserveQty(comp.getGingerSyrup());
			ElaichiSyrup.reserveQty(comp.getElaichiSyrup());
			return true;
		}
	}

}
