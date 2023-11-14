package christmas.repository;

import christmas.enumType.Star;
import christmas.enumType.Week;
import java.util.List;

public class DayRepository {
    private final List<Integer> star;
    private final List<Integer> weekend;

    public DayRepository() {
        this.star = List.of(3, 10, 17, 24, 25, 31);
        this.weekend = List.of(1, 2, 8, 9, 15, 16, 22, 23, 29, 30);
    }

    public Star isStar(int day) {
        if (star.contains(day)) {
            return Star.STAR;
        }
        return Star.NONE_STAR;
    }

    public Week isWeekend(int day) {
        if (weekend.contains(day)) {
            return Week.WEEKEND;
        }
        return Week.WEEKDAY;
    }
}
