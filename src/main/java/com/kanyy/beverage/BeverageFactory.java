package com.kanyy.beverage;

import com.kanyy.data.MockData;

public class BeverageFactory {


  public static double orderPlaced(String[] orders) {
    double finalPrice = 0;
    for (String orderDetails : orders) {
      if (orderDetails != null && orderDetails.length() > 0) {
        // Splitting the order information to get ingredient(s)
        String[] ingredients = orderDetails.split(",");
        // The first ingredient will always represent the beverage or menu item
        String beverage = ingredients[0].trim().toLowerCase();
        // If there is no ingredient to exclude and it's valid beverage
        if (ingredients.length == 1 && MockData.getBeverageMap().containsKey(beverage)) {
          finalPrice += MockData.getBeverageMap().get(beverage).getPrice();
        }
        // If it's valid beverage and having ingredient(s) to exclude
        else if (MockData.getBeverageMap().containsKey(beverage)) {
          Beverage beverageObj = MockData.getBeverageMap().get(beverage);
          // If order doesn't have all the ingredients in exclusion
          if (ingredients.length <= beverageObj.getIngredients().length) {
            double price = beverageObj.getPrice();
            // Processing only valid exclusion ingredients
            for (int i = 1; i < ingredients.length; i++) {
              String excludeIngredient = ingredients[i].trim().substring(1).toLowerCase();
              // Checking for valid ingredient
              if (MockData.getIngredientMap().containsKey(excludeIngredient)) {
                price -= MockData.getIngredientMap().get(excludeIngredient);
              }
            }
            finalPrice += price;
          } else {
            System.out
                .println("An order cannot have all the ingredients in exclusion for a menu item");
          }
        } else {
          System.out.println("Each order should have at least one menu item");
        }
      } else {
        System.out.println("Each order should have at least one menu item");
      }
    }
    return finalPrice;
  }

  public static void main(String[] args) {
    System.out.println(orderPlaced(new String[] {"Coffee, -milk, -water", "Chai1"}));
  }

}
