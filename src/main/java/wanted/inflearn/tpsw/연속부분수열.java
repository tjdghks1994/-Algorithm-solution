package main.java.wanted.inflearn.tpsw;

import java.util.Scanner;

public class 연속부분수열 {
    /**
     * 문제 : N개의 수로 이루어진 수열이 주어집니다.
     *       이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요.
     *       만약 N=8, M=6이고 수열이 다음과 같다면
     *       1 2 1 3 1 1 1 2
     *       합이 6이 되는 연속부분수열은 {2,1,3}, {1,3,1,1}, {3,1,1,1}로 총 3가지 입니다.
     * <p>
     * 입력 : 첫째 줄에 N(1<=N<=100,000), M(1<=M<=100,000,000)이 주어진다.
     *       수열의 원소값은 1,000을 넘지 않는 자연수이다.
     * <p>
     * 출력 : 첫째 줄에 경우의 수를 출력한다.
     * <p>
     * 예시 : 입력 - 8 6                    출력 - 3
     *            1 2 1 3 1 1 1 2
     */
    public static void solution(int[] arr, int m) {
        int cnt = 0;    // 경우의 수
        int sum = 0;    // 연속적인 수들의 합
        int lp = 0;
        // 오른쪽 포인터
        for (int rp = 0; rp < arr.length; rp++) {
            sum += arr[rp];
            if (sum == m) {
                cnt++;
            }
            // sum 값이 m보다 클경우
            while (sum >= m) {
                sum -= arr[lp]; // 연속적인 합 중 맨 앞 원소 값 빼기
                lp++;   // 왼쪽 포인터 값 증가
                // 빼고 난 후 sum 값이 m과 같은지 확인
                if (sum == m) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }

        solution(arr, m);
    }
}
