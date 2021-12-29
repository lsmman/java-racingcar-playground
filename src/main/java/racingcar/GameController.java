package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GameController {
    /*
    - Game 로직
      - 입력된 자동차 이름(String)으로 Car List 만들기
      - 게임 진행
        - 게임 횟수만큼 모든 차 Car 전진하기
        - 게임 결과 출력하기
      - Car 중 간 거리가 가장 긴 우승자들 뽑기
      - 우승자 출력 후 게임 종료
     */
     static final String CAR_DELIMITER = ",";
     static final String COUNT_DELIMITER = ":";

    List<Car> carList;
    View view;


    public GameController() {
        this.carList = new ArrayList<>();
        this.view = new View();
    }

    public static void main(String[] args) {
        GameController controller = new GameController();
        controller.startGame();
    }

     void makeCarList(String[] carNames) {
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
    }

     void playGame() {
        for (Car car : carList) {
            car.goForward();
        }
    }

     String makeResultString() {
        List<String> resultStrings = new ArrayList<>();

        for (Car car : carList) {
            resultStrings.add(car.toString(COUNT_DELIMITER));
        }
        return String.join(CAR_DELIMITER, resultStrings);
    }

    public void startGame() {
        String[] carNames = view.inputCarNames();
        makeCarList(carNames);

        int trialCount = view.inputTrialCount();
        view.startGameView();
        for (int i = 0; i < trialCount; i++) {
            playGame();
            view.resultView(
                    makeResultString(),
                    CAR_DELIMITER,
                    COUNT_DELIMITER
            );
        }
        view.winnerView(findWinners());
    }

     List<String> findWinners() {
        int maxForward = carList.stream()
                .max(Comparator.comparingInt(Car::getForward)).orElseThrow().getForward();
        List<String> winner = new ArrayList<>();
        for (Car car : carList) {
            if(car.getForward() == maxForward){
                winner.add(car.getName());
            }
        }
        return winner;
    }
}
