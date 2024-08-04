package main.java.wanted.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1697 {
    /**
     * 문제 : 수빈이는 동생과 숨바꼭질을 하고 있다.
     *       수빈이는 현재 점 N(0<=N<=100,000)에 있고, 동생은 점 K(0<=K<=100,000)에 있다.
     *       수빈이는 걷거나 순간이동을 할 수 있다.
     *       만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
     *       순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
     *
     * 입력 : 첫 번째 줄에 수빈이가 이는 위치 N과 동생이 있는 위치 K가 주어진다.
     *       N과 K는 정수이다.
     *
     * 출력 : 수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.
     *
     * 예시 : 입력 - 5 17           출력 - 4
     */
    static int n, k;
    static int[] dx = {-1, 1, 2};
    static boolean[] visited;   // 방문 체크 배열

    static class Position {
        int x;
        int level;

        public Position(int x, int level) {
            this.x = x;
            this.level = level;
        }
    }

    public static void BFS(int n) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(n, 0));
        visited[n] = true;  //   방문했으므로 체크

        while (!queue.isEmpty()) {
            Position current = queue.poll();
            if (current.x == k) {
                System.out.println(current.level);
                return;
            }

            for (int i = 0; i < 3; i++) {
                int nx = i == 2 ? current.x * dx[i] : current.x + dx[i];

                if (nx >= 0 && nx < visited.length && !visited[nx]) {
                    queue.add(new Position(nx, current.level + 1));
                    visited[nx] = true; // 한번 큐에 삽입되었다면 방문 체크
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        k = in.nextInt();
        visited = new boolean[100001];

        BFS(n);
    }
}
