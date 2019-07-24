package balancedDiet.classification;

public class Category {
    private String name;
    private double bmiIndex;

    public Category(String name, double bmiIndex) {
        this.name = name;
        this.bmiIndex = bmiIndex;
    }

    public String getName() {
        return name;
    }

    public double getBmiIndex() {
        return bmiIndex;
    }
}
