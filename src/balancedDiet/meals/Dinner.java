package balancedDiet.meals;

import java.io.IOException;

class Dinner extends MealTime{
    Dinner(String n, String cal, String c, String p, String f, String fib) throws IOException {
        createFrame(n, cal + " gms (Calories)", c + " gms (Carbs)", p +" gms (Proteins)", f + " gms (Fats)", fib + " gms (Fiber)");
    }
}
