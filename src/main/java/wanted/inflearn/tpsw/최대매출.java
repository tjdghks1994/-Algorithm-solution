package main.java.wanted.inflearn.tpsw;

import java.util.*;

public class 최대매출 {
    /**
     * 문제 : 현수의 아빠는 제과점을 운영합니다. 현수 아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.
     *       만약 N=10이고, 10일 간의 매출기록이 아래와 같습니다. 이때 K=3이면
     *       12 15 11 20 25 10 20 19 13 15
     *       연속된 3일간의 최대 매출액은  11+20+25 = 56만원 입니다.
     *       여러분이 현수를 도와주세요.
     * <p>
     * 입력 : 첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
     *       두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.
     * <p>
     * 출력 : 첫 줄에 최대 매출액을 출력합니다.
     * <p>
     * 예시 : 입력 - 10 3                               출력 - 56
     *             12 15 11 20 25 10 20 19 13 15
     */

    public static void solution(int[] arr, int k) {
        int max = 0;
        int temp = 0;   // 임시 연속 k일 간의 매출
        // 첫 번째 연속 k일 간의 매출
        for (int i = 0; i < k; i++) {
            max += arr[i];
        }

        temp = max;
        // 이후 연속 k일 간의 매출 구하면서, 최대 매출 찾기
        for (int i = k; i < arr.length; i++) {
            // 이전 연속 k일 간의 매출에서 첫 매출 제외 후 현재 일자 매출을 더하기
            temp = temp - arr[i - k] + arr[i];
            max = Math.max(temp, max);  // 최대 매출 비교 후 저장
        }

        System.out.println(max);

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] sArr = s.split(" ");
        int days = Integer.valueOf(sArr[0]);
        int k = Integer.valueOf(sArr[1]);

        int[] arr = new int[days];
        for (int i = 0; i < days; i++) {
            arr[i] = in.nextInt();
        }

        solution(arr, k);
    }
}
