package main.java.wanted.baekjoon;

import java.util.Scanner;

public class P15652 {
    /**
     * [문제]
     * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
     * - 1부터 N까지 자연수 중에서 M개를 고른 수열
     * - 같은 수를 여러 번 골라도 된다.
     * - 고른 수열은 비내림차순이어야 한다.
     * - 길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
     *
     * [입력]
     * 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
     *
     * [출력]
     * 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다.
     * 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
     * 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
     *
     * [예시]
     * 입력 - 3 1     출력 - 1
     *                    2
     *                    3
     *
     * 입력 - 4 2     출력 - 1 1
     *                    1 2
     *                    1 3
     *                    1 4
     *                    2 2
     *                    2 3
     *                    2 4
     *                    3 3
     *                    3 4
     *                    4 4
     */

    static int n;
    static int m;
    static int[] arr;   // m개를 고른 수열이 저장될 배열

    public static void recursive(int depth) {
        // 종료 조건 - depth 가 m 과 같으면 m개를 고른 수열이 완성됨 - 출력
        if (depth == m) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                int prev = depth > 0 ? arr[depth - 1] : i;  // 이전 숫자
                // i가 이전 숫자보다 크거나 같은 경우만
                if (i >= prev) {
                    arr[depth] = i; // 배열에 저장
                    recursive(depth + 1);   //  재귀 호출
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        arr = new int[m];

        recursive(0);
    }
}
