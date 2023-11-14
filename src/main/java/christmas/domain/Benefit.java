package christmas.domain;

import christmas.enumType.Discount;

public class Benefit {
    Discount discountType;
    int discountPrice;

    public Benefit(Discount discountType, int discountPrice) {
        this.discountType = discountType;
        this.discountPrice = discountPrice;
    }

    @Override
    public String toString() {
        return "Benefit{" +
                "discountType=" + discountType +
                ", discountPrice=" + discountPrice +
                '}';
    }
}
