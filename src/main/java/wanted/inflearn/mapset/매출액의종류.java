package main.java.wanted.inflearn.mapset;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 매출액의종류 {
    /**
     * 문제 : 현수의 아빠는 제과점을 운영합니다. 현수아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 매출액의 종류를
     *       각 구간별로 구하라고 했습니다.
     *       만약 N=7이고 7일 간의 매출기록이 아래와 같고, 이때 K=4이면
     *       20 12 20 10 23 17 10
     *       각 연속 4일간 구간의 매출종류는
     *       첫 번째 구간은 [20, 12, 20, 10] 매출액의 종류가 20, 12, 10 으로 3이다
     *       두 번째 구간은 [12, 20, 10, 23] 매출액의 종류가 4이다
     *       세 번째 구간은 [20, 10, 23, 17] 매출액의 종류가 4이다.
     *       네 번째 구간은 [10, 23, 17, 10] 매출액의 종류가 3이다.
     *       N 일간의 매출기록과 연속구간의 길이 K가 주어지면 첫 번째 구간부터 각 구간별 매출액의 종류를 출력하는 프로그램을 작성하세요.
     *
     * 입력 : 첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
     *       두 번째 줄에 N 개의 숫자열이 주어집니다. 각 숫자는 500 이하의 음이 아닌 정수입니다.
     *
     * 출력 : 첫 줄에 각 구간의 매출액 종류를 순서대로 출력합니다.
     *
     * 예시 : 입력 -  7 4                       출력 - 3 4 4 3
     *             20 12 20 10 23 17 10
     */

    public static void solution(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // 첫 번째 구간
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        // map 의 key 길이를 출력
        System.out.print(map.keySet().size() + " ");

        // 두 번째 구간 ~ N 번째 구간
        int lp=0;
        for (int rp = k; rp < arr.length; rp++) {
            // key의 value 값이 0이라면 삭제
            if (map.get(arr[lp]) - 1 == 0) {
                map.remove(arr[lp]);
            } else {
                map.put(arr[lp], map.get(arr[lp]) - 1);
            }
            lp++;
            map.put(arr[rp], map.getOrDefault(arr[rp], 0) + 1);
            // map 의 key 길이를 출력
            System.out.print(map.keySet().size() + " ");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        solution(arr, k);
    }
}
