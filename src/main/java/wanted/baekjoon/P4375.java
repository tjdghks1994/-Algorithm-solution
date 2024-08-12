package main.java.wanted.baekjoon;

import java.util.Scanner;

public class P4375 {
    /**
     * 문제 : 2와 5로 나누어 떨어지지 않는 정수 n(1<=n<=10,000)가 주어졌을 때,
     *       각 자릿수가 모두 1로만 이루어진 n의 배수를 찾는 프로그램을 작성하시오.
     *
     * 입력 : 입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스는 한 줄로 이루어져 있고, n이 주어진다.
     *
     * 출력 : 각 자릿수가 모두 1로만 이루어진 n의 배수 중 가장 작은 수의 자리수를 출력한다.
     *
     * 예시 : 입력 - 3          출력 - 3
     *            7                6
     *            9901             12
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int n = in.nextInt();
            int start = 0;

            for (int i = 1; ; i++) {
                start = (start * 10 + 1) % n;
                if (start == 0) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
