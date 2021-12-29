package racingcar;

import java.util.List;
import java.util.Scanner;

public class View {
    /*
    - UI 입출력
      - 안내문 출력 & 입력 받기
      - 입력 받은 문자열 리스트 만들기
        - 이름이 5자 초과하면 에러 메세지 출력
      - 시도할 회수 안내문 출력 / 입력 받기
        - 1보다 큰 숫자인지 확인
      - 게임 결과 표시
      - 우승자 표시
     */
    Scanner sc;

    public View() {
        this.sc = new Scanner(System.in);
    }

    public String[] inputCarNames() {
        boolean valid = false;
        String[] carNames = {""};

        while (!valid) {
            valid = true;
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            carNames = sc.nextLine().split(",");


            for (int i = 0; i < carNames.length; i++) {
                carNames[i] = carNames[i].trim();
                valid &= isValid(carNames[i]);
            }
        }
        return carNames;
    }

    private boolean isValid(String carName) {
        int length = carName.length();
        if (length >= 5){
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (!Character.isAlphabetic(carName.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public int inputTrialCount() {
        while (true) {
            System.out.println("시도할 회수는 몇회인가요?");
            String input = sc.nextLine();
            if (!isNumber(input)) {
                continue;
            }
            int trialCount = Integer.parseInt(input);
            if (trialCount <= 0) {
                continue;
            }
            return trialCount;
        }
    }

    private boolean isNumber(String input) {
        boolean isDigit = true;
        for (int i = 0; i < input.length(); i++) {
            isDigit &= Character.isDigit(input.charAt(i));
        }
        return isDigit;
    }

    public void resultView(String result, String carDelimiter, String countDelimiter) {
        String[] cars = result.split(carDelimiter);
        String[] split;
        String carName;
        int forward;
        StringBuilder resultBuilder = new StringBuilder();

        for (String car : cars) {
            split = car.split(countDelimiter);
            carName = split[0];
            forward = Integer.parseInt(split[1]);

            resultBuilder.append(carName);
            resultBuilder.append(" : ");
            resultBuilder.append("-".repeat(forward));
            resultBuilder.append("\n");
        }
        System.out.println(resultBuilder);
    }


    public void winnerView(List<String> winnerNames) {
        System.out.println(String.join(", ", winnerNames) + "가 최종 우승했습니다.");
    }

    public void startGameView() {
        System.out.println("\n실행 결과");
    }
}
