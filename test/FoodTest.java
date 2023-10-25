import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FoodTest {
    @Test
    public void test() {
        Food a = new Food("Apple", 10, 10, 2);
        assertEquals(a.is404020(), true);
    }
}