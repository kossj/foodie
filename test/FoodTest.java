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
    public void totalCaloriesTest() {
        Food a = new Food("Apple",10,10,2);
        assertEquals(a.getName(), "Apple");
    }
}