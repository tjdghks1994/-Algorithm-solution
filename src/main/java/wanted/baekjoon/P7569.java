package main.java.wanted.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P7569 {
    /**
     * 문제 : 철수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다.
     *       토마토는 격자모양 상자의 칸에 하나씩 넣은 다음, 상자들을 수직으로 쌓아 올려서 창고에 보관한다.
     *       창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다.
     *       보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.
     *       하나의 토마토에 인접한 곳은 위, 아래, 왼쪽, 오른쪽, 앞, 뒤 여섯 방향에 있는 토마토를 의미한다.
     *       대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다.
     *       철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지 그 최소 일수를 알고 싶어 한다.
     *       토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때,
     *       며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라.
     *       단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.
     *
     * 입력 : 첫 줄에는 상자의 크기를 나타내는 두 정수 M,N과 쌓아올려지는 상자의 수를 나타내는 H가 주어진다.
     *       M은 상자의 가로 칸의 수, N은 상자의 세로 칸의 수를 나타낸다.
     *       단, 2<=M<=100, 2<=N<=100, 1<=H<=100 이다.
     *       둘째 줄부터는 가장 밑의 상자부터 가장 위의 상자까지에 저장된 토마토들의 정보가 주어진다.
     *       즉, 둘째 줄부터는 N개의 줄에는 하나의 상자에 담긴 토마토의 정보가 주어진다.
     *       각 줄에는 상자 가로줄에 들어있는 토마토들의 상태가 M개의 정수로 주어진다.
     *       정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.
     *       이러한 N개의 줄이 H번 반복하여 주어진다.
     *       토마토가 하나 이상 있는 경우만 입력으로 주어진다.
     *
     * 출력 : 여러분은 토마토가 모두 익을 때까지 최소 며칠이 걸리는지를 계산해서 출력해야 한다.
     *       만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고,
     *       토마토가 모두 익지는 못하는 상황이면 -1을 출력해야한다.
     *
     * 예시 : 입력 - 5 3 1          출력 - -1
     *            0 -1 0 0 0
     *            -1 -1 0 1 1
     *            0 0 0 1 1
     *
     *      입력 - 5 3 2          출력 - 4
     *           0 0 0 0 0
     *           0 0 0 0 0
     *           0 0 0 0 0
     *           0 0 0 0 0
     *           0 0 1 0 0
     *           0 0 0 0 0
     */

    static int m,n, h;      // 열,행,높이
    static int[][][] farm;  //  농장
    static int[] dx = {-1, 0, 1, 0, 0, 0};  // 행의 이동 - 상 우 하 좌 위 아래
    static int[] dy = {0, 1, 0, -1, 0, 0};  // 열의 이동 - 상 우 하 좌 위 아래
    static int[] dz = {0, 0, 0, 0, 1, -1};  // 높이의 이동 - 상 우 하 좌 위 아래
    static Queue<Tomato3D> queue;

    static class Tomato3D {
        int x;
        int y;
        int z;
        int level;

        public Tomato3D(int x, int y, int z, int level) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.level = level;
        }
    }

    public static void BFS() {
        int answer = 0; // 최단 기간

        while (!queue.isEmpty()) {
            Tomato3D current = queue.poll();
            answer = current.level;

            for (int i = 0; i < 6; i++) {
                int nx = current.x + dx[i]; // 인접한 토마토로 행 이동
                int ny = current.y + dy[i]; // 인접한 토마토로 열 이동
                int nz = current.z + dz[i]; // 인접한 토마토로 높이 이동
                // 익을 수 있는 토마토인 경우
                if (nx >= 0 && nx < n && ny >= 0 && ny < m &&
                        nz >= 0 && nz < h && farm[nz][nx][ny] == 0) {
                    Tomato3D tomato = new Tomato3D(nx, ny, nz, current.level + 1);  // 토마토 생성
                    queue.add(tomato);  // 탐색을 위해 큐에 삽입
                    farm[nz][nx][ny] = 1;   // 토마토 익음
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (farm[i][j][k] == 0) {   // 익지 않은 토마토가 존재하면 -1을 출력 후 종료
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(answer); // 모든 토마토가 익는데 걸린 기간 출력
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        m = in.nextInt();   // 열
        n = in.nextInt();   // 행
        h = in.nextInt();   // 높이
        farm = new int[h][n][m];
        queue = new LinkedList<>();
        boolean start = false;  //  BFS 탐색을 진행해야하는지 체크

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    farm[i][j][k] = in.nextInt();
                    if (farm[i][j][k] == 1) {
                        queue.add(new Tomato3D(j, k, i, 0));
                    }
                    if (farm[i][j][k] == 0) {  // 익지 않은 토마토가 존재하면 BFS 탐색 필요
                        start = true;
                    }
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
