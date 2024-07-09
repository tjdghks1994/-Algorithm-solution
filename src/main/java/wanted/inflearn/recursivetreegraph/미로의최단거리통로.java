package main.java.wanted.inflearn.recursivetreegraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로의최단거리통로 {
    /**
     * 문제 : 7*7 격자판 미로를 탈출하는 최단경로의 길이를 출력하는 프로그램을 작성하세요.
     *       경로의 길이는 출발점에서 도착점까지 가는데 이동한 횟수를 의미합니다.
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
     *       위의 지도에서 최단 경로의 길이는 12이다.
     *
     * 입력 : 7 * 7 격자판의 정보가 주어집니다.
     *
     * 출력 : 첫 번째 줄에 최단으로 움직인 칸의 수를 출력한다. 도착할 수 없으면 -1을 출력한다.
     *
     * 예시 : 입력 - 0 0 0 0 0 0 0       출력 - 12
     *            0 1 1 1 1 1 0
     *            0 0 0 1 0 0 0
     *            1 1 0 1 0 1 1
     *            1 1 0 0 0 0 1
     *            1 1 0 1 1 0 0
     *            1 0 0 0 0 0 0
     */
    static int answer = Integer.MAX_VALUE;  // 최단 경로 길이
    static int[] dx = {-1, 0, 1, 0};    // 상,우,하,좌 (시계방향)
    static int[] dy = {0, 1, 0, -1};    // 상,우,하,좌 (시계방향)
    static int[][] arr = new int[7][7]; // 격자판
    static class Node {
        int x;
        int y;
        int level;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
            this.level = 0;
        }
    }

    public static void solution(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            arr[currentNode.x][currentNode.y] = 1;  // 현재 좌표는 방문한 좌표로 체크

            if (currentNode.x == 6 && currentNode.y == 6) {
                answer = currentNode.level;
                return;
            } else {
                // 현재 좌표에서 상,하,좌,우 이동이 가능한 좌표를 큐에 삽입
                for (int i = 0; i < 4; i++) {
                    int nx = currentNode.x + dx[i];
                    int ny = currentNode.y + dy[i];
                    // 좌표를 벗어나지 않고, 이동이 가능한 경로인 경우 (벽이 아닌)
                    if (nx >= 0 && nx <= 6 && ny >= 0 && ny <= 6 && arr[nx][ny] == 0) {
                        Node next = new Node(nx, ny);
                        next.level = currentNode.level + 1;

                        queue.offer(next);
                    }
                }
            }
        }
        answer = -1;    // 큐가 비었는데도 도착점을 방문하지 못한 경우 도착 불가
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        solution(0, 0);
        System.out.println(answer);
    }
}
