package balancedDiet.food;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Food {
    private void readFoodItems(String fileName, List<FoodItems> items) throws IOException {
        List<String> list = Files.readAllLines(Paths.get(fileName));
        for(String line : list){
            String[] inputs = line.trim().split(" ");
            if (inputs.length <= 4) continue;
            items.add(new FoodItems(inputs[0], new Nutrients(inputs)));
        }
    }

    public List<FoodItems> getAllItems() throws IOException{
        List<FoodItems> list = new ArrayList<>();
        readFoodItems("D:\\BalancedDiet\\src\\resources\\Food.txt", list);
        return list;
    }
}
