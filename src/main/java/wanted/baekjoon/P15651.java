package main.java.wanted.baekjoon;

import java.util.Scanner;

public class P15651 {
    /**
     * 문제 : 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
     *       - 1부터 N까지 자연수 중에서 M개를 고른 수열
     *       - 같은 수를 여러 번 골라도 된다.
     *
     * 입력 : 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 7)
     *
     * 출력 : 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다.
     *       중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
     *       수열은 사전 순으로 증가하는 순서로 출력해야 한다.
     *
     * 예시 : 입력 - 3 1        출력 - 1
     *                             2
     *                             3
     *
     *      입력 - 4 2         출력 - 1 1
     *                             1 2
     *                             1 3
     *                             1 4
     *                             2 1
     *                             2 2
     *                             2 3
     *                             2 4
     *                             3 1
     *                             3 2
     *                             3 3
     *                             3 4
     *                             4 1
     *                             4 2
     *                             4 3
     *                             4 4
     */
    static int n;
    static int m;
    static int[] arr;   // 뽑은 수를 담을 배열
    static StringBuilder sb = new StringBuilder();

    public static void backtracking(int depth) {
        // 종료 조건 - m개를 전부 뽑은 경우
        // sout() 을 통해 바로 출력하면 시간 초과 발생
        if (depth == m) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            arr[depth] = i;
            backtracking(depth + 1);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        arr = new int[m];

        backtracking(0);
        System.out.println(sb);
    }
}
