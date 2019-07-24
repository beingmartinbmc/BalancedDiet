package balancedDiet.food;

class Nutrients {
    private int proteins;
    private int carbohydrates;
    private int fibers;
    private int fats;

    Nutrients(String[] a){
        this(Integer.parseInt(a[1]), Integer.parseInt(a[2]), Integer.parseInt(a[3]), Integer.parseInt(a[4]));
    }

    private Nutrients(int proteins, int carbohydrates, int fibers, int fat) {
        this.proteins = proteins;
        this.carbohydrates = carbohydrates;
        this.fibers = fibers;
        this.fats = fat;
    }

    int getProteins() {
        return proteins;
    }

    int getCarbohydrates() {
        return carbohydrates;
    }

    int getFibers() {
        return fibers;
    }

    int getFats() {
        return fats;
    }
}
