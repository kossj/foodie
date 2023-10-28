package main.java.food;

public class Main {
    public static void main(String[] args) {
        Food a = new Food("Olive_Oil", "oil", 0, 0, 14);

        System.out.println(a.toString());

        Food b = new Food("Chicken_Breast", "poultry", 76, 1, 17);
        System.out.println(b.toString());
    }
}
