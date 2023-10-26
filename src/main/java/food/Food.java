package main.java.food;
public class Food {
    private String name;
    private int proteins, carbs, fats, caloriesPerServing;
    private double servings;

    public Food(String name, int proteins, int carbs, int fats, int caloriesPerServing, double servings) {
        this.name = name;
        this.proteins = proteins;
        this.carbs = carbs;
        this.fats = fats;
        this.caloriesPerServing = caloriesPerServing;
        this.servings = servings;
    }

    public Food(String name, int proteins, int carbs, int fats, int caloriesPerServing) {
        this.name = name;
        this.proteins = proteins;
        this.carbs = carbs;
        this.fats = fats;
        this.caloriesPerServing = caloriesPerServing;
        this.servings = 1;
    }

    public Food(String name, int proteins, int carbs, int fats) {
        this.name = name;
        this.proteins = proteins;
        this.carbs = carbs;
        this.fats = fats;
        this.caloriesPerServing = calculateCalories(proteins, carbs, fats);
        this.servings = 1;
    }

    public String toString() {
        return name + " nutrient values:\n"
                + "\t- Calories: " + caloriesPerServing +" cals\n"
                + "\t- Servings: " + servings + "\n"
                + "\t- Proteins " + proteins + "g\n"
                + "\t- Carbs " + carbs + "g\n"
                + "\t- Fats " + fats + "g\n";
    }


    private int calculateCalories(int proteins, int carbs, int fats) {
        return proteinsToCalories(proteins) + carbsToCalories(carbs) + fatsToCalories(fats);
    }

    public boolean is404020() {
        return isPercentOf(getProteinCalories(), getTotalCalories(), 0.4)
                && isPercentOf(getCarbCalories(), getTotalCalories(), 0.4)
                && isPercentOf(getFatCalories(), getTotalCalories(), 0.1);
    }


    public double getTotalCalories() { return caloriesPerServing * servings; }

    private int proteinsToCalories(int proteins) { return proteins * 4; }
    private int carbsToCalories(int carbs) { return carbs * 4; }
    private int fatsToCalories(int fats) { return fats * 9; }

    public int getProteinCalories() { return proteinsToCalories(proteins); }
    public int getCarbCalories() { return carbsToCalories(carbs); }
    public int getFatCalories() { return fatsToCalories(fats); }

    public int getProteinPercent() { return roundedPercentString(getProteinPercent(), getTotalCalories()); }
    public int getCarbPercent() { return roundedPercentString(getCarbPercent(), getTotalCalories()); }
    public int getFatPercent() { return roundedPercentString(getFatPercent(), getTotalCalories()); }

    public String getPercentString() {
        return String.format("Ration: P:%d% C:34% F: %d%", getProteinPercent(), getCarbPercent(), getFatPercent());
    }

    private int roundedPercentString(double part, double whole) { return (int) Math.round(part/whole); }

    private boolean isPercentOf(double part, double whole, double expectedDecimal) {
        double maxMarginDecimal = 10;

        return Math.abs((part/whole) - expectedDecimal) <= maxMarginDecimal;
    }
}