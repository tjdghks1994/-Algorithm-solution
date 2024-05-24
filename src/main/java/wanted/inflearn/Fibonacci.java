package main.java.wanted.inflearn;

import java.util.ArrayList;
import java.util.Scanner;

public class Fibonacci {
    /**
     * [피보나치 수열]
     * 문제 : 피보나치 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
     * 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.
     * <p>
     * 입력 : 첫 줄에 총 항수 N(3<=N<=45)이 입력된다.
     * <p>
     * 출력 : 첫 줄에 피보나치 수열을 출력한다.
     * <p>
     * 예시 : 입력 - 10     출력 - 1 1 2 3 5 8 13 21 34 55
     */

    public static void solution(int num) {
        ArrayList<Integer> fibonacci = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            if (i == 0 || i == 1) {
                fibonacci.add(1);
            } else {
                int currentNum = fibonacci.get(i - 2) + fibonacci.get(i - 1);
                fibonacci.add(currentNum);
            }
        }

        for (int j = 0; j < fibonacci.size(); j++) {
            System.out.print(fibonacci.get(j) + " ");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cnt = in.nextInt();
        solution(cnt);
    }
}
