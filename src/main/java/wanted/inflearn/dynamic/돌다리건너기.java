package main.java.wanted.inflearn.dynamic;

import java.util.Scanner;

public class 돌다리건너기 {
    /**
     * 문제 : 철수는 학교에 가는데 개울을 만났습니다. 개울은 N개의 돌로 다리를 만들어 놓았습니다.
     *       철수는 돌 다리를 건널 때, 한 번에 한 칸 또는 두 칸씩 건너뛰면서 돌다리를 건널 수 있습니다.
     *       철수가 개울을 건너는 방법은 몇가지일까요?
     *
     * 입력 : 첫째 줄은 돌의 개수인 자연수 N(3<=N<=35)이 주어집니다.
     *
     * 출력 : 첫 번째 줄에 개울을 건너는 방법의 수를 출력합니다.
     *
     * 예시 : 입력 - 7      출력 - 34
     */
    static int[] dy;

    public static int solution(int n) {
        dy[1] = 1;  // 첫 번째 돌을 건너는 방법의 수
        dy[2] = 2;  // 두 번째 돌을 건너는 방법의 수

        // n 번째까지 돌을 건너는 방법의 수를 구하기
        // Bottom - Up
        for (int i = 3; i <= n; i++) {
            dy[i] = dy[i - 2] + dy[i - 1];  // 3부터 ~ n까지
        }

        return dy[n];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        dy = new int[n + 2];    
        System.out.print(solution(n+1)); // 돌 다리의 경우 마지막 n번째 돌에서 육지로 한번 더 건너야 함
    }
}
