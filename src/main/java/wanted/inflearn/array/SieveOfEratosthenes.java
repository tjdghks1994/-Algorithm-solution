package main.java.wanted.inflearn.array;

import java.util.Scanner;

public class SieveOfEratosthenes {
    /**
     * [소수(에라토스테네스의 체)]
     * 문제 : 자연수 N이 입력되면 1부터 N 까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
     * 만약 20이 입력되면 1부터 20 까지의 소수는 2,3,5,7,11,13,17,19로 총 8개입니다.
     * <p>
     * 입력 : 첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.
     * <p>
     * 출력 : 첫 줄에 소수의 개수를 출력합니다.
     * <p>
     * 예시 : 입력 - 20     출력 - 8
     */

    public static void solution(int num) {
        boolean[] check = new boolean[num + 1];
        for (int i = 2; i < check.length; i++) {
            check[i] = true;
        }
        int cnt = 0;
        // 2부터 num 까지 소수 판단 - 배열의 index 인 0과 1은 소수가 아니므로 제외
        for (int i = 2; i < check.length; i++) {
            // 배열의 값이 true 이면 소수
            if (check[i]) {
                cnt++;
                // 현재 배열 index 가 소수인 경우 소수의 배수는 소수가 아니므로 false 로 값 변경
                for (int j = 2; j * i < check.length; j++) {
                    check[i * j] = false;
                }
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
