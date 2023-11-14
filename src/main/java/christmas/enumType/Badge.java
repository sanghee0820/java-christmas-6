package christmas.enumType;

public enum Badge {
    NONE("없음"),
    STAR("별"),
    TREE("트리"),
    SANTA("산타");

    String desc;

    Badge(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
