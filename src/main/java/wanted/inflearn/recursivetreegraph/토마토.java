package main.java.wanted.inflearn.recursivetreegraph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 토마토 {
    /**
     * 문제 : 현수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다.
     *       토마토는 격자 모양 상자의 칸에 하나씩 넣어서 창고에 보관한다.
     *       창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다.
     *       보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.
     *       하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미한다.
     *       대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다.
     *       현수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.
     *       토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때,
     *       며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라.
     *       단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.
     *
     * 입력 : 첫 줄에는 상자의 크기를 나타내는 두 정수 M,N이 주어진다.
     *       M은 상자의 가로 칸의 수, N은 상자의 세로 칸의 수를 나타낸다.
     *       단, 2<=M,N<=1,000 이다.
     *       둘째 줄부터는 하나의 상자에 저장된 토마토들의 정보가 주어진다.
     *       즉, 둘째 줄부터 N개의 줄에는, 상자에 담긴 토마토의 정보가 주어진다.
     *       하나의 줄에는 상자 가로줄에 들어 있는 토마토의 상태가 M개의 정수로 주어진다.
     *       정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.
     *
     * 출력 : 여러분은 토마토가 모두 익을 때까지의 최소 날짜를 출력해야 한다.
     *       만약, 저장될 때부터 모든 토마토가 익어있는 상태라면 0을 출력해야 하고,
     *       토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.
     *
     * 예시 - 입력 : 6 4                출력 - 4
     *            0 0 -1 0 0 0
     *            0 0 1 0 -1 0
     *            0 0 -1 0 0 0
     *            0 0 0 0 -1 1
     */
    static int answer = 0;  // 최소 날짜
    static int[] dx = {-1, 0, 1, 0};    // x좌표 이동좌표 (상,우,하,좌)
    static int[] dy = {0, 1, 0, -1};    // y좌표 이동좌표 (상,우,하,좌)
    static int m, n;    // 가로, 세로 크기
    static int[][] arr; // 토마토 농장
    static int zero = 0;    // 익지 않은 토마토 개수
    static int one = 0;     // 익은 토마토 개수
    static int minusOne = 0;    // 토마토가 들어 있지 않은 칸

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

    public static void solution(Queue<Node> queue) {
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            if (n * m - minusOne == one) {  // 모든 토마토가 익은 경우
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = currentNode.x + dx[i];
                int ny = currentNode.y + dy[i];
                // 익어야하는 토마토
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == 0) {
                    Node next = new Node(nx, ny);   // 익은 토마토의 영향을 받아 익을 토마토 좌표
                    next.level = currentNode.level + 1; // 날짜 증가
                    arr[nx][ny] = 1;    // 토마토가 익음
                    queue.offer(next);  // 익은 토마토는 큐에 삽입
                    zero--; // 익지 않은 토마토 개수 감소
                    one++;  // 익은 토마토 개수 증가
                    answer = Math.max(answer, next.level);  // 날짜 저장
                }
            }
        }
        answer = -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        m = in.nextInt();
        n = in.nextInt();
        arr = new int[n][m];
        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int num = in.nextInt();
                if (num == 0) {
                    zero++; // 익지 않은 토마토 개수 카운팅
                } else if (num == 1) {
                    one++;  // 익은 토마토 개수 카운팅
                    queue.offer(new Node(i, j));    // 처음 입력때부터 익은 토마토는 큐에 삽입
                } else {
                    minusOne++; // 토마톽 존재하지 않는 개수 카운팅
                }
                arr[i][j] = num;    // 토마토 농장에 삽입
            }
        }

        solution(queue);
        System.out.println(answer);
    }
}
