package balancedDiet.bmi;

import balancedDiet.classification.Category;

public class BMICalculator implements BMI {
    private float height;
    private float weight;
    private float BMI;

    public BMICalculator(){}

    public BMICalculator(float height, float weight) {
        this.height = height;
        this.weight = weight;
        this.BMI = getBMI();
    }

    public Category getCategory(){
        if (BMI > 25) return new Category("Overweight", BMI);
        else if (BMI > 18) return new Category("Normal", BMI);
        else return new Category("Underweight", BMI);
    }
    
    @Override
    public float getBMI() {
        return weight / (height * height);
    }
}
