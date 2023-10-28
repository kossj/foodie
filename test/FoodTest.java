import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.java.food.Food;

public class FoodTest {
    @Test
    public void is404020test() {
        Food a = new Food("Apple", 10, 10, 2);
        assertEquals(a.is404020(), true);
    }

    @Test
    public void is404020testFalse() {
        Food a = new Food("Apple", 10, 10, 3);
        assertEquals(a.is404020(), false);
    }

    @Test
    public void isLeanTest() {
        Food a = new Food("Apple", 10, 10, 2);
        assertEquals(a.isLean(), false);
    }

    @Test
    public void isLeanTestFalse() {
        Food a = new Food("Apple", 10, 10, 10);
        assertEquals(a.isLean(), false);
    }

    @Test
    public void getTotalCaloriesTest() {
        Food a = new Food("Apple", 10, 10, 2);
        assertEquals(a.getTotalCalories(), 98.0, 0.01);
    }

    @Test
    public void getProteinCaloriesTest() {
        Food a = new Food("Apple", 10, 10, 2);
        assertEquals(a.getProteinCalories(), 40.0, 0.01);
    }

    @Test
    public void getCarbCaloriesTest() {
        Food a = new Food("Apple", 10, 10, 2);
        assertEquals(a.getCarbCalories(), 40.0, 0.01);
    }

    @Test
    public void getFatCaloriesTest() {
        Food a = new Food("Apple", 10, 10, 2);
        assertEquals(a.getFatCalories(), 18.0, 0.01);
    }

    @Test
    public void getProteinPercentTest() {
        Food a = new Food("Apple", 10, 10, 2);
        assertEquals(a.getProteinPercent(), 40.82, 0.01);
    }

    @Test
    public void getCarbPercentTest() {
        Food a = new Food("Apple", 10, 10, 2);
        assertEquals(a.getCarbPercent(), 40.82, 0.01);
    }

    @Test
    public void getFatPercentTest() {
        Food a = new Food("Apple", 10, 10, 2);
        assertEquals(a.getFatPercent(), 18.37, 0.01);
    }

    @Test
    public void getPercentStringTest() {
        Food a = new Food("Apple", 10, 10, 2);
        assertEquals(a.getPercentString(), "Ratio: P: 40.82% C: 40.82% F: 18.37%");
    }

    @Test
    public void setNameTest() {
        Food a = new Food("Apple", 10, 10, 2);
        a.setName("Banana");
        assertEquals(a.getName(), "Banana");
    }

    @Test
    public void setFoodTypeTest() {
        Food a = new Food("Apple", 10, 10, 2);
        a.setFoodType("Fruit");
        assertEquals(a.getFoodType(), "Fruit");
    }

    @Test
    public void setProteinsTest() {
        Food a = new Food("Apple", 10, 10, 2);
        a.setProteins(20);
        assertEquals(a.getProteins(), 20.0, 0.01);
    }

    @Test
    public void setCarbsTest() {
        Food a = new Food("Apple", 10, 10, 2);
        a.setCarbs(20);
        assertEquals(a.getCarbs(), 20.0, 0.01);
    }

    @Test
    public void setFatsTest() {
        Food a = new Food("Apple", 10, 10, 2);
        a.setFats(20);
        assertEquals(a.getFats(), 20.0, 0.01);
    }

    @Test
    public void setCaloriesPerServingTest() {
        Food a = new Food("Apple", 10, 10, 2);
        a.setCaloriesPerServing(150);
        assertEquals(a.getCaloriesPerServing(), 150.0, 0.01);
    }

    @Test
    public void setServingsTest() {
        Food a = new Food("Apple", 10, 10, 2);
        a.setServings(2);
        assertEquals(a.getServings(), 2.0, 0.01);
    }
}