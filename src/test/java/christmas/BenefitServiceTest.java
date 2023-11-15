package christmas;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.atIndex;
import static org.assertj.core.api.AssertionsForClassTypes.tuple;

import christmas.domain.Benefit;
import christmas.domain.Day;
import christmas.domain.Food;
import christmas.domain.Order;
import christmas.enumType.Badge;
import christmas.enumType.Discount;
import christmas.enumType.Star;
import christmas.enumType.Week;
import christmas.service.BenefitService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BenefitServiceTest {

    private BenefitService benefitService;

    @BeforeEach
    public void setUp() {
        benefitService = new BenefitService();
    }

    @Test
    public void getBenefitInfo_ShouldReturnCorrectBenefitList() {
        // Given
        Day dayInfo = new Day(10, Star.STAR, Week.WEEKDAY);
        List<Order> orderInfo = Arrays.asList(
                new Order(new Food("티본스테이크", 55000, "Main"), 2),
                new Order(new Food("해산물파스타", 35000, "Main"), 1)
        );

        // When
        List<Benefit> benefitInfo = benefitService.getBenefitInfo(dayInfo, orderInfo);

        // Then
        assertThat(benefitInfo)
                .extracting("discountType", "discountPrice")
                .contains(tuple(Discount.DDAY, 1900), atIndex(0))
                .contains(tuple(Discount.SPECIAL, 1000), atIndex(1))
                .contains(tuple(Discount.GIFT, 25000), atIndex(2));
    }

    @Test
    public void getBadge_ShouldReturnCorrectBadge() {
        // Given
        List<Benefit> benefits = new ArrayList<>();
        benefits.add(new Benefit(Discount.DDAY, 1300));
        benefits.add(new Benefit(Discount.WEEKEND, 2023));
        benefits.add(new Benefit(Discount.SPECIAL, 1000));
        // When
        Badge badge = benefitService.getBadge(benefits);

        // Then
        assertThat(badge).isEqualTo(Badge.NONE);
    }

}