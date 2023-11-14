package christmas.controller;

import christmas.service.DayService;
import christmas.service.FoodService;
import java.util.List;

public class ChristmasController {
    private final DayService dayService;
    private final FoodService foodService;

    public ChristmasController() {
        this.dayService = new DayService();
        this.foodService = new FoodService();
    }

    public List<String> getAllFood() {
        return foodService.getAllFoodName();
    }

}
