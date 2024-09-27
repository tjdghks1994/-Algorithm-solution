package main.java.wanted.baekjoon;

import java.io.*;
import java.util.*;

public class P15655 {
    /**
     * [문제]
     * N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
     * - N개의 자연수는 모두 다른 수이다.
     * - N개의 자연수 중에서 M개를 고른 수열
     * - 고른 수열은 오름차순이어야 한다.
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
     * 입력 - 3 1                     출력 - 2
     *      4 5 2                         4
     *                                    5
     *
     * 입력 - 4 2                     출력 - 1 7
     *      9 8 7 1                       1 8
     *                                    1 9
     *                                    7 8
     *                                    7 9
     *                                    8 9
     *
     * 입력 - 4 4                     출력 - 1231 1232 1233 1234
     *       1231 1232 1233 1234
     */

    static int n;
    static int m;
    static int[] arr;   // 입력된 숫자를 담을 배열
    static int[] pick;  // 선택된 숫자를 담을 배열
    static boolean[] check; // 선택되었는지 체크할 배열

    public static void recursive(int depth) {
        // 종료조건 - depth 가 m과 같으면 pick 배열 출력
        if (depth == m) {
            for (int i : pick) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < arr.length; i++) {
                int prev = depth > 0 ? pick[depth - 1] : 0; // 현재 depth 직전에 뽑힌 수
                // 직전 depth 보다 크고, 아직 선택되지 않은 수
                if (arr[i] > prev &&  !check[i]) {
                    pick[depth] = arr[i];   // 선택된 수를 pick 배열에 담기
                    check[i] = true;        // 선택했으므로 체크
                    recursive(depth + 1);
                    check[i] = false;       // 체크 해제
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        arr = new int[n];
        check = new boolean[n];
        pick = new int[m];

        String[] arrReadLine = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(arrReadLine[i]);
        }

        Arrays.sort(arr);   // 오름차순 정렬
        recursive(0);
    }
}
