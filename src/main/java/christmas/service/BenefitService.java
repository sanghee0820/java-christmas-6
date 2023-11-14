package christmas.service;

import christmas.domain.Benefit;
import christmas.domain.Day;
import christmas.domain.Order;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BenefitService {
    public void getBenefitInfo(Day dayInfo, List<Order> orderInfo) {
        int totalPrice = 0;
        List<Benefit> benefitInfo = new ArrayList<>();
        HashMap<String, Integer> typeInfo = setBaseTypeInfo();
        for (Order order : orderInfo) {
            totalPrice += order.getQuantity() * order.getFood().getPrice();
            typeInfo.compute(order.getFood().getType(), (key, value) -> value + 1);
        }
        System.out.println(typeInfo);
    }

    private HashMap<String, Integer> setBaseTypeInfo() {
        HashMap<String, Integer> typeInfo = new HashMap<>();
        typeInfo.put("Main", 0);
        typeInfo.put("Desert", 0);
        typeInfo.put("Appetizer", 0);
        typeInfo.put("Beverage", 0);
        return typeInfo;
    }


}
