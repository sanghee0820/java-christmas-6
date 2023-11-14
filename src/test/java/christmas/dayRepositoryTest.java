package christmas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.enumType.Star;
import christmas.enumType.Week;
import christmas.repository.DayRepository;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class dayRepositoryTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 8, 9, 15, 16, 22, 23, 29, 30})
    void 주말인지_확인(int input) {
        DayRepository dayRepository = new DayRepository();
        assertEquals(Week.WEEKEND, dayRepository.isWeekend(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 10, 17, 24, 25, 31})
    void 스타인지_확인(int input) {
        DayRepository dayRepository = new DayRepository();
        assertEquals(Star.STAR, dayRepository.isStar(input));
    }
}
