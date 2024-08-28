package main.java.wanted.baekjoon;

import java.util.Scanner;

public class P1748 {
    /**
     * 문제 : 1부터 N까지의 수를 이어서 쓰면 다음과 같이 새로운 하나의 수를 얻을 수 있다.
     *       1234567891011121314151617181920212223...
     *       이렇게 만들어진 새로운 수는 몇 자리 수일까? 이 수의 자릿수를 구하는 프로그램을 작성하시오.
     *
     * 입력 : 첫째 줄에 N(1 ≤ N ≤ 100,000,000)이 주어진다.
     *
     * 출력 : 첫째 줄에 새로운 수의 자릿수를 출력한다.
     *
     * 예시 : 입력 - 5      출력 - 5
     *       입력 - 15     출력 - 21
     *       입력 - 120    출력 - 252
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = 1;          // 현재 숫자의 자릿수
        int sum = 0;        // 전체 숫자의 자릿수
        int length = 10;    // 자릿수 체크

        for (int i = 1; i <= n; i++) {
            if (i == length) {
                d++;    // 현재 숫자의 자릿수가 증가
                length *= 10;   // 다음 자릿수 체크를 위해 변경
            }
            sum += d;   // 현재 숫자의 자릿수만큼 값 증가
        }

        System.out.println(sum);
    }
}
