package balancedDiet.food;

public class FoodItems {
    private String name;
    private Nutrients nutrients;

    FoodItems(String name, Nutrients nutrients) {
        this.name = name;
        this.nutrients = nutrients;
    }

    public int getCalories(){
        return nutrients.getProteins() * 4 + nutrients.getFats() * 9 + (nutrients.getCarbohydrates() - nutrients.getFibers()) * 4;
    }

    int getProteins(){
        return this.nutrients.getProteins();
    }

    int getFats(){
        return this.nutrients.getFats();
    }

    public String getName() {
        return name;
    }

    Nutrients getNutrients() {
        return nutrients;
    }

    @Override
    public String toString(){
        return "Food name is "+ getName() +" and calories are " +getCalories();
    }
}
