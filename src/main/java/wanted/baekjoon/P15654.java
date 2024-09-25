package main.java.wanted.baekjoon;

import java.util.*;

public class P15654 {
    /**
     * [문제]
     * N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
     * - N개의 자연수는 모두 다른 수이다.
     * - N개의 자연수 중에서 M개를 고른 수열
     *
     * [입력]
     * 첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
     * 둘째 줄에 N개의 수가 주어진다.
     * 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.
     *
     * [출력]
     * 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다.
     * 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
     * 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
     *
     * [예시]
     * 입력 - 3 1         출력 - 2
     *      4 5 2             4
     *                        5
     *
     * 입력 - 4 2         출력 - 1 7
     *       9 8 7 1          1 8
     *                        1 9
     *                        7 1
     *                        7 8
     *                        7 9
     *                        8 1
     *                        8 7
     *                        8 9
     *                        9 1
     *                        9 7
     *                        9 8
     */

    static int n;
    static int m;
    static int[] arr;   // N개의 수를 담은 배열
    static int[] pick;  // M개를 뽑은 수를 담은 배열
    static boolean[] check; // 수를 뽑았는지 체크하기 위한 배열

    public static void recursive(int depth) {
        // 종료 조건 - m개의 수를 뽑았다면 pick 배열 출력
        if (depth == m) {
            for (int i : pick) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                // 선택되지 않은 수만 진행
                if (!check[i]) {
                    pick[depth] = arr[i];   // arr 배열에서 선택된 수를 pick 배열에 저장
                    check[i] = true;        // 선택했으므로 체크
                    recursive(depth + 1);
                    check[i] = false;       // 선택 해제
                }

            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        arr = new int[n];
        check = new boolean[n];
        pick = new int[m];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        // 입력된 배열을 오름차순으로 정렬
        Arrays.sort(arr);

        recursive(0);
    }
}
