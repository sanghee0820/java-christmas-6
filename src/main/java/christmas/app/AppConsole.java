package christmas.app;

import christmas.controller.ChristmasController;

public class AppConsole {
    private final InputView inputView;
    private final OutputView outputView;

    private final InputValidator inputValidator;
    private final ChristmasController christmasController;

    public AppConsole() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.inputValidator = new InputValidator();
        this.christmasController = new ChristmasController();
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

    public void run(){
        int day = enterVisitDay();
    }
}
