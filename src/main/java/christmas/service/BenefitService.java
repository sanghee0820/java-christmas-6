package christmas.service;

import christmas.domain.Benefit;
import christmas.domain.Day;
import christmas.domain.Order;
import christmas.enumType.Badge;
import christmas.enumType.Discount;
import christmas.enumType.Star;
import christmas.enumType.Week;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class BenefitService {
    public List<Benefit> getBenefitInfo(Day dayInfo, List<Order> orderInfo) {
        int totalPrice = 0;
        List<Benefit> benefitInfo = new ArrayList<>();
        HashMap<String, Integer> typeInfo = setBaseTypeInfo();
        for (Order order : orderInfo) {
            totalPrice += order.getQuantity() * order.getFood().getPrice();
            typeInfo.compute(order.getFood().getType(), (key, value) -> value + order.getQuantity());
        }
        if (totalPrice < 10000) {
            return benefitInfo;
        }
        Optional.of(getDayBenefit(dayInfo, typeInfo)).ifPresent(benefitInfo::addAll);
        Optional.ofNullable(getPriceBenefit(totalPrice)).ifPresent(benefitInfo::add);
        return benefitInfo;
    }


    private HashMap<String, Integer> setBaseTypeInfo() {
        HashMap<String, Integer> typeInfo = new HashMap<>();
        typeInfo.put("Main", 0);
        typeInfo.put("Desert", 0);
        typeInfo.put("Appetizer", 0);
        typeInfo.put("Beverage", 0);
        return typeInfo;
    }

    private List<Benefit> getDayBenefit(Day dayInfo, HashMap<String, Integer> typeInfo) {
        List<Benefit> benefits = new ArrayList<>();
        Optional.ofNullable(getDDayBenefit(dayInfo)).ifPresent(benefits::add);
        Optional.of(getWeekBenefit(dayInfo, typeInfo)).ifPresent(benefits::add);
        Optional.ofNullable(getStarBenefit(dayInfo)).ifPresent(benefits::add);
        return benefits;
    }

    private Benefit getDDayBenefit(Day dayInfo) {
        int day = dayInfo.getDay();
        if (day > 25) {
            return null;
        }
        return new Benefit(Discount.DDAY, (day - 1) * 100 + 1000);
    }

    private Benefit getStarBenefit(Day dayInfo) {
        Star star = dayInfo.getStar();
        if (star.equals(Star.NONE_STAR)) {
            return null;
        }
        return new Benefit(Discount.SPECIAL, 1000);
    }

    private Benefit getWeekBenefit(Day dayInfo, HashMap<String, Integer> typeInfo) {
        Week week = dayInfo.getWeek();
        if (week.equals(Week.WEEKEND)) {
            return new Benefit(Discount.WEEKEND, typeInfo.get("Main") * week.getMainDiscount());
        }
        return new Benefit(Discount.WEEDAY, typeInfo.get("Desert") * week.getDesertDiscount());
    }

    private Benefit getPriceBenefit(int totalPrice) {
        if (totalPrice < 100000) {
            return null;
        }
        return new Benefit(Discount.GIFT, 25000);
    }

    public Badge getBadge(List<Benefit> benefitInfo) {
        int totalPrice = 0;
        for (Benefit benefit : benefitInfo) {
            totalPrice += benefit.getDiscountPrice();
        }
        if (totalPrice < 5000) {
            return Badge.NONE;
        }
        if (totalPrice < 10000) {
            return Badge.STAR;
        }
        if (totalPrice < 20000) {
            return Badge.TREE;
        }
        return Badge.SANTA;
    }
}
