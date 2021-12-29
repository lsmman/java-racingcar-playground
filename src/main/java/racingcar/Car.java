package racingcar;

import java.util.Random;

public class Car {
    /*
    - Car Class
      - Car 전진
        - [static] 0~9 Random 값 구해서 4이상이면 움직일 수 있으므로 True
        - Car 가 간 거리 늘려준다
     */
    private static final Random RANDOM = new Random();
    private static final int BOUND = 10;
    private static final int STANDARD = 4;

    private int forward;
    private final String name;

    public Car(String carName) {
        name = carName;
        forward = 0;
    }

    public void goForward(){
        if (RANDOM.nextInt(BOUND) >= STANDARD){
            forward++;
        }
    }

    public int getForward() {
        return forward;
    }

    public String getName() {
        return name;
    }

    public String toString(String delimiter){
        return name + delimiter + forward;
    }
}
