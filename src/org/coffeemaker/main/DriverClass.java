package org.coffeemaker.main;

import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import org.coffeemaker.beverages.BeverageType;
import org.coffeemaker.ingredients.GingerSyrup;
import org.coffeemaker.ingredients.HotMilk;
import org.coffeemaker.ingredients.HotWater;
import org.coffeemaker.ingredients.SugarSyrup;
import org.coffeemaker.ingredients.TeaLeavesSyrup;
import org.coffeemaker.pojo.CoffeeMachine;
import org.coffeemaker.pojo.Composition;
import org.coffeemaker.pojo.Slot;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DriverClass {

	public static void main(String[] args) {
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = null;
		try (FileReader reader = new FileReader(new File(args[0]))) {
			Object obj = jsonParser.parse(reader);
			jsonObject = (JSONObject) obj;
		} catch (Exception ex) {
			throw new UnsupportedOperationException();
		}
		JSONObject machineObj = (JSONObject) jsonObject.get("machine");
		JSONObject outletsObj = (JSONObject) machineObj.get("outlets");
		JSONObject qtyObj = (JSONObject) machineObj.get("total_items_quantity");
		JSONObject beveragesObj = (JSONObject) machineObj.get("beverages");

		CoffeeMachine machine = createMachine(outletsObj, qtyObj);
		Map<BeverageType, Composition> beverages = new LinkedHashMap<BeverageType, Composition>();
		if (beveragesObj.get("hot_tea") != null) {
			JSONObject hotTeaObj = (JSONObject) beveragesObj.get("hot_tea");
			beverages.put(BeverageType.GINGER_TEA,
					Composition.builder().withGingerSyrup(Long.valueOf((long) hotTeaObj.get("ginger_syrup")).intValue())
							.withHotmilk(Long.valueOf((long) hotTeaObj.get("hot_milk")).intValue())
							.withHotWater(Long.valueOf((long) hotTeaObj.get("hot_water")).intValue())
							.withSugarSyrup(Long.valueOf((long) hotTeaObj.get("sugar_syrup")).intValue())
							.withTeaLeavesSyrup(Long.valueOf((long) hotTeaObj.get("tea_leaves_syrup")).intValue())
							.build());
		}
		if (beveragesObj.get("hot_coffee") != null) {
			JSONObject hotCoffeeObj = (JSONObject) beveragesObj.get("hot_coffee");
			beverages.put(BeverageType.COFFEE, Composition.builder()
					.withGingerSyrup(Long.valueOf((long) hotCoffeeObj.get("ginger_syrup")).intValue())
					.withHotmilk(Long.valueOf((long) hotCoffeeObj.get("hot_milk")).intValue())
					.withHotWater(Long.valueOf((long) hotCoffeeObj.get("hot_water")).intValue())
					.withSugarSyrup(Long.valueOf((long) hotCoffeeObj.get("sugar_syrup")).intValue())
					.withTeaLeavesSyrup(Long.valueOf((long) hotCoffeeObj.get("tea_leaves_syrup")).intValue()).build());
		}
		if (beveragesObj.get("black_tea") != null) {
			JSONObject blackTeaObj = (JSONObject) beveragesObj.get("black_tea");
			beverages.put(BeverageType.BLACK_TEA, Composition.builder()
					.withGingerSyrup(Long.valueOf((long) blackTeaObj.get("ginger_syrup")).intValue())
					.withHotWater(Long.valueOf((long) blackTeaObj.get("hot_water")).intValue())
					.withSugarSyrup(Long.valueOf((long) blackTeaObj.get("sugar_syrup")).intValue())
					.withTeaLeavesSyrup(Long.valueOf((long) blackTeaObj.get("tea_leaves_syrup")).intValue()).build());
		}
		if (beveragesObj.get("green_tea") != null) {
			JSONObject greenTeaObj = (JSONObject) beveragesObj.get("green_tea");
			beverages.put(BeverageType.GREEN_TEA, Composition.builder()
					.withGingerSyrup(Long.valueOf((long) greenTeaObj.get("ginger_syrup")).intValue())
					.withHotWater(Long.valueOf((long) greenTeaObj.get("hot_water")).intValue())
					.withSugarSyrup(Long.valueOf((long) greenTeaObj.get("sugar_syrup")).intValue())
					.withGreenMixture(Long.valueOf((long) greenTeaObj.get("green_mixture")).intValue()).build());
		}
		//preparing all 4 beverages ||
		// 4th will wait until slot is available
		beverages.entrySet().parallelStream().forEach(e -> {
			Slot s = machine.getAvailableSlot(e.getKey());
			s.prepareBeverage(e.getKey(), e.getValue());
			s.setUnderUse(false);
		});
	}

	private static CoffeeMachine createMachine(JSONObject outletsObj, JSONObject qtyObj) {
		return CoffeeMachine.builder().withSlots(Long.valueOf((long) outletsObj.get("count_n")).intValue())
				.withIngredients(Arrays.asList(new HotMilk(Long.valueOf((long) qtyObj.get("hot_milk")).intValue()),
						new GingerSyrup(Long.valueOf((long) qtyObj.get("ginger_syrup")).intValue()),
						new SugarSyrup(Long.valueOf((long) qtyObj.get("sugar_syrup")).intValue()),
						new TeaLeavesSyrup(Long.valueOf((long) qtyObj.get("tea_leaves_syrup")).intValue()),
						new HotWater(Long.valueOf((long) qtyObj.get("hot_water")).intValue())))
				.build();
	}

}
