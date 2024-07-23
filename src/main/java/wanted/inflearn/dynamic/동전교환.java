package main.java.wanted.inflearn.dynamic;

import java.util.*;

public class 동전교환 {
    /**
     * 문제 : 다음과 같이 여러 단위의 동전들이 주어져 있을 때, 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?
     *       각 단위의 동전은 무한정 쓸 수 있다.
     *
     * 입력 : 첫 번째 줄에는 동전의 종류개수 N(1<=N<=50)이 주어진다.
     *       두 번째 줄에는 N개의 동전 종류가 주어지고, 그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.
     *       각 동전의 종류는 100원을 넘지 않는다.
     *
     * 출력 : 첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다.
     *
     * 예시 : 입력 - 3          출력 - 3
     *            1 2 5
     *            15
     */
    static int[] dy;    // index 금액을 만드는데 드는 최소 동전 개수를 담고 있는 배열

    public static void solution(int[] coin, int m) {
         dy[0] = 0; // 0원의 금액을 만드는데에는 동전이 필요하지 않으므로 0으로 초기화

        for (int i = 0; i < coin.length; i++) {
            for (int j = coin[i]; j <= m; j++) {
                // 기존 최소 동전 개수와 현재 금액으로 만든 최소 동전 개수를 비교해서 최소 값을 저장
                dy[j] = Math.min(dy[j - coin[i]] + 1, dy[j]);
            }
        }

        System.out.println(dy[m]);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = in.nextInt();
        }
        int m = in.nextInt();
        dy = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            dy[i] = Integer.MAX_VALUE;  // 초기화
        }

        solution(coin, m);
    }
}
