package christmas.app;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {

    public int validateSingleNumber(String inputValue) throws IllegalArgumentException {
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[Error] 입력값이 숫자가 아닙니다.");
        }
    }

    public int validateDayInRange(int day) throws IllegalArgumentException {
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("[Error] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
        return day;
    }

    public List<String> validateMenuMatchWithForm(String menuInput) throws IllegalArgumentException {
        menuInput = menuInput.replaceAll(" ", "");
        List<String> parsedWithBar = List.of(menuInput.split(","));
        List<String> parsedInput = new ArrayList<>();
        for (String data : parsedWithBar) {
            String[] parts = data.split("-");
            if (parts.length != 2) {
                throw new IllegalArgumentException("[Error] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
            parsedInput.add(parts[0]);
            parsedInput.add(parts[1]);
        }
        System.out.println(parsedInput);
        return parsedInput;
    }

    public List<String> validateInputInMenu(List<String> menuInfo,
                                            List<String> parsedInputMenu) throws IllegalArgumentException {
        for (int inputIndex = 0; inputIndex < parsedInputMenu.size(); inputIndex += 2) {
            if (menuInfo.contains(parsedInputMenu.get(inputIndex))) {
                continue;
            }
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
        return parsedInputMenu;
    }

}
