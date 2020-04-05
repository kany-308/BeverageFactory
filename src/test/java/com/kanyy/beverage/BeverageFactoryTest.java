package com.kanyy.beverage;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BeverageFactoryTest {

  @Test
  public void testMultipleOrders() {
    String[] input = new String[] {"Chai, -sugar", "Chai", "Coffee, -milk"};
    // (4.0-0.5) + (4.0) + (5.0-1.0) = 11.5
    double expected = 11.5;
    double actual = BeverageFactory.orderPlaced(input);
    assertEquals(String.format("%.1f", expected), String.format("%.1f", actual));
  }

  @Test
  public void testSingleOrderWithoutExclusion() {
    String[] input = new String[] {"Chai"};
    // (4.0) = 4.0
    double expected = 4.0;
    double actual = BeverageFactory.orderPlaced(input);
    assertEquals(String.format("%.1f", expected), String.format("%.1f", actual));
  }

  @Test
  public void testSingleOrderWithExclusion() {
    String[] input = new String[] {"Strawberry Shake, -water"};
    // (7.0-0.5) = 6.5
    double expected = 6.5;
    double actual = BeverageFactory.orderPlaced(input);
    assertEquals(String.format("%.1f", expected), String.format("%.1f", actual));
  }

  @Test
  public void testOrderShouldHaveValidBeverage() {
    String[] input = new String[] {"Chai, -sugar", "Banana Shake"};
    // (4.0-0.5) + (0.0) = 3.5
    double expected = 3.5;
    double actual = BeverageFactory.orderPlaced(input);
    assertEquals(String.format("%.1f", expected), String.format("%.1f", actual));
  }

  @Test
  public void testOrderCanNotHaveAllIngredientsInExclusion() {
    String[] input = new String[] {"Mojito, -Lemon, -sugar, -water, -soda, -mint"};
    // (0.0) = 0.0
    double expected = 0;
    double actual = BeverageFactory.orderPlaced(input);
    assertEquals(String.format("%.1f", expected), String.format("%.1f", actual));
  }

}
