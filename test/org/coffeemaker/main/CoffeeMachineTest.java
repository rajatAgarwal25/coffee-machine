package org.coffeemaker.main;

import java.util.Arrays;

import org.coffeemaker.beverages.Beverage;
import org.coffeemaker.beverages.BeverageType;
import org.coffeemaker.beverages.GingerTea;
import org.coffeemaker.ingredients.CoffeeSyrup;
import org.coffeemaker.ingredients.HotMilk;
import org.junit.Assert;
import org.junit.Test;

public class CoffeeMachineTest {

//	@Test
//	public void testHotMilk() {
//		CoffeeMachine coffeeMachine = CoffeeMachine.builder().withSlots(3).build();
//		Slot slot = coffeeMachine.getAvailableSlot();
//		Beverage milk = slot.prepareBeverage(BeverageType.HOT_MILK);
//		Assert.assertTrue(milk instanceof HotMilk);
//		HotMilk hotMilk = (HotMilk) milk;
//		Assert.assertEquals(50, hotMilk.getQuantity());
//	}

//	@Test
//	public void testGingerTea() {
//		CoffeeMachine coffeeMachine = new CoffeeMachine(2);
//		Slot slot = coffeeMachine.getAvailableSlot();
//		Beverage gingerTea = slot.prepareBeverage(BeverageType.GINGER_TEA);
//		Assert.assertTrue(gingerTea instanceof GingerTea);
//		GingerTea tea = (GingerTea) gingerTea;
//		Assert.assertEquals(50, tea.getWater().getQuantity());
//	}

}
