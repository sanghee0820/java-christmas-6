package christmas;


import static org.assertj.core.api.Assertions.assertThat;

import christmas.repository.FoodRepository;
import org.junit.jupiter.api.Test;

public class FoodRepositoryTest {

    @Test
    void 음식이름테스트() {
        FoodRepository foodRepository = new FoodRepository();
        assertThat(foodRepository.getAllFoodName())
                .containsExactlyInAnyOrder("양송이수프", "타파스", "시저샐러드", "티본스테이크", "바비큐립", "해산물파스타", "크리스마스파스타",
                        "초코케이크", "아이스크림", "제로콜라", "레드와인", "샴페인");
    }

}
