package main.java.wanted.baekjoon;

import java.util.Scanner;

public class P15649 {
    /**
     * 문제 : 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
     *      1 부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
     *
     * 입력 : 첫째 줄에 자연수 N과 M이 주어진다. ( 1 <= M <= N <= 8 )
     *
     * 출력 : 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다.
     *       중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
     *       수열은 사전 순으로 증가하는 순서로 출력해야 한다.
     *
     * 예시 : 입력 - 3 1        출력 - 1
     *                             2
     *                             3
     *
     *      입력 - 4 2         출력 - 1 2
     *                             1 3
     *                             1 4
     *                             2 1
     *                             2 3
     *                             2 4
     *                             3 1
     *                             3 2
     *                             3 4
     *                             4 1
     *                             4 2
     *                             4 3
     */
    static int n;
    static int m;
    static int[] arr;
    static boolean[] check;

    public static void DFS(int depth) {
        if (depth == m) {   // 선택된 개수가 m 개라면 arr 배열을 출력
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!check[i]) {        // 선택되지 않은 수인 경우
                check[i] = true;    // 체크 표시
                arr[depth] = i;     // 선택되었으므로 arr 배열에 저장
                DFS(depth + 1); // 다음 depth 번호를 뽑기 위해 재귀 호출
                check[i] = false;   // 체크 해제
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        arr = new int[m];   // 선택된 수를 담을 배열
        check = new boolean[n + 1]; // 선택된 수인지 판별하기 위한 배열

        DFS(0);
    }
}
