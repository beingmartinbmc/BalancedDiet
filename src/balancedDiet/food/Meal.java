package balancedDiet.food;

import balancedDiet.Author;
import balancedDiet.classification.Category;

import java.io.IOException;
import java.util.*;

@Author(name = "Ankit Sharma", date = "22/July/2019")
public class Meal {
    private String name;
    private int calories, proteins, fats, carbs, fibers;
    private List<FoodItems> items;
    private PriorityQueue<FoodItems> minHeap, maxHeap, proteinRich, fatRich;
    private Meal meal;

    public Meal() {
        try{
            prepareMeals();
        }
        catch (IOException h){
            h.printStackTrace();
        }
    }

    private Meal(FoodItems... a){
       prepareMealUtil(a);
    }

    public int getCalories(){
        return calories;
    }

    public int getProteins(){
        return proteins;
    }

    public int getFats(){
        return fats;
    }

    public int getFibers(){
        return fibers;
    }

    public int getCarbs(){
        return carbs;
    }

    public String getName(){
        return name;
    }

    private void prepareMealUtil(FoodItems... a){
        StringBuilder b = new StringBuilder();
        int calories = 0;
        int proteins = 0, fats = 0, fibers = 0, carbs = 0;
        b.append("(");
        for(int i=0; i<a.length-1; i++){
            b.append(a[i].getName());
            b.append(" + ");
            calories += a[i].getCalories();
            proteins += a[i].getNutrients().getProteins();
            fats += a[i].getNutrients().getFats();
            fibers += a[i].getNutrients().getFibers();
            carbs += a[i].getNutrients().getCarbohydrates();
        }
        b.append(a[a.length-1].getName());
        b.append(")");
        this.name = b.toString();
        this.calories = calories + a[a.length - 1].getCalories();
        this.proteins = proteins + a[a.length - 1].getNutrients().getProteins();
        this.fats = fats + a[a.length - 1].getNutrients().getFats();
        this.fibers = fibers + a[a.length - 1].getNutrients().getFibers();
        this.carbs = carbs + a[a.length -1].getNutrients().getCarbohydrates();
    }

    private void prepareMeals() throws IOException {
        items = new Food().getAllItems();
        minHeap = new PriorityQueue<>(Comparator.comparing(FoodItems::getCalories));
        maxHeap = new PriorityQueue<>(Comparator.comparing(FoodItems::getCalories).reversed());
        proteinRich = new PriorityQueue<>(Comparator.comparing(FoodItems::getProteins).reversed());
        fatRich = new PriorityQueue<>(Comparator.comparing(FoodItems::getFats).reversed());
        items.forEach(e->{
            minHeap.offer(e);
            maxHeap.offer(e);
            proteinRich.offer(e);
            fatRich.offer(e);
        });
    }

    private FoodItems getRandomElement(List<FoodItems> list){
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    private Meal getLightMeal(){
        FoodItems[] items = new FoodItems[5];
        for(int i=0; i<5; i++) items[i] = minHeap.poll();
        meal = new Meal(items);
        return meal;
    }

    private Meal getProteinRichMeal(){
        FoodItems[] items = new FoodItems[5];
        for(int i=0; i<5; i++) items[i] = proteinRich.poll();
        meal = new Meal(items);
        return meal;
    }

    private Meal getHeavyMeal(){
        FoodItems[] items = new FoodItems[5];
        for(int i=0; i<5; i++) items[i] = maxHeap.poll();
        meal = new Meal(items);
        return meal;
    }

    private Meal getFatsRichMeal(){
        FoodItems[] items = new FoodItems[5];
        for(int i=0; i<5; i++) items[i] = fatRich.poll();
        meal = new Meal(items);
        return meal;
    }

    private Meal getRandomMeal(){
        List<FoodItems> temp = new ArrayList<>(items);
        Collections.shuffle(temp);
        FoodItems[] items = new FoodItems[5];
        Set<FoodItems> set = new HashSet<>();
        while (set.size() != 5) set.add(getRandomElement(temp));
        int p = 0;
        for(FoodItems item : set) items[p++] = item;
        meal = new Meal(items);
        return meal;
    }

    public Meal suggestBreakfast(Category category) {
        switch (category.getName()){
            case "Normal":
                meal = getHeavyMeal();
                break;
            case "Overweight":
                meal = getProteinRichMeal();
                break;
            case "Underweight":
                meal = getFatsRichMeal();
                break;
        }
        return meal;
    }

    public Meal suggestLunch(Category category){
        switch (category.getName()){
            case "Normal":
                meal = getRandomMeal();
                break;
            case "Overweight":
                meal = getLightMeal();
                break;
            case "Underweight":
                meal = getHeavyMeal();
                break;
        }
        return meal;
    }

    public Meal suggestDinner(Category category){
        switch (category.getName()){
            case "Normal":
                meal = getRandomMeal();
                break;
            case "Underweight":
                meal = getProteinRichMeal();
                break;
            case "Overweight":
                meal  = getLightMeal();
                break;
        }
        return meal;
    }

    @Override
    public String toString(){
        return getMealDetails();
    }

    private String getMealDetails(){
        return "Meal name is " + this.getName() + "\nCalorie count is " +this.getCalories() + "\nNutrient count\n"
                +
                "Proteins are "+ getProteins() + "\nFats are "+getFats() + "\nCarbs are " + getCarbs() + "\nFibers are " + getFibers();
    }
}