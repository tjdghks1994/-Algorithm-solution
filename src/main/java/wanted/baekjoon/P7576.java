package main.java.wanted.baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P7576 {
    /**
     * 문제 : 철수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다.
     *      토마토는 아래의 그림과 같이 격자 모양 상자의 칸에 하나씩 넣어서 창고에 보관한다.
     *      창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다.
     *      보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.
     *      하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미한다.
     *      대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다.
     *      철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.
     *      토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때, 며칠이 지나면
     *      토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라.
     *      단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.
     *
     * 입력 : 예제 - 6 4                출력 - 8
     *            0 0 0 0 0 0
     *            0 0 0 0 0 0
     *            0 0 0 0 0 0
     *            0 0 0 0 0 1
     *
     *      예제 - 6 4                출력 - -1
     *           0 -1 0 0 0 0
     *          -1 0 0 0 0 0
     *           0 0 0 0 0 0
     *           0 0 0 0 0 1
     */
    static int m, n;    // m - x좌표, n - y좌표
    static int[][] farm;    // 농장
    static int[] dx = {0, 1, 0, -1};    // 상, 우, 하, 좌
    static int[] dy = {-1, 0, 1, 0};    // 상, 우, 하, 좌
    static Queue<Tomato> queue;     // 익은 토마토를 담을 큐 선언

    static class Tomato {
        int x;
        int y;
        int level;

        public Tomato(int x, int y, int level) {
            this.x = x;
            this.y = y;
            this.level = level;
        }
    }

    public static void BFS() {
        int answer = 0; // 최단 기간

        while (!queue.isEmpty()) {
            Tomato current = queue.poll();
            answer = current.level;

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i]; // 인접한 토마토의 x좌표
                int ny = current.y + dy[i]; // 인접한 토마토의 y좌표
                // 익을 수 있는 토마토인 경우
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && farm[ny][nx] == 0) {
                    Tomato tomato = new Tomato(nx, ny, current.level + 1);  // 토마토 생성
                    queue.add(tomato);  // 탐색을 위해 큐에 삽입
                    farm[ny][nx] = 1;   // 토마토 익음
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (farm[i][j] == 0) {
                    System.out.println("-1");
                    return;
                }
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        m = in.nextInt();
        n = in.nextInt();
        farm = new int[n][m];
        queue = new LinkedList<>();
        boolean start = false;  //  BFS 탐색을 진행해야하는지 체크

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                farm[i][j] = in.nextInt();
                if (farm[i][j] == 1) {  // 입력받은 값이 익은 토마토라면 큐에 삽입
                    queue.offer(new Tomato(j, i, 0));
                }
                if (farm[i][j] == 0) {  // 익지 않은 토마토가 존재하면 BFS 탐색 필요
                    start = true;
                }
            }
        }

        if (start) {
            BFS();
        } else {    // 익지 않은 토마토가 없으므로 탐색 x -> 0출력
            System.out.println(0);
        }
    }
}
