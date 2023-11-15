package christmas;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import christmas.domain.Day;
import christmas.enumType.Star;
import christmas.enumType.Week;
import christmas.service.DayService;
import org.junit.jupiter.api.Test;

public class DayServiceTest {

    @Test
    void Day테스트() {
        DayService dayService = new DayService();
        Day day = new Day(2, Star.NONE_STAR, Week.WEEKEND);
        assertThat(dayService.getDayInfo(2).getWeek()).isEqualTo(day.getWeek());
    }
}
