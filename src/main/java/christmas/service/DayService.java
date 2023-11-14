package christmas.service;

import christmas.domain.Day;
import christmas.enumType.Star;
import christmas.enumType.Week;
import christmas.repository.DayRepository;

public class DayService {
    DayRepository dayRepository;

    public DayService() {
        this.dayRepository = new DayRepository();
    }

    public Day getDayInfo(int day) {
        Star star = dayRepository.isStar(day);
        Week week = dayRepository.isWeekend(day);
        return new Day(day, star, week);
    }
}
