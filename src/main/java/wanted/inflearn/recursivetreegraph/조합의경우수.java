package main.java.wanted.inflearn.recursivetreegraph;

import java.util.Scanner;

public class 조합의경우수 {
    /**
     * 문제 : nCr = n-1Cr-1 + n-1Cr
     *      위 공식을 사용하여 재귀를 이용해 조합수를 구해주는 프로그램을 작성하세요.
     *
     * 입력 : 첫째 줄에 자연수 n(3<=n<=33)과 r(0<=r<=n)이 입력됩니다.
     *
     * 출력 : 첫째 줄에 조합수를 출력합니다.
     *
     * 예제 : 입력 - 5 3        출력 - 10
     *       입력 - 33 19      출력 - 818809200
     */
    static int[][] dy = new int[34][34];   // 메모이제이션을 위한 배열

    public static int solution(int n, int r) {
        if (dy[n][r] != 0) {    // 이미 계산한 적이 있는 조합이라면
            return dy[n][r];    // 배열에서 바로 값을 반환
        }
        if (n == r || r == 0) {
            return 1;
        } else {
            return dy[n][r] = solution(n - 1, r - 1) + solution(n - 1, r);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int r = in.nextInt();

        System.out.println(solution(n, r));
    }
}
