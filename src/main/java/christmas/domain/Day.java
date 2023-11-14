package christmas.domain;

import christmas.enumType.Star;
import christmas.enumType.Week;

public class Day {
    int day;
    Star star;
    Week week;

    public Day(int day, Star star, Week week) {
        this.day = day;
        this.star = star;
        this.week = week;
    }
}
