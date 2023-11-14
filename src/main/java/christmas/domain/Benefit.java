package christmas.domain;

import christmas.enumType.Discount;

public class Benefit {
    Discount discountType;
    int discountPrice;

    public Benefit(Discount discountType, int discountPrice) {
        this.discountType = discountType;
        this.discountPrice = discountPrice;
    }
}
