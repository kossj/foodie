package main.java.food;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner pantry = new Scanner(new File("src/main/java/food/pantry.txt"));
        while (pantry.hasNextLine()) {
            String name = pantry.next();
            double servings = pantry.nextDouble();
            double caloriesPerServing = pantry.nextDouble();
            double proteins = pantry.nextDouble();
            double carbs = pantry.nextDouble();
            double fats = pantry.nextDouble();

            Food a = new Food(name, proteins, carbs, fats, caloriesPerServing, servings);
            System.out.println(a.toString());
            
    }
}
}

