package christmas.DTO;

import christmas.domain.Benefit;
import christmas.domain.Event;
import christmas.domain.Order;
import java.util.HashMap;
import java.util.List;

public class EventDTO {
    HashMap<String, Integer> orderInfo;
    HashMap<String, Integer> benefitInfo;
    String badge;

    public EventDTO(Event christmasEvent) {
        this.orderInfo = orderInfoToDTO(christmasEvent.getOrderInfo());
        this.benefitInfo = benefitInfoToDTO(christmasEvent.getBenefitInfo());
        this.badge = christmasEvent.getBadge().getDesc();
    }

    private HashMap<String, Integer> orderInfoToDTO(List<Order> orderInfo) {
        HashMap<String, Integer> orderInfoDTO = new HashMap<>();
        for (Order order : orderInfo) {
            orderInfoDTO.put(order.getFood().getName(), order.getQuantity());
        }
        return orderInfoDTO;
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
                ", benefitInfo=" + benefitInfo +
                ", badge='" + badge + '\'' +
                '}';
    }
}
