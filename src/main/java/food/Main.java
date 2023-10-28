package main.java.food;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner pantry = new Scanner(new File("src/main/java/food/pantry.txt"));
        FileWriter newPantry = new FileWriter("src/main/java/food/newPantry.txt");

        while (pantry.hasNextLine()) {
            String name = pantry.next();
            double servings = pantry.nextDouble();
            double caloriesPerServing = pantry.nextDouble();
            double proteins = pantry.nextDouble();
            double carbs = pantry.nextDouble();
            double fats = pantry.nextDouble();

            Food a = new Food(name, proteins, carbs, fats, caloriesPerServing, servings);
            newPantry.write(a.getMacrosString() + " " + a.getPercentLeanString() + "\n");
            
    }

    newPantry.close();

    
    Scanner fridge = new Scanner(new File("src/main/java/food/fridge.txt"));
    FileWriter newFridge = new FileWriter("src/main/java/food/newfridge.txt");

    while (fridge.hasNextLine()) {
            String name = fridge.next();
            double servings = fridge.nextDouble();
            double caloriesPerServing = fridge.nextDouble();
            double proteins = fridge.nextDouble();
            double carbs = fridge.nextDouble();
            double fats = fridge.nextDouble();

            Food a = new Food(name, proteins, carbs, fats, caloriesPerServing, servings);
            newFridge.write(a.getMacrosString() + " " + a.getPercentLeanString() + "\n");
            
    }
    
    newFridge.close();
}
}

