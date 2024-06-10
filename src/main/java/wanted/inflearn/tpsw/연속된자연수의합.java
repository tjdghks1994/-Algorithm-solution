package main.java.wanted.inflearn.tpsw;

import java.util.Scanner;

public class 연속된자연수의합 {
    /**
     * 문제 : 입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
     *       만약 N=15이면
     *       7+8 = 15
     *       4+5+6 = 15
     *       1+2+3+4+5 = 15
     *       와 같이 총 3가지의 경우가 존재한다.
     *
     * 입력 : 첫 번째 줄에 양의 정수 N(7<=N<=1000) 이 주어집니다.
     *
     * 출력 : 첫 줄에 총 경우의 수를 출력합니다.
     *
     * 예시 : 입력 - 15     출력 - 3
     */

    public static void solution(int num) {
//        int cnt = 0;
//        int sum = 0;
//        int lp = 1;
//
//        for (int rp = 1; rp < num; rp++) {
//            sum += rp;
//
//            if (sum == num) {
//                cnt++;
//                sum -= lp;
//                lp++;
//            }
//
//            while (sum > num) {
//                sum -= lp;
//                lp++;
//
//                if (sum == num) {
//                    cnt++;
//                }
//            }
//        }
        int cnt = 0;
        int n = 1;
        num--;

        while (num > 0) {
            n++;
            num = num - n;

            if (num % n == 0) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        solution(num);
    }
}
