package christmas.app;

import christmas.DTO.EventDTO;
import java.util.HashMap;

public class OutputView {

    public void shoResult(EventDTO eventInfo) {
        System.out.println(dateResult(eventInfo.getVisitDay()));
        System.out.println(orderResult(eventInfo.getOrderInfo()));
    }

    private String dateResult(int day) {
        return "12월" + day + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n\n";
    }

    private String orderResult(HashMap<String, Integer> orderInfo) {
        StringBuilder order = new StringBuilder("<주문메뉴>\n");
        for (String key : orderInfo.keySet()) {
            order.append(key).append(" ").append(orderInfo.get(key)).append("개\n");
        }
        order.append("\n");
        return order.toString();
    }
    
}
