package balancedDiet;

import balancedDiet.bmi.BMICalculator;
import balancedDiet.classification.Category;
import balancedDiet.food.Meal;
import balancedDiet.gui.View;

public class Person{
    private int age;
    private String name;
    private float height;
    private float weight;
    private Meal meal = new Meal();

    public Person() {}

    public Person getPerson(){
        age = Integer.parseInt(View.ageText.getText().trim());
        name = View.nameText.getText();
        height = Float.parseFloat(View.heightText.getText().trim());
        weight = Float.valueOf(View.weightText.getText().trim());
        return new Person(age, name, height, weight);
    }

    private Person(int age, String name, float height, float weight) {
        this.age = age;
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    private Meal getMeal(){
        return meal;
    }

    public Meal suggestLunch(){
        return this.getMeal().suggestLunch(this.getCategory());
    }

    public Meal suggestDinner(){
        return this.getMeal().suggestDinner(this.getCategory());
    }

    public Meal suggestBreakfast(){
        return this.getMeal().suggestBreakfast(this.getCategory());
    }

    public Category getCategory() {
        return new BMICalculator(height, weight).getCategory();
    }

}
