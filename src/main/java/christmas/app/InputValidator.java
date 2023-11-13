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

    public List<List<String>> validateMenuMatchWithForm(String menuInput) throws IllegalArgumentException {
        menuInput = menuInput.replaceAll(" ", "");
        List<String> parsedWithBar = List.of(menuInput.split(","));
        List<String> parsedMenu = new ArrayList<>();
        List<String> parsedQuantity = new ArrayList<>();
        for (String data : parsedWithBar) {
            String[] parts = data.split("-");
            if (parts.length != 2) {
                throw new IllegalArgumentException("[Error] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
            parsedMenu.add(parts[0]);
            parsedQuantity.add(parts[1]);
        }
        return List.of(parsedMenu, parsedQuantity);
    }

    public List<String> validateInputInMenu(List<String> menuInfo,
                                            List<List<String>> parsedInput) throws IllegalArgumentException {
        List<String> parsedMenu = parsedInput.get(0);
        for (int inputIndex = 0; inputIndex < parsedMenu.size(); inputIndex++) {
            if (menuInfo.contains(parsedMenu.get(inputIndex))) {
                continue;
            }
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
        return parsedMenu;
    }

    public List<Integer> validateQuantityIsInteger(List<List<String>> parsedInput) throws IllegalArgumentException {
        List<String> parsedQuantity = parsedInput.get(1);
        List<Integer> menuQuantity = new ArrayList<>();
        for (int inputIndex = 0; inputIndex < parsedQuantity.size(); inputIndex++) {
            try {
                menuQuantity.add(Integer.parseInt(parsedQuantity.get(inputIndex)));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
        return menuQuantity;
    }
}
