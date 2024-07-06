package main.java.wanted.inflearn.recursivetreegraph;

import java.util.Scanner;

public class 중복순열구하기 {
    /**
     * 문제 : 1부터 N까지 번호가 적힌 구슬이 있습니다. 이 중 중복을 허용하여 M번을 뽑아 일렬로 나열하는 방법을 모두 출력합니다.
     *
     * 입력 : 첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N) 이 주어집니다.
     *
     * 출력 : 첫 번째 줄에 결과를 출력합니다.
     *       출력순서는 사전순으로 오름차순으로 출력합니다.
     *
     * 예시 : 입력 - 3 2    출력 - 1 1
     *                         1 2
     *                         1 3
     *                         2 1
     *                         2 2
     *                         2 3
     *                         3 1
     *                         3 2
     *                         3 3
     *
     */
    static int[] pm;
    static int n, m;

    public static void solution(int level) {
        if (level == m) {
            for (int i : pm) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                pm[level] = i;
                solution(level + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        pm = new int[m];
        solution(0);
    }
}
