package main.java.wanted.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P15665 {
    /**
     * [문제]
     * N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
     * - N개의 자연수 중에서 M개를 고른 수열
     * - 같은 수를 여러 번 골라도 된다.
     *
     * [입력]
     * 첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 7)
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
     *       4 4 2                        4
     *
     * 입력 - 4 2                     출력 - 1 1
     *      9 7 9 1                       1 7
     *                                    1 9
     *                                    7 1
     *                                    7 7
     *                                    7 9
     *                                    9 1
     *                                    9 7
     *                                    9 9
     */
    static int n;
    static int m;
    static int[] arr;   // 입력된 수를 담을 배열
    static int[] pick;  // 선택한 수를 담을 배열
    static StringBuilder sb = new StringBuilder();

    public static void recursive(int depth) {
        // 종료 조건 - depth 가 m 과 같다면 pick 배열 출력
        if (m == depth) {
            for (int i : pick) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        } else {
            int prev = 0;

            for (int i = 0; i < arr.length; i++) {
                if (prev != arr[i]) {
                    pick[depth] = arr[i];
                    prev = arr[i];
                    recursive(depth + 1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = reader.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        arr = new int[n];
        pick = new int[m];

        String[] nums = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(nums[i]);
        }

        Arrays.sort(arr);

        recursive(0);
        System.out.println(sb.toString());
    }
}
