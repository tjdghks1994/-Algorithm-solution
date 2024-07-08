package main.java.wanted.inflearn.recursivetreegraph;

import java.util.Scanner;

public class 조합구하기 {
    /**
     * 문제 : 1부터 N까지 번호가 적힌 구슬이 있습니다. 이 중 M개를 뽑는 방법의 수를 출력하는 프로그램을 작성하세요.
     *
     * 입력 : 첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N)이 주어집니다.
     *
     * 출력 : 첫 번째 줄에 결과를 출력합니다.
     *       출력순서는 사전순으로 오름차순으로 출력합니다.
     *
     * 예시 : 입력 -  4 2       출력  - 1 2
     *                              1 3
     *                              1 4
     *                              2 3
     *                              2 4
     *                              3 4
     */
    static int n,m;
    static int[] chk;   // 뽑은 구슬인지 체크하기 위한 배열
    static int[] result;    // 뽑은 구슬을 담을 배열

    public static void solution(int level, int start) {
        // m개를 뽑았으므로 출력
        if (level == m) {
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            // 시작된 숫자부터만 반복 (시작된 숫자보다 작은 숫자는 진행 x)
            for (int i = start; i <= n; i++) {
                // 뽑힌 구슬이 아닌 경우에만 진행
                if (chk[i] == 0) {
                    chk[i] = 1; // 구슬을 뽑았으므로 체크
                    result[level] = i;
                    solution(level + 1, i+1);
                    chk[i] = 0; // 재귀 종료 후, 전에 뽑은 구슬은 체크 해제
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        chk = new int[n + 1];
        result = new int[m];

        solution(0, 1);
    }
}
