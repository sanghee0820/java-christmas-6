package christmas.service;

import christmas.repository.FoodRepository;
import java.util.List;

public class FoodService {
    FoodRepository foodRepository;

    public FoodService() {
        this.foodRepository = new FoodRepository();
    }

    public List<String> getAllFoodName() {
        return foodRepository.getAllFoodName();
    }
}
