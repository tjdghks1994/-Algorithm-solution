package main.java.wanted.inflearn.recursivetreegraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 그래프최단거리BFS {
    /**
     * 문제 : 다음 그래프에서 1번 정점에서 각 정점으로 가는 최소 이동 간선수를 출력하세요.
     *
     * 입력 : 첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M이 주어진다.
     *       그 다음부터 M줄에 걸쳐 연결정보가 주어진다.
     *
     * 출력 : 1번 정점에서 각 정점으로 가는 최소 간선수를 2번 정점부터 차례대로 출력하세요.
     *
     * 예시 : 입력 - 6 9        출력 - 2 : 3
     *            1 3              3 : 1
     *            1 4              4 : 1
     *            2 1              5 : 2
     *            2 5              6 : 2
     *            3 4
     *            4 5
     *            4 6
     *            6 2
     *            6 5
     *
     */
    static int n,m;  // 정점의 수, 간선의 수
    static ArrayList<ArrayList<Integer>> graph; // 인접리스트
    static int[] ch, dis;   // 방문 체크 배열과 최단거리 기록 배열

    public void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        ch[v] = 1;  // 방문 체크
        dis[v] = 0; // 최단거리 기록 (첫번째 정점이므로 0)
        queue.offer(v);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            // 큐에서 꺼낸 정점의 인접리스트 반복
            for (int i : graph.get(current)) {
                // 인접리스트의 정점이 방문된 적이 없다면
                if (ch[i] == 0) {
                    ch[i] = 1;  //   방문 체크
                    queue.offer(i); // 큐에 정점 삽입
                    dis[i] = dis[current] + 1;  // 최단거리 기록
                }
            }
        }
    }

    public static void main(String[] args) {
        그래프최단거리BFS t = new 그래프최단거리BFS();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        ch = new int[n + 1];    // 방문 체크 배열
        dis = new int[n + 1];   // 최단 거리 기록 배열

        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            graph.get(a).add(b);
        }

        t.bfs(1);

        for (int i = 2; i <= n; i++) {
            System.out.println(i + " : " + dis[i]);
        }
    }
}
