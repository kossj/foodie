package Food;

public class Food {
    private String name;
    private int proteins, carbs, fats;
    private double servings, calories;

    public Food(String name, int proteins, int carbs, int fats, int calories, double servings) {
        this.name = name;
        this.proteins = proteins;
        this.carbs = carbs;
        this.fats = fats;
        this.calories = calories;
        this.servings = servings;
    }

    public Food(String name, int proteins, int carbs, int fats, double servings) {
        this.name = name;
        this.proteins = proteins;
        this.carbs = carbs;
        this.fats = fats;
        this.servings = servings;

        this.calories = (proteinToCalories(proteins) + carbsToCalories(carbs) + fatsToCalories(fats)) / servings;
    }

    public Food(String name, int carbs, int proteins, int fats, double calories) {}


    private int proteinToCalories(int protein) { return protein * 4; }
    private int carbsToCalories(int carbs) { return carbs * 4; }
    private int fatsToCalories(int fats) { return fats * 9; }
}
