package christmas.enumType;

public enum Week {
    WEEKDAY(2023, 0),
    WEEKEND(0, 2023);

    int desertDiscount;
    int mainDiscount;

    Week(int desertDiscount, int mainDiscount) {
        this.desertDiscount = desertDiscount;
        this.mainDiscount = mainDiscount;
    }

    public int getMainDiscount() {
        return mainDiscount;
    }

    public int getDesertDiscount() {
        return desertDiscount;
    }

}
