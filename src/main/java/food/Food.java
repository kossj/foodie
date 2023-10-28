package main.java.food;

public class Food {
    private String name, foodType;
    private double proteins, carbs, fats;
    private double caloriesPerServing; // Changed to double
    private double servings;

    public Food(String name, double proteins, double carbs, double fats, double caloriesPerServing, double servings) {
        this.name = name;
        this.proteins = proteins;
        this.carbs = carbs;
        this.fats = fats;
        this.caloriesPerServing = caloriesPerServing;
        this.servings = servings;
    }

    public Food(String name, double proteins, double carbs, double fats, double caloriesPerServing) {
        this.name = name;
        this.proteins = proteins;
        this.carbs = carbs;
        this.fats = fats;
        this.caloriesPerServing = caloriesPerServing;
        this.servings = calculateCalories(proteins, carbs, fats) / caloriesPerServing;
    }

    public Food(String name, String foodType, double proteins, double carbs, double fats) {
        this.name = name;
        this.foodType = foodType;
        this.proteins = proteins;
        this.carbs = carbs;
        this.fats = fats;
        this.caloriesPerServing = calculateCalories(proteins, carbs, fats);
        this.servings = 1;
    }

    public Food(String name, double proteins, double carbs, double fats) {
        this.name = name;
        this.proteins = proteins;
        this.carbs = carbs;
        this.fats = fats;
        this.caloriesPerServing = calculateCalories(proteins, carbs, fats);
        this.servings = 1;
    }

    public String toString() {
        return name + " nutrient values:\n"
                + "\t- Food Type: " + foodType + "\n"
                + "\t- Calories: " + caloriesPerServing + " cals\n"
                + "\t- Servings: " + servings + "\n"
                + "\t- Proteins " + proteins + "g\n"
                + "\t- Carbs " + carbs + "g\n"
                + "\t- Fats " + fats + "g\n"
                + "\t- Lean: " + isLean() + "\n"
                + "\t- " + getPercentString() + "\n";
    }

    private double calculateCalories(double proteins, double carbs, double fats) {
        return proteinsToCalories(proteins) + carbsToCalories(carbs) + fatsToCalories(fats);
    }

    public boolean is404020() {
        return isPercentOf(getProteinCalories(), getTotalCalories(), 0.4)
                && isPercentOf(getCarbCalories(), getTotalCalories(), 0.4)
                && isPercentOf(getFatCalories(), getTotalCalories(), 0.1);
    }

    public boolean isLean() {
        return getProteinCalories() / getTotalCalories() > 0.6;
    }

    public double getTotalCalories() {
        return caloriesPerServing * servings;
    }

    private double proteinsToCalories(double proteins) {
        return proteins * 4;
    }

    private double carbsToCalories(double carbs) {
        return carbs * 4;
    }

    private double fatsToCalories(double fats) {
        return fats * 9;
    }

    public double getProteinCalories() {
        return proteinsToCalories(proteins);
    }

    public double getCarbCalories() {
        return carbsToCalories(carbs);
    }

    public double getFatCalories() {
        return fatsToCalories(fats);
    }

    private double roundedPercent(double part, double whole, int places) {
        return Math.round((part / whole * 100) * Math.pow(10, places)) / Math.pow(10, places);
    }
    
    private boolean isPercentOf(double part, double whole, double expectedDecimal) {
        double maxMarginDecimal = 0.10; // Adjusted the margin to 0.10

        return Math.abs((part / whole) - expectedDecimal) <= maxMarginDecimal;
    }

    

    public double getProteinPercent() {
        return roundedPercent(getProteinCalories() / servings, caloriesPerServing, 2);
    }

    public double getCarbPercent() {
        return roundedPercent(getCarbCalories() / servings, caloriesPerServing, 2);
    }

    public double getFatPercent() {
        return roundedPercent(getFatCalories() / servings, caloriesPerServing, 2);
    }

    public String getPercentString() {
        return "Ratio: P: " + getProteinPercent() + "% C: " + getCarbPercent() + "% F: " + getFatPercent() + "%";
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
        this.caloriesPerServing = calculateCalories(proteins, carbs, fats);
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
        this.caloriesPerServing = calculateCalories(proteins, carbs, fats);
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
        this.caloriesPerServing = calculateCalories(proteins, carbs, fats);
    }

    public double getCaloriesPerServing() {
        return caloriesPerServing;
    }

    public void setCaloriesPerServing(double caloriesPerServing) {
        this.caloriesPerServing = caloriesPerServing;
    }

    public double getServings() {
        return servings;
    }

    public void setServings(double servings) {
        this.servings = servings;
    }
}
