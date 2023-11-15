package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.Food;
import christmas.repository.FoodRepository;
import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FoodRepositoryTest {
    private FoodRepository foodRepository;

    @BeforeEach
    public void setUp() {
        foodRepository = new FoodRepository();
    }

    @Test
    public void getAllFoodNameType_ShouldReturnCorrectMapping() {
        // Given

        // When
        HashMap<String, String> allFoodNameType = foodRepository.getAllFoodNameType();

        // Then
        assertThat(allFoodNameType).isNotEmpty();
        assertThat(allFoodNameType).containsKeys("양송이수프", "타파스", "시저샐러드", "티본스테이크", "바비큐립", "해산물파스타", "크리스마스파스타",
                "초코케이크", "아이스크림", "제로콜라", "레드와인", "샴페인");
        assertThat(allFoodNameType).containsValues("Appetizer", "Appetizer", "Appetizer",
                "Main", "Main", "Main", "Main",
                "Desert", "Desert", "Beverage", "Beverage", "Beverage");
    }

    @Test
    public void findByName_ShouldReturnCorrectFood() {
        // Given
        String foodName = "티본스테이크";
        // When
        Food foundFood = foodRepository.findByName(foodName);
        // Then
        assertThat(foundFood).isNotNull();
        assertThat(foundFood.getName()).isEqualTo(foodName);
        assertThat(foundFood.getPrice()).isEqualTo(55000);
        assertThat(foundFood.getType()).isEqualTo("Main");
    }

}
