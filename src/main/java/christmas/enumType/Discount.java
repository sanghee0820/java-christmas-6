package christmas.enumType;

public enum Discount {
    DDAY("크리스마스 디데이 할인"),
    WEEDAY("평일 할인"),
    WEEKEND("주말 할인"),
    SPECIAL("특별 할인"),
    GIFT("증정 이벤트");

    String desc;

    Discount(String desc) {
        this.desc = desc;
    }
}
