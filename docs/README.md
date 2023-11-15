# 미션 - 크리스마스 프로모션 🌲

## 컨셉

    서버와 클라이언트가 통신하는 구조. ( Request, Response )

### 📱 APP

- App 은 기본적으로 입력값을 제한 할 수 있다. ex) 숫자형 입력, 날자형 입력
- App은 실행 시 서버에 있는 음식 리스트를 받아온다. ex) 키오스크

| App            | 역할                                         |
|----------------|--------------------------------------------|
| AppConsole     | InputVew, OutputView, InputValidator 총괄    |
| InputView      | 사용자에게 입력 요청을 하고, 받은 값을 리턴                  |
| InputValidator | InputView에서 사용자에게 받은 정보를 AppConsole을 통해 확인 |
| OutputView     | 서버에서 받은 DTO를 형식에 맞게 출력                     |

## Enum

    혜택에 대한 정보를 가지고있음.

| Enum       | 역할                   |
|------------|----------------------|
| ⭐️Star     | 해당 요일에 별이 붙어있는지 확인   |
| 📅Week     | 해당 요일이 주말인지, 주중인지 확인 |
| 🧾Discount | 혜택 타입                |
| 🧑‍🎄Badge | 뱃지 타입                |

## Contoller

    각 서비스와 연결해주는역할

## Service

| Service        | 역할                                    |
|----------------|---------------------------------------|
| BenefitService | 입력날짜와 주문내역에 따라 혜택을 확인해주는 서비스          |
| DayService     | Day관한 로직을 처리함 ex) 입력 날짜에 무슨혜택이 있는지 확인 |

## Repository

    서버에 저장되어있는 날짜정보 및 음식정보를 갖고있음

| Repository     | 역할                             |
|----------------|--------------------------------|
| DayRepository  | day 에 대한 정보를 갖고있음 (star, week) |
| FoodRepository | 판매되는 음식정보를 갖고있음                |



