package dongho.woowacource.javaconvention.ex2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RacingCar {
    public static ArrayList<Integer> findWinner(Car[] cars, int n) {
        int winnerDistance=0;
        ArrayList<Integer> winners = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            if (winnerDistance < cars[i].getPosition()) {
                winnerDistance = cars[i].getPosition();
                winners.add(i);
            }
        }

        return winners;
    }
    public static void race(Car[] cars) {
        final int GO = 4;
        Random rand = new Random();

        /* 각 자동차들이 전진할지 말지 결정해주기*/
        for (int i = 0; i < cars.length; i++) {
            int distance = rand.nextInt(10);
            if (GO < distance) {
//                System.out.println(i+"번 째 car 는 "+cars[i].getName());
                cars[i].addPosition();
            }
        }

        for (int i = 0; i < cars.length; i++) {
            System.out.print(cars[i].getName()+" : ");
            for (int j = 0; j < cars[i].getPosition(); j++) {
                System.out.print("-");
            }
            System.out.println("");
        }
    }
    public static void main(String[] args) {
        int raceNum;
        ArrayList<Integer> winners;
        String[] carNames;
        Scanner sc = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분)");
        carNames = sc.nextLine().split(",");

        System.out.println("시도할 회수는 몇회인가요?");
        raceNum = sc.nextInt();

        Car[] cars = new Car[raceNum];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }

        System.out.println("실행결과");
        for (int i = 0; i < raceNum; i++) {
            race(cars);
        }

        winners = findWinner(cars, raceNum);
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(cars[winners.get(i)]);
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("가 최종 우승했습니다.");
    }
}