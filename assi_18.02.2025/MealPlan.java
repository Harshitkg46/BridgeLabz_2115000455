// Define the MealPlan interface
interface MealPlan {
    String getMealDetails();
}

// Implement specific meal plan types
class VegetarianMeal implements MealPlan {
    @Override
    public String getMealDetails() {
        return "Vegetarian Meal: Includes vegetables, fruits, grains, and dairy.";
    }
}

class VeganMeal implements MealPlan {
    @Override
    public String getMealDetails() {
        return "Vegan Meal: Includes plant-based foods only, no animal products.";
    }
}

class KetoMeal implements MealPlan {
    @Override
    public String getMealDetails() {
        return "Keto Meal: Low-carb, high-fat meals with moderate protein.";
    }
}

class HighProteinMeal implements MealPlan {
    @Override
    public String getMealDetails() {
        return "High-Protein Meal: Includes protein-rich foods like chicken, fish, and legumes.";
    }
}

// Generic class to handle meal plans
class Meal<T extends MealPlan> {
    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public T getMealPlan() {
        return mealPlan;
    }

    public void displayMealPlan() {
        System.out.println(mealPlan.getMealDetails());
    }
}

// MealPlanGenerator with generic methods
class MealPlanGenerator {
    // Generic method to validate a meal plan
    public static <T extends MealPlan> boolean validateMealPlan(T mealPlan) {
        // For simplicity, all meal plans are considered valid
        System.out.println("Validating meal plan: " + mealPlan.getMealDetails());
        return true;
    }

    // Generic method to generate a personalized meal
    public static <T extends MealPlan> Meal<T> generateMealPlan(T mealPlan) {
        if (validateMealPlan(mealPlan)) {
            System.out.println("Meal plan validated successfully!");
            return new Meal<>(mealPlan);
        } else {
            throw new IllegalArgumentException("Invalid meal plan");
        }
    }
}

// Main class
public class PersonalizedMealPlanSystem {
    public static void main(String[] args) {
        // Create specific meal plans
        VegetarianMeal vegetarianMeal = new VegetarianMeal();
        VeganMeal veganMeal = new VeganMeal();
        KetoMeal ketoMeal = new KetoMeal();
        HighProteinMeal highProteinMeal = new HighProteinMeal();

        // Generate and display meal plans
        System.out.println("Personalized Meal Plans:");

        Meal<VegetarianMeal> vegetarianMealPlan = MealPlanGenerator.generateMealPlan(vegetarianMeal);
        vegetarianMealPlan.displayMealPlan();

        Meal<VeganMeal> veganMealPlan = MealPlanGenerator.generateMealPlan(veganMeal);
        veganMealPlan.displayMealPlan();

        Meal<KetoMeal> ketoMealPlan = MealPlanGenerator.generateMealPlan(ketoMeal);
        ketoMealPlan.displayMealPlan();

        Meal<HighProteinMeal> highProteinMealPlan = MealPlanGenerator.generateMealPlan(highProteinMeal);
        highProteinMealPlan.displayMealPlan();
    }
}
