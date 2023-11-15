package christmas.controller;

import christmas.DTO.EventDTO;
import christmas.domain.Benefit;
import christmas.domain.Day;
import christmas.domain.Event;
import christmas.domain.Order;
import christmas.enumType.Badge;
import christmas.service.BenefitService;
import christmas.service.DayService;
import christmas.service.FoodService;
import java.util.HashMap;
import java.util.List;

public class ChristmasController {
    private final DayService dayService;
    private final FoodService foodService;
    private final BenefitService benefitService;

    public ChristmasController() {
        this.dayService = new DayService();
        this.foodService = new FoodService();
        this.benefitService = new BenefitService();
    }

    public HashMap<String, String> getAllFood() {
        return foodService.getAllFoodName();
    }

    public EventDTO getEventInfo(int day, HashMap<String, Integer> orders) {
        Day dayInfo = dayService.getDayInfo(day);
        List<Order> orderInfo = foodService.setOrderInfo(orders);
        List<Benefit> benefitInfo = benefitService.getBenefitInfo(dayInfo, orderInfo);
        Badge badgeInfo = benefitService.getBadge(benefitInfo);
        Event christmasEvent = new Event(day, orderInfo, benefitInfo, badgeInfo);
        return new EventDTO(christmasEvent);
    }

}
