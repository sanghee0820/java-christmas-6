package christmas.domain;

import christmas.enumType.Badge;
import java.util.List;

public class Event {
    List<Order> orderInfo;
    List<Benefit> benefitInfo;
    Badge badge;

    public Event(List<Order> orderInfo, List<Benefit> benefitInfo, Badge badge) {
        this.orderInfo = orderInfo;
        this.benefitInfo = benefitInfo;
        this.badge = badge;
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
