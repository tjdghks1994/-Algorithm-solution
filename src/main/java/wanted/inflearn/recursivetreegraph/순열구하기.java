package main.java.wanted.inflearn.recursivetreegraph;

import java.util.ArrayList;
import java.util.Scanner;

public class 순열구하기 {
    /**
     * 문제 : 10이하의 N개의 자연수가 주어지면 이 중 M개를 뽑아 일렬로 나열하는 방법을 모두 출력합니다.
     *
     * 입력 : 첫 번째 줄에 자연수 N(3<=N<=10)이 주어집니다.
     *       두 번째 줄에 N개의 자연수가 오름차순으로 주어집니다.
     *
     * 출력 : 첫 번째 줄에 결과를 출력합니다.
     *       출력순서는 사전순으로 오름차순으로 출력합니다.
     *
     * 예시 : 입력 - 3 2        출력 -  3 6
     *            3 6 9             3 9
     *                              6 3
     *                              6 9
     *                              9 3
     *                              9 6
     */
    static int n,m;
    static int[] arr;
    static int [] ck;   // 뽑은 수 체크 배열
    static int [] pm;   // 뽑은 수를 담는 배열

    public static void solution(int level) {
        if (level == m) {   // m번 뽑기 완료시 출력
            for (int i : pm) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (ck[i] == 0) {
                    pm[level] = i;  // 뽑은 수를 담음
                    ck[i] = 1;  // 뽑았으므로 체크
                    solution(level + 1);
                    ck[i] = 0;  // 체크 해제
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        arr = new int[n];
        ck = new int[n];
        pm = new int[m];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        solution(0);
    }
}
