package main.java.wanted.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P15657 {
    /**
     * [문제]
     * N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
     * - N개의 자연수는 모두 다른 수이다.
     * - N개의 자연수 중에서 M개를 고른 수열
     * - 같은 수를 여러 번 골라도 된다.
     * - 고른 수열은 비내림차순이어야 한다.
     * - 길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
     *
     * [입력]
     * 첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
     * 둘째 줄에 N개의 수가 주어진다.
     * 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.
     *
     * [출력]
     * 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다.
     * 복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
     * 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
     *
     * [예시]
     * 입력 - 3 1                     출력 - 2
     *      4 5 2                         4
     *                                    5
     *
     * 입력 - 4 2                     출력 - 1 1
     *      9 8 7 1                       1 7
     *                                    1 8
     *                                    1 9
     *                                    7 7
     *                                    7 8
     *                                    7 9
     *                                    8 8
     *                                    8 9
     *                                    9 9
     */
    static int n;
    static int m;
    static int[] arr;   // 입력된 수를 담고 있는 배열
    static int[] pick;  // 선택된 수를 담고 있는 배열

    public static void recursive(int depth) {
        // 종료 조건 - depth 가 m과 같다면 pick 배열 출력
        if (m == depth) {
            for (int i : pick) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < arr.length; i++) {
                // depth 가 0보다 크면 직전의 수를, 아니라면 arr i번째 인덱스의 수를 가져온다
                int prev = depth > 0 ? pick[depth - 1] : arr[i];
                // 선택될 수는 바로 직전에 선택된 수보다 값이 크거나 같아야 한다
                if (arr[i] >= prev) {
                    pick[depth] = arr[i];   // 선택한 수를 pick 배열에 저장
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
    }
}
