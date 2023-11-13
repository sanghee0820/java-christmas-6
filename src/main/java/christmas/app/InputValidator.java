package christmas.app;

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
}
