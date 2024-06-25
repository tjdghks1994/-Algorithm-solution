package main.java.wanted.inflearn.recursivetreegraph;

import java.util.Scanner;

public class 팩토리얼 {
    /**
     * 문제 : 자연수 N이 입력되면 N!를 구하는 프로그램을 작성하세요.
     * 예를 들어 5! = 5*4*3*2*1 = 120 입니다.
     * <p>
     * 입력 : 첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
     * <p>
     * 출력 : 첫 번째 줄에 N팩토리얼 값을 출력합니다.
     * <p>
     * 예시 : 입력 -5      출력 - 120
     */
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    public static void solution(int n) {
        System.out.println(factorial(n));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        solution(n);
    }
}
