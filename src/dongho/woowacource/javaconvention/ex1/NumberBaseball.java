package dongho.woowacource.javaconvention.ex1;

import java.util.Random;
import java.util.Scanner;

class Member {
    private int num;
    private int [] space;

    public Member(int num) {
        this.num = num;
        space = new int[num];
    }

    int[] getSpaceList() {
        return space;
    }

    void setSpace(int index, int value) {
        space[index] = value;
    }
}

public class NumberBaseball {
    static final int FINISH_GAME = 2;
    static final int RESET_GAME = 1;

    public static int[] numParsing(int value) {
        int [] digits;
        String temp = Integer.toString(value);

        digits = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++) {
            digits[i] = temp.charAt(i) - '0';
        }

        return digits;
    }

    public static int play(Member com, Member usr) {
        int strike=0;
        int ball=0;
        for (int i = 0; i < com.getSpaceList().length; i++) {
            if (com.getSpaceList()[i] == usr.getSpaceList()[i]) {
                strike++;
            } else {
                ball++;
            }
        }
        if (strike > 0) {
            System.out.print(strike + " 스트라이크 ");
        }
        if (ball > 0) {
            System.out.print(ball + " 볼");
        }
        System.out.println("");

        if (strike == 3) {
            return FINISH_GAME;
        } else {
            return RESET_GAME;
        }
    }

    public static void main(String[] args) {
        int [] intList;
        int reset = RESET_GAME;
        int finishCheck;
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        while (reset != FINISH_GAME) {
            finishCheck = RESET_GAME;
            Member computer = new Member(3);
            Member user = new Member(3);

            computer.setSpace(0, rand.nextInt(10));
            computer.setSpace(1, rand.nextInt(10));
            computer.setSpace(2, rand.nextInt(10));

            while (finishCheck != FINISH_GAME){
                System.out.print("숫자를 입력해주세요 : ");
                intList = numParsing(sc.nextInt());

                user.setSpace(0, intList[0]);
                user.setSpace(1, intList[1]);
                user.setSpace(2, intList[2]);
                finishCheck = play(computer, user);
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            reset = sc.nextInt();
        }

    }
}

