package christmas.app;

import christmas.controller.ChristmasController;

public class AppConsole {
    private final InputView inputView;
    private final OutputView outputView;
    private final ChristmasController christmasController;

    public AppConsole() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.christmasController = new ChristmasController();
    }

    public void enterVisitDay() {
        int day = inputView.enterVisitDay();
    }
}
