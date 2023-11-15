package christmas.service;

import christmas.domain.Order;
import christmas.repository.FoodRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FoodService {
    FoodRepository foodRepository;

    public FoodService() {
        this.foodRepository = new FoodRepository();
    }

    public HashMap<String, String> getAllFoodName() {
        return foodRepository.getAllFoodNameType();
    }

    public List<Order> setOrderInfo(HashMap<String, Integer> orders) {
        List<Order> orderInfo = new ArrayList<>();
        for (String foodName : orders.keySet()) {
            orderInfo.add(
                    new Order(
                            foodRepository.findByName(foodName),
                            orders.get(foodName)
                    )
            );
        }
        return orderInfo;
    }
}
