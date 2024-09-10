package main.java.wanted.baekjoon;

import java.util.Scanner;

public class P15650 {
    /**
     * 문제 : 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
     *       1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
     *       고른 수열은 오름차순이어야 한다.
     * 입력 : 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
     *
     * 출력 : 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다.
     *       중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
     *       수열은 사전 순으로 증가하는 순서로 출력해야 한다.
     *
     * 예시 : 입력 - 3 1        출력 - 1
     *                             2
     *                             3
     *       입력 - 4 2       출력 - 1 2
     *                            1 3
     *                            1 4
     *                            2 3
     *                            2 4
     *                            3 4
     */
    static int n;
    static int m;
    static boolean[] check; // 중복 체크 배열
    static int[] arr;       // 선택한 수를 담을 배열

    public static void recursive(int depth) {
        // 종료 조건 - m개 만큼 수를 뽑음
        if (depth == m) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            int prev = depth > 0 ? depth - 1 : 0;
            // 뽑히지 않은 숫자이면서, 이전의 선택된 수보다 값이 클 경우
            if (!check[i] && arr[prev] < i) {
                check[i] = true;    // 선택된 수 체크
                arr[depth] = i;     // 선택된 수를 배열에 저장
                recursive(depth + 1);   // 다음 수를 뽑기 위해 재귀 호출
                check[i] = false;   // 재귀가 종료되면 선택 해제
            }
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        check = new boolean[n + 1];
        arr = new int[m];

        recursive(0);
    }
}
