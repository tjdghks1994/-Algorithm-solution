package main.java.wanted.inflearn.recursivetreegraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 섬나라아일랜드 {
    /**
     * 문제 : N*N의 섬나라 아일랜드의 지도가 격자판의 정보로 주어집니다.
     *       각 섬은 1로 표시되어 상하좌우와 대각선으로 연결되어 있으며, 0은 바다입니다.
     *       섬나라 아일랜드에 몇 개의 섬이 있는지 구하는 프로그램을 작성하세요.
     *       1 1 0 0 0 1 0
     *       0 1 1 0 1 1 0
     *       0 1 0 0 0 0 0
     *       0 0 0 1 0 1 1
     *       1 1 0 1 1 0 0
     *       1 0 0 0 1 0 0
     *       1 0 1 0 1 0 0
     *       만약 위와 같다면 섬의 개수는 5개입니다.
     *
     * 입력 : 첫 번째 줄에 자연수 N(3<=N<20)이 주어집니다.
     *       두 번째 줄부터 격자판 정보가 주어진다.
     *
     * 출력 : 첫 번째 줄에 섬의 개수를 출력한다.
     *
     * 예시 : 입력 - 7                  출력 - 5
     *            1 1 0 0 0 1 0
     *            0 1 1 0 1 1 0
     *            0 1 0 0 0 0 0
     *            0 0 0 1 0 1 1
     *            1 1 0 1 1 0 0
     *            1 0 0 0 1 0 0
     *            1 0 1 0 1 0 0
     */
    static int n;
    static int answer = 0;  // 섬의 개수
    static int[][] move = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
    static int[][] arr;
    static Queue<Node> queue = new LinkedList<>();
    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void solution(int x, int y) {
        queue.offer(new Node(x, y));

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            arr[currentNode.x][currentNode.y] = 0;  // 확인한 섬은 0으로 체크

            for (int i = 0; i < move.length; i++) {
                int nx = currentNode.x + move[i][0];
                int ny = currentNode.y + move[i][1];
                // 이동이 가능한 위치(이어진 섬)인 경우 큐에 삽입
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] == 1) {
                    queue.offer(new Node(nx, ny));
                }
            }
        }
        // 큐가 비었다면 이어진 섬이 없으므로 섬의 개수 카운팅
        answer++;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = in.nextInt();
                arr[i][j] = num;
            }
        }
        // 혼자서 풀다가 강사님의 힌트 받고 재풀이
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    solution(i, j);
                }
            }
        }

        System.out.println(answer);
    }
}
