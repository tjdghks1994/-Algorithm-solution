package main.java.wanted.inflearn.recursivetreegraph;

import java.util.Scanner;

public class 동전교환 {
    /**
     * 문제 : 다음과 같이 여러 단위의 동전들이 주어져 있을 때, 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?
     *       각 단위의 동전은 무한정 쓸 수 있다.
     *
     * 입력 : 첫 번째 줄에는 동전의 종류개수 N(1<=N<=12)이 주어진다. 두 번째 줄에는 N개의 동전의 종류가 주어지고,
     *       그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다. 각 동전의 종류는 100원을 넘지 않는다.
     *
     * 출력 : 첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다.
     *
     * 예시 : 입력 - 3          출력 - 3 ( 5원짜리로 3개 )
     *            1 2 5
     *            15
     */
    static int n,m;
    static int[] arr;
    static int cnt = Integer.MAX_VALUE; // 거스름돈 개수

    public static void solution(int node, int currentCnt, int sum) {
        if (sum > m) {  // 동전의 합계가 m을 초과하면 종료
            return;
        }

        if(currentCnt >= cnt) { // 거슬러줄 동전의 개수가 저장된 cnt 개수보다 크거나 같다면 최소가 아니므로 종료
            return;
        }

        if (sum == m) {
            cnt = Math.min(cnt, currentCnt);  // 동전의 최소개수로 저장
        } else {
            // 재귀 - DFS
            for (int i = n-1; i >= 0; i--) {
                solution(arr[i], currentCnt+1, sum + arr[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        m = in.nextInt();
        // 제일 큰 동전의 값부터 진행
        solution(arr[n-1], 0, 0);

        System.out.println(cnt);
    }
}
