package dongho.woowacource.javaconvention.Demo1;

import java.util.Scanner;

public class Solution {
    public int[] solution(int[][] v) {
        int[] x = new int[2];

        for (int i = 0; i < 2; i++) {
            if (v[0][i] != v[1][i]) {
                if (v[1][i] != v[2][i]) {
                    x[i] = v[1][i];
                } else {
                    x[i] = v[0][i];
                }
            } else {
                x[i] = v[2][i];
            }
        }

        int[] answer = {x[0], x[1]};
        return answer;
    }
}
