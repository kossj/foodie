public class Food {
    private String name;
    private int proteins, carbs, fats, totalCalories;
    private double servings;

    public Food(String name, int proteins, int carbs, int fats, int totalCalories, double servings) {
        this.name = name;
        this.proteins = proteins;
        this.carbs = carbs;
        this.fats = fats;
        this.totalCalories = totalCalories;
        this.servings = servings;
    }

    public Food(String name, int proteins, int carbs, int fats, int totalCalories) {
        this.name = name;
        this.proteins = proteins;
        this.carbs = carbs;
        this.fats = fats;
        this.totalCalories = totalCalories;
        this.servings = 1;
    }

    public Food(String name, int proteins, int carbs, int fats) {
        this.name = name;
        this.proteins = proteins;
        this.carbs = carbs;
        this.fats = fats;
        this.totalCalories = calculateCalories(proteins, carbs, fats);
        this.servings = 1;
    }

    public String toString() {
        return name + " nutrient values:\n"
                + "\t- Calories: " + getCaloriesPerServing() +" cals\n"
                + "\t- Servings: " + servings + "\n"
                + "\t- Proteins " + proteins + "g\n"
                + "\t- Carbs " + carbs + "g\n"
                + "\t- Fats " + fats + "g\n";
    }


    private int calculateCalories(int proteins, int carbs, int fats) {
        return proteinsToCalories(proteins) + carbsToCalories(carbs) + fatsToCalories(fats);
    }

    private boolean percentWithinMargin(double part, double whole, double goalDecimal, double marginDecimal) {
        return Math.abs((part/whole)-goalDecimal) <= marginDecimal;
    }

    public boolean is404020() {
        return percentWithinMargin(getProteinCalories(), totalCalories, 0.4, .1)
        && percentWithinMargin(getCarbCalories(), totalCalories, 0.4, .1)
        && percentWithinMargin(getFatCalories(), totalCalories, 0.2, .1);
    }

    public double getCaloriesPerServing() { return (double)totalCalories / servings; }
    public int getProteinCalories() { return proteinsToCalories(proteins); }
    public int getCarbCalories() { return carbsToCalories(carbs); }
    public int getFatCalories() { return fatsToCalories(fats); }

    private int proteinsToCalories(int proteins) { return proteins * 4; }
    private int carbsToCalories(int carbs) { return carbs * 4; }
    private int fatsToCalories(int fats) { return fats * 9; }
}
