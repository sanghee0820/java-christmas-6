package christmas.repository;

import christmas.domain.Food;
import java.util.HashMap;
import java.util.List;

public class FoodRepository {
    HashMap<String, Food> food = new HashMap<>();

    public FoodRepository() {
        List<String> foodName = List.of("양송이수프", "타파스", "시저샐러드", "티본스테이크", "바비큐립", "해산물파스타", "크리스마스파스타",
                "초코케이크", "아이스크림", "제로콜라", "레드와인", "샴페인");
        List<Integer> foodPrice = List.of(6000, 5500, 8000, 55000, 54000, 35000, 25000,
                15000, 50000, 3000, 60000, 25000);
        List<String> foodType = List.of("Appetizer", "Appetizer", "Appetizer", "Main", "Main", "Main", "Main",
                "Desert", "Desert", "Beverage", "Beverage", "Beverage");
        for (int index = 0; index < foodName.size(); index++) {
            food.put(foodName.get(index),
                    new Food(foodName.get(index), foodPrice.get(index), foodType.get(index)));
        }
    }

    public List<String> getAllFoodName() {
        return food.keySet().stream().toList();
    }

}
