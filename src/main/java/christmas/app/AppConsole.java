package christmas.app;

import christmas.DTO.EventDTO;
import christmas.controller.ChristmasController;
import java.util.HashMap;
import java.util.List;

public class AppConsole {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidator inputValidator;
    private final ChristmasController christmasController;
    private final HashMap<String, String> menuInfo;

    public AppConsole() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.inputValidator = new InputValidator();
        this.christmasController = new ChristmasController();
        menuInfo = christmasController.getAllFood();// 서버에서 가져올 예정.
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
                inputValidator.validateOnlyBeverage(menuInfo, menuName);
                return inputValidator.validateUniqueMenu(menuName, menuQuantity);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void run() {
        int day = enterVisitDay();
        HashMap<String, Integer> orders = enterMenu();
        EventDTO eventInfo = christmasController.getEventInfo(day, orders);
        outputView.showResult(eventInfo);
    }
}
