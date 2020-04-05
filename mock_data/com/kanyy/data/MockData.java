package com.kanyy.data;

import java.util.HashMap;
import java.util.Map;
import com.kanyy.beverage.Beverage;

public class MockData {
  private static Map<String, Beverage> beverageMap = new HashMap<>();
  private static Map<String, Double> ingredientMap = new HashMap<>();

  static {

    beverageMap.put("coffee",
        new Beverage("coffee", new String[] {"coffee", "milk", "sugar", "water"}, 5));
    beverageMap.put("chai",
        new Beverage("chai", new String[] {"tea", "milk", "sugar", "water"}, 4));
    beverageMap.put("banana smoothie",
        new Beverage("banana smoothie", new String[] {"banana", "milk", "sugar", "water"}, 6));
    beverageMap.put("strawberry shake", new Beverage("strawberry shake",
        new String[] {"strawberries", "sugar", "milk", "water"}, 7));
    beverageMap.put("mojito",
        new Beverage("mojito", new String[] {"lemon", "sugar", "water", "soda", "mint"}, 7.5));

    ingredientMap.put("milk", 1d);
    ingredientMap.put("sugar", 0.5);
    ingredientMap.put("soda", 0.5);
    ingredientMap.put("mint", 0.5);
    ingredientMap.put("water", 0.5);
  }

  public static Map<String, Beverage> getBeverageMap() {
    return beverageMap;
  }

  public static Map<String, Double> getIngredientMap() {
    return ingredientMap;
  }
}
