package main.java.wanted.inflearn.recursivetreegraph;

import java.util.Scanner;

public class 이진수출력 {
    /**
     * 문제 : 10진수 N이 입력되면 2진수로 변환하여 출력하는 프로그램을 작성하세요. 단, 재귀함수를 이용해서 출력해야 합니다.
     *
     * 입력 : 첫 번째 줄에 10진수 N(1<=N<=1,000)이 주어집니다.
     *
     * 출력 : 첫 번째 줄에 이진수를 출력하세요.
     *
     * 예시 : 입력 - 11     출력 - 1011
     */
    public static void solution(int n) {
        if (n == 0) {
            return;
        } else {
            int i = n / 2;  // 몫
            int remain = n % 2; // 나머지

            solution(i);
            System.out.print(remain);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        solution(n);
    }
}
