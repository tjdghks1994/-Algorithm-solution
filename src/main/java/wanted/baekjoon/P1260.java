package main.java.wanted.baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1260 {
    /**
     * 문제 : 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
     *       단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고
     *       더이상 방문할 수 있는 정점이 없는 경우 종료한다.
     *       정점 번호는 1번부터 N번 까지이다.
     *
     * 입력 : 첫째 줄에 정점의 개수 N(1<=N<=1,000), 간선의 개수 M(1<=M<=10,000), 탐색을 시작할 정점의 번호 V가 주어진다.
     *       다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다.
     *       어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다.
     *       입력으로 주어지는 간선은 양방향이다.
     *
     * 출력 : 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다.
     *       V부터 방문된 점을 순서대로 출력하면 된다.
     *
     * 예시 : 입력 -  4 5 1         출력 - 1 2 4 3
     *              1 2                1 2 3 4
     *              1 3
     *              1 4
     *              2 4
     *              3 4
     *
     */
    static int[][] graph;    // 양방향 그래프
    static ArrayList<Integer> check; // 방문 체크

    public static void DFS(int v) {
        if (!check.contains(v)) {
            System.out.print(v + " ");
        }

        check.add(v);   // 방문 체크

        for (int i = 1; i < graph.length; i++) {
            // 방문 가능한 정점
            if (graph[v][i] == 1 && !check.contains(i)) {
                DFS(i);
            }
        }
    }

    public static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();

            if (!check.contains(vertex)) {
                System.out.print(vertex + " ");
            }
            check.add(vertex);

            for (int i = 1; i < graph.length; i++) {
                // 방문 가능한 정점
                if (graph[vertex][i] == 1 && !check.contains(i)) {
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int v = in.nextInt();
        graph = new int[n + 1][n + 1];
        check = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int s = in.nextInt();
            int vertex = in.nextInt();
            graph[s][vertex] = 1;
            graph[vertex][s] = 1;
        }

        DFS(v);
        check = new ArrayList<>();  // DFS 완료 후 방문 체크 초기화
        System.out.println();
        BFS(v);
    }
}
