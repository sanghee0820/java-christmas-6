package christmas.app;

import christmas.DTO.EventDTO;
import java.text.DecimalFormat;
import java.util.HashMap;

public class OutputView {

    public void showResult(EventDTO eventInfo) {
        System.out.println(dateResult(eventInfo.getVisitDay()));
        System.out.println(orderResult(eventInfo.getOrderInfo()));
        System.out.println(totalPriceResult(eventInfo.getTotalPrice()));
        System.out.println(giftResult(eventInfo.getBenefitInfo()));
        System.out.println(benefitResult(eventInfo.getBenefitInfo(), eventInfo.getTotalPrice(), eventInfo.isGifted()));
        System.out.println(badgeResult(eventInfo.getBadge()));
    }

    private String dateResult(int day) {
        return "12월" + day + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n";
    }

    private String orderResult(HashMap<String, Integer> orderInfo) {
        StringBuilder order = new StringBuilder("<주문메뉴>\n");
        for (String key : orderInfo.keySet()) {
            order.append(key).append(" ").append(orderInfo.get(key)).append("개\n");
        }
        return order.toString();
    }

    private String totalPriceResult(int totalPrice) {
        StringBuilder price = new StringBuilder("<할인 전 총주문 금액>\n");
        price.append(new DecimalFormat("#,###").format(totalPrice)).append("원\n");
        return price.toString();
    }

    private String giftResult(HashMap<String, Integer> benefitInfo) {
        StringBuilder gift = new StringBuilder("<증정 메뉴>\n");
        if (benefitInfo.containsKey("증정 이벤트")) {
            gift.append("샴페인 1개\n\n");
            return gift.toString();
        }
        gift.append("없음\n");
        return gift.toString();
    }

    private String benefitResult(HashMap<String, Integer> benefitInfo, int totalPrice, boolean isGifted) {
        int totalBenefit = 0;
        StringBuilder gift = new StringBuilder("<혜택 내역>\n");
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        if (benefitInfo.isEmpty()) {
            gift.append("없음\n\n").append(priceBenefitResult(totalPrice, totalBenefit, isGifted));
            return gift.toString();
        }
        for (String key : benefitInfo.keySet()) {
            totalBenefit += benefitInfo.get(key);
            gift.append(key).append(": -").append(decimalFormat.format(benefitInfo.get(key))).append("원\n");
        }
        gift.append("\n").append(priceBenefitResult(totalPrice, totalBenefit, isGifted));
        return gift.toString();
    }

    private String priceBenefitResult(int totalPrice, int totalBenefit, boolean isGifted) {
        StringBuilder priceBenefit = new StringBuilder("<총혜택 금액>\n");
        DecimalFormat decimalFormat = new DecimalFormat("#,###");

        if (totalBenefit == 0) {
            priceBenefit.append("없음\n\n").append("<할인 후 예상 결제 금액>\n")
                    .append(decimalFormat.format(totalPrice - totalBenefit));
            return priceBenefit.toString();
        }
        priceBenefit.append("-").append(decimalFormat.format(totalBenefit)).append("원\n\n");
        if (isGifted) {
            totalBenefit -= 25000;
        }
        priceBenefit.append("<할인 후 예상 결제 금액>\n").append(decimalFormat.format(totalPrice - totalBenefit)).append("\n");
        return priceBenefit.toString();
    }

    private String badgeResult(String badge) {
        return "<12월 이벤트 배지>\n" + badge;
    }
}
