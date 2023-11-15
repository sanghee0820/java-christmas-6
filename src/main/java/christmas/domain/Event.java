package christmas.domain;

import christmas.enumType.Badge;
import java.util.List;

public class Event {

    int visitDay;
    List<Order> orderInfo;
    List<Benefit> benefitInfo;
    Badge badge;
    public Event(int day, List<Order> orderInfo, List<Benefit> benefitInfo, Badge badge) {
        this.visitDay = day;
        this.orderInfo = orderInfo;
        this.benefitInfo = benefitInfo;
        this.badge = badge;
    }

    public int getVisitDay() {
        return visitDay;
    }

    public List<Order> getOrderInfo() {
        return orderInfo;
    }

    public List<Benefit> getBenefitInfo() {
        return benefitInfo;
    }

    public Badge getBadge() {
        return badge;
    }
}
