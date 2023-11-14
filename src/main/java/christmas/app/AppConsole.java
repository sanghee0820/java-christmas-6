package christmas.app;

import christmas.controller.ChristmasController;
import java.util.HashMap;
import java.util.List;

public class AppConsole {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidator inputValidator;
    private final ChristmasController christmasController;
    private final List<String> menuInfo;

    public AppConsole() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.inputValidator = new InputValidator();
        this.christmasController = new ChristmasController();
        menuInfo = List.of("양송이수프", "타파스", "시저샐러드",
                "티본스테이크", "바비큐립", "해산물파스타", "크리스마스파스타",
                "초코케이크", "아이스크림",
                "제로콜라", "레드와인", "샴페인");  // 서버에서 가져올 예정.
    }

    public int enterVisitDay() {
        while (true) {
            String dayInput = inputView.enterVisitDay();
            try {
                int day = inputValidator.validateSingleNumber(dayInput);
                return inputValidator.validateDayInRange(day);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + "\n");
            }
        }
    }

    public HashMap<String, Integer> enterMenu() {
        while (true) {
            String menuInput = inputView.enterMenu();
            try {
                List<List<String>> parsedInput = inputValidator.validateMenuMatchWithForm(menuInput);
                List<String> menuName = inputValidator.validateInputInMenu(menuInfo, parsedInput.get(0));
                List<Integer> menuQuantity = inputValidator.validateQuantityMatchWithForm(parsedInput.get(1));
                inputValidator.validateTotalQuantity(menuQuantity);
                return inputValidator.validateUniqueMenu(menuName, menuQuantity);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void run() {
        int day = enterVisitDay();
        HashMap<String, Integer> order = enterMenu();
        System.out.println(day);
        System.out.println(order);
    }
}
