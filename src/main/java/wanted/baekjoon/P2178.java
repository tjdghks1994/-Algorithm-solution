package main.java.wanted.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178 {
    /**
     * 문제 : N x M 크기의 배열로 표현되는 미로가 있다.
     *      미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다.
     *      이러한 미로가 주어졌을 때, (1,1)에서 출발하여 (N,M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오.
     *      한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
     *      칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
     *
     * 입력 : 첫째 줄에 두 정수 N,M(2<=N,M<=100)이 주어진다.
     *       다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.
     *
     * 출력 : 첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.
     *
     * 예시 : 입력 - 4 6            출력 - 15
     *            101111
     *            101010
     *            101011
     *            111011
     */
    static int n;
    static int m;
    static int[][] miro;    // 미로
    static int[] dx = {-1, 0, 1, 0};    // 상,우,하,좌
    static int[] dy = {0, 1, 0, -1};    // 상,우,하,좌

    static class Vertex {
        int x;
        int y;
        int level;

        public Vertex(int x, int y, int level) {
            this.x = x;
            this.y = y;
            this.level = level;
        }
    }

    public static void BFS() {
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(new Vertex(0, 0, 1));    // 처음 정점을 큐에 추가
        miro[0][0] = 0;    // 첫 정점은 이동완료로 값 변경

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            // 방문 정점이 마지막인 (n,m) 위치라면 종료
            if (current.x == n-1 && current.y == m-1) {
                System.out.println(current.level);
                break;
            }

            // 다음으로 이동할 정점
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                // 이동 가능한 좌표
                // 미로 범위를 넘지 않으면서 정점(x,y)의 값이 1이고, 방문하지 않은 정점인 경우
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && miro[nx][ny] == 1) {
                    queue.add(new Vertex(nx, ny, current.level + 1));
                    miro[nx][ny] = 0;   // 방문한 정점으로 변경
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());
        miro = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                miro[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }

        BFS();
    }
}
