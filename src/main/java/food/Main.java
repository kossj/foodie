package main.java.food;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner pantry = new Scanner(new File("/workspaces/foodie/src/main/java/food/pantry.txt"));
        while (pantry.hasNextLine()) {
            System.out.println(foodFromDataFormat(pantry.next(), pantry.nextDouble(), pantry.nextInt(), pantry.nextInt(), pantry.nextInt(), pantry.nextInt()).toString());
        }
    }

    public static Food foodFromDataFormat(String name, double servings, int caloriesPerServing, int proteins, int carbs, int fats) {
        return new Food(name, proteins, carbs, fats, caloriesPerServing, servings);
    }
}
