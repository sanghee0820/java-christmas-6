package christmas.enumType;


public enum Star {
    STAR(1000),
    NONE_STAR(0);
    final int starDiscount;

    Star(int discount) {
        this.starDiscount = discount;
    }

    public int getStarDiscount() {
        return starDiscount;
    }
}

