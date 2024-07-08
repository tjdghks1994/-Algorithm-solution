package main.java.wanted.inflearn.recursivetreegraph;

import java.util.Scanner;

public class 미로탐색 {
    /**
     * 문제 : 7*7 격자판 미로를 탈출하는 경로의 가지수를 출력하는 프로그램을 작성하세요.
     *       출발점은 격자의 (1,1) 좌표이고, 탈출 도착점은 (7,7) 좌표이다.
     *       격자판의 1은 벽이고, 0은 통로이다.
     *       격자판의 움직임은 상하좌우로만 움직인다. 미로가 다음과 같다면
     *       0(출발) 0 0 0 0 0 0
     *       0      1 1 1 1 1 0
     *       0      0 0 1 0 0 0
     *       1      1 0 1 0 1 1
     *       1      1 0 0 0 0 1
     *       1      1 0 1 1 0 0
     *       1      0 0 0 0 0 0(도착)
     *
     *       위의 지도에서 출발점에서 도착점까지 갈 수 있는 방법의 수는 8가지이다.
     *
     * 입력 : 7 * 7 격자판의 정보가 주어집니다.
     *
     * 출력 : 첫 번째 줄에 경로의 가지수를 출력한다.
     *
     * 예시 : 입력 - 0 0 0 0 0 0 0       출력 - 8
     *            0 1 1 1 1 1 0
     *            0 0 0 1 0 0 0
     *            1 1 0 1 0 1 1
     *            1 1 0 0 0 0 1
     *            1 1 0 1 1 0 0
     *            1 0 0 0 0 0 0
     */
    static int[][] arr = new int[7][7]; // 7*7 격자판
    static int[] dx = {-1, 0, 1, 0};    // x좌표 이동 상,우,하,좌 (시계방향)
    static int[] dy = {0, 1, 0, -1};    // y좌표 이동 상,우,하,좌 (시계방향)
    static int cnt = 0; // 총 가지수

    public static void solution(int x, int y) {
        if (x < 0 || x > 6 || y < 0 || y > 6) { // 좌표를 벗어난 경우
            return;
        }
        if (arr[x][y] == 1) {
            return; // 벽인 경우
        }

        if (x == 6 && y == 6) { // 도착한 경우 카운트
            cnt++;
        } else {
            for (int i = 0; i <= 3; i++) {
                arr[x][y] = 1;  //  이미 지나온 곳은 표시
                solution(x + dx[i], y + dy[i]); // 이동
                arr[x][y] = 0;  // 재귀 종료 시 표시 해제
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        solution(0, 0);
        System.out.println(cnt);
    }
}
