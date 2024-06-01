package main.java.wanted.inflearn;

import java.util.Scanner;

public class 격자판최대합 {
    /**
     * 문제 : N*N 격자판에 숫자가 적혀있다.
     * N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가장 큰 합을 출력합니다.
     * <p>
     * 입력 : 첫 줄에 자연수 N이 주어진다 (2<=N<=50)
     * 두 번쩨 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
     * <p>
     * 출력 : 최대합을 출력합니다.
     * <p>
     * 예시 : 입력 - 5                  출력 - 155
     *            10 13 10 12 15
     *            12 39 30 23 11
     *            11 25 50 53 15
     *            19 27 29 37 27
     *            19 13 30 13 19
     */
    public static void solution(int[][] tdArr) {
        int sum1, sum2 = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < tdArr.length; i++) {
            sum1 = 0;   // 행의 합
            sum2 = 0;   // 열의 합
            for (int j = 0; j < tdArr.length; j++) {
                sum1 += tdArr[i][j];
                sum2 += tdArr[j][i];

                max = Math.max(max, sum1);  // 현재 최대값과 행의 합 비교 후 최대값 변경
                max = Math.max(max, sum2);  // 현재 최대값과 열의 합 비교 후 최대값 변경
            }
        }

        sum1 = 0;
        sum2 = 0;
        // 대각선의 합
        for (int i = 0; i < tdArr.length; i++) {
            sum1 += tdArr[i][i];   // 왼쪽 대각선 합
            sum2 += tdArr[i][tdArr.length - 1 - i];   // 오른쪽 대각선 합
        }

        max = Math.max(max, sum1);  // 현재 최대값과 왼쪽 대각선의 합 비교 후 최대값 변경
        max = Math.max(max, sum2);  // 현재 최대값과 오른쪽 대각선의 합 비교 후 최대값 변경

        System.out.println(max);    // 최대값 출력
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] tdArr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tdArr[i][j] = in.nextInt();
            }
        }

        solution(tdArr);
    }
}
