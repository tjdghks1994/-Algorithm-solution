package main.java.wanted.inflearn.array;

import java.util.Arrays;
import java.util.Scanner;

public class LargeNumber {
    /**
     * [큰 수 출력하기]
     * 문제 : N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
     *      (첫 번째 수는 무조건 출력한다)
     *
     * 입력 : 첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.
     *
     * 출력 : 자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.
     *
     * 예시 : 입력 - 6                  출력 - 7 9 6 12
     *            7 3 9 5 6 12
     */

    public static void solution(int[] numArr) {
        // 첫 번째 수는 무조건 출력
        System.out.print(numArr[0] + " ");
        // 바로 앞의 수와 비교 후 출력
        for (int i = 1; i <= numArr.length-1; i++) {
            if (numArr[i] > numArr[i-1]) {
                System.out.print(numArr[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cnt = in.nextInt();
        int[] numArr = new int[cnt];

        for (int i = 0; i < cnt; i++) {
            numArr[i] = in.nextInt();
        }

        solution(numArr);
    }
}
