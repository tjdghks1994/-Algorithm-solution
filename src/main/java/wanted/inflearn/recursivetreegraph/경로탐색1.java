package main.java.wanted.inflearn.recursivetreegraph;

import java.util.Scanner;

public class 경로탐색1 {
    /**
     * 문제 : 방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프로그램을 작성하세요.
     *
     * 입력 : 첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M이 주어진다.
     *       그 다음부터 M줄에 걸쳐 연결정보가 주어진다.
     *
     * 출력 : 총 가지수를 출력한다.
     *
     * 예시 : 입력 - 5 9        출력 - 6
     *            1 2
     *            1 3
     *            1 4
     *            2 1
     *            2 3
     *            2 5
     *            3 4
     *            4 2
     *            4 5
     */
    static int n, m, answer = 0; // 정점의 수, 간선의 수, 총 가지수
    static int[][] graph;   // 인접행렬
    static int[] ch;        // 방문 체크를 위한 배열

    public void dfs(int v) {
        // 현재 정점이 n번 정점이라면 이동 완료, 가지수 추가
        if (v == n) {
            answer++;
        } else {
            // 1번 정점부터 n번 정점까지 반복
            for (int i = 1; i <= n; i++) {
                // 인접행렬을 통해 이동 가능한 정점이면서, 아직 방문을 안한 정점이라면 이동 가능
                if (graph[v][i] == 1 && ch[i] == 0) {
                    ch[i] = 1;  // 해당 정점으로 이동했으므로 체크
                    dfs(i);
                    ch[i] = 0;  // 해당 정점으로 back 했으므로 체크 해제
                }
            }
        }
    }

    public static void main(String[] args) {
        경로탐색1 t = new 경로탐색1();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        graph = new int[n + 1][n + 1];
        ch = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int a = in.nextInt();   // 정점 행
            int b = in.nextInt();   // 정점 열
            // 방향그래프이므로 행 -> 열만 표시
            graph[a][b] = 1;    // 인접행렬에 표시
        }
        ch[1] = 1;  // 1번 정점 방문
        t.dfs(1); // 1번 정점부터 경로 탐색
        System.out.println(answer);
    }
}
