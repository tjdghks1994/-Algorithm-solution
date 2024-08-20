package main.java.wanted.baekjoon;

import java.util.Scanner;

public class P1929 {
    /**
     * 문제 : M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
     *
     * 입력 : 첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000)
     *       M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.
     *
     * 출력 : 한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
     *
     * 예시 : 입력 - 3 16       출력 - 3
     *                             5
     *                             7
     *                             11
     *                             13
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        boolean[] check = new boolean[n + 1];
        // 0과 1은 소수가 아님
        check[0] = true;
        check[1] = true;
        // m 이전의 수들은 모두 체크
        for (int i = 2; i < m; i++) {
            check[i] = true;
        }
        // 2부터 n까지 소수 구하기
        for (int i = 2; i <= n; i++) {
            // i의 배수들은 모두 소수가 아니므로 체크
            for (int j = 2; i * j <= n; j++) {
                if(check[i*j]) { continue; }
                check[i * j] = true;
            }
        }

        for (int i = m; i <= n; i++) {
            if (!check[i]) {
                System.out.println(i);
            }
        }
    }
}
