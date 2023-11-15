package christmas.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InputValidator {

    public int validateSingleNumber(String inputValue) throws IllegalArgumentException {
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public int validateDayInRange(int day) throws IllegalArgumentException {
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
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
                                            List<String> parsedMenu) throws IllegalArgumentException {
        for (String menu : parsedMenu) {
            if (menuInfo.contains(menu)) {
                continue;
            }
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
        return parsedMenu;
    }

    public List<Integer> validateQuantityMatchWithForm(List<String> parsedQuantity) throws IllegalArgumentException {
        List<Integer> menuQuantity = new ArrayList<>();
        for (String s : parsedQuantity) {
            int quantity;
            try {
                quantity = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
            if (quantity < 0) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
            menuQuantity.add(quantity);
        }
        return menuQuantity;
    }

    public HashMap<String, Integer> validateUniqueMenu(List<String> menu, List<Integer> quantity) {
        HashMap<String, Integer> menuInfo = new HashMap<>();
        for (int index = 0; index < menu.size(); index++) {
            if (menuInfo.containsKey(menu.get(index))) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
            menuInfo.put(menu.get(index), quantity.get(index));
        }
        return menuInfo;
    }

    public void validateTotalQuantity(List<Integer> menuQuantity) throws IllegalArgumentException {
        int total = 0;
        for (int quantity : menuQuantity) {
            total += quantity;
            if (total > 20) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }
}
