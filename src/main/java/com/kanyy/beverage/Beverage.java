package com.kanyy.beverage;

public class Beverage {
  private String name;
  private String[] ingredients;
  private double price;

  public Beverage(String name, String[] ingredients, double price) {
    this.name = name;
    this.ingredients = ingredients;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String[] getIngredients() {
    return ingredients;
  }

  public void setIngredients(String[] ingredients) {
    this.ingredients = ingredients;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }
}
