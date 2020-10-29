package dongho.woowacource.javaconvention.ex1;

import java.util.Random;
import java.util.Scanner;

public class NumberBaseball {
    final int PLAYER_1_WIN = 1;

    public boolean play(Member a, Member b) {

    }

    public int[] numParsing(int value) {
        int list
    }

    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        Member computer = new Member(3);
        Member user = new Member(3);

        computer.setSpace(0, rand.nextInt(10));
        computer.setSpace(1, rand.nextInt(10));
        computer.setSpace(2, rand.nextInt(10));

        for (int i = 0; i < 3; i++) {
            user.setSpace(i, sc.nextInt());
        }

        play(computer, user);
    }
}

class Member {
    private int num;
    private int [] space;

    public Member(int num) {
        this.num = num;
        space = new int[num];
    }

    void setSpace(int index, int value) {
        space[index] = value;
    }
}
