package christmas.DTO;

import christmas.domain.Benefit;
import christmas.domain.Event;
import christmas.domain.Order;
import java.util.HashMap;
import java.util.List;

public class EventDTO {
    int totalPrice;
    int visitDay;
    HashMap<String, Integer> orderInfo;
    HashMap<String, Integer> benefitInfo;
    String badge;
    public EventDTO(Event christmasEvent) {
        this.orderInfo = orderInfoToDTO(christmasEvent.getOrderInfo());
        this.totalPrice = getTotalPrice(christmasEvent.getOrderInfo());
        this.visitDay = christmasEvent.getVisitDay();
        this.benefitInfo = benefitInfoToDTO(christmasEvent.getBenefitInfo());
        this.badge = christmasEvent.getBadge().getDesc();
    }

    public int getVisitDay() {
        return visitDay;
    }

    public HashMap<String, Integer> getOrderInfo() {
        return orderInfo;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public HashMap<String, Integer> getBenefitInfo() {
        return benefitInfo;
    }

    public String getBadge() {
        return badge;
    }

    private HashMap<String, Integer> orderInfoToDTO(List<Order> orderInfo) {
        HashMap<String, Integer> orderInfoDTO = new HashMap<>();
        for (Order order : orderInfo) {
            orderInfoDTO.put(order.getFood().getName(), order.getQuantity());
        }
        return orderInfoDTO;
    }

    private int getTotalPrice(List<Order> orderInfo) {
        int totalPrice = 0;
        for (Order order : orderInfo) {
            totalPrice += order.getFood().getPrice() * order.getQuantity();
        }
        return totalPrice;
    }

    private HashMap<String, Integer> benefitInfoToDTO(List<Benefit> benefitInfo) {
        HashMap<String, Integer> benefitDTO = new HashMap<>();
        for (Benefit benefit : benefitInfo) {
            benefitDTO.put(benefit.getDiscountType().getDesc(), benefit.getDiscountPrice());
        }
        return benefitDTO;
    }

    @Override
    public String toString() {
        return "EventDTO{" +
                "orderInfo=" + orderInfo +
                ", totalPrice=" + totalPrice +
                ", benefitInfo=" + benefitInfo +
                ", badge='" + badge + '\'' +
                '}';
    }
}
