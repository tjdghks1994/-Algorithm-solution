package main.java.wanted.inflearn.recursivetreegraph;

import java.util.Arrays;
import java.util.Scanner;

public class 피보나치수열 {
    /**
     * 문제 : 피보나치 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
     * 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.
     * <p>
     * 입력 : 첫 줄에 총 항수 N(3<=N<=45)이 입력된다.
     * <p>
     * 출력 : 첫 줄에 피보나치 수열을 출력한다.
     * <p>
     * 예제 : 입력 - 10     출력 - 1 1 2 3 5 8 13 21 34 55
     */
    static int[] fibo;

    public static int fibonacci(int n) {
        if (fibo[n-1] > 0) {
            return fibo[n-1];
        }

        if (n == 1 || n == 2) {
            fibo[n-1] = 1;
            return 1;
        }

        return fibo[n-1] = fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void solution(int n) {
        fibonacci(n);
        System.out.println(Arrays.toString(fibo));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        fibo = new int[n];

        solution(n);
    }
}
