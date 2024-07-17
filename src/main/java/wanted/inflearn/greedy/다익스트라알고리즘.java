package main.java.wanted.inflearn.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 다익스트라알고리즘 {
    /**
     * 문제 : 가중치 방향그래프에서 1번 정점에서 모든 정점으로의 최소 거리비용을 출력하는 프로그램을 작성하세요.
     *       만약 경로가 없으면 Impossible을 출력합니다.
     *
     * 입력 : 첫째 줄에는 정점의 수 N(1<=N<=20)과 간선의 수 M이 주어집니다.
     *       그 다음부터 M줄에 걸쳐 연결정보와 거리비용이 주어집니다.
     *
     * 출력 : 1번 정점에서 각 정점으로 가는 최소비용을 2번 정점부터 차례대로 출력하세요.
     *
     * 예시 : 입력 - 6 9                                                            출력 - 2 : 11
     *             1 2 12   // 1번 정점에서 2번 정점으로 가는데 12의 비용이 든다는 것을 의미          3 : 4
     *             1 3 4                                                               4 : 9
     *             2 1 2                                                               5 : 14
     *             2 3 5                                                               6 : impossible
     *             2 5 5
     *             3 4 5
     *             4 2 2
     *             4 5 5
     *             6 4 5
     */
    static int n;
    static int m;
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;

    public static class Edge implements Comparable<Edge> {

        int vex;    // 정점
        int cost;   // 가중치(비용)
        public Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;  // 가중치를 기준으로 오름차순 정렬 - priority 에서 우선순위의 기준이 됨
        }

    }

    public static void solution(int v) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(v, 0));   // 첫번째 정점을 우선순위 큐에 삽입

        dis[v] = 0; // 첫번째 정점의 최소비용은 0으로 변경

        while (!pq.isEmpty()) {
            Edge tmp = pq.poll();   // cost 값이 작은 정점부터 나옴
            int now = tmp.vex;
            int nowCost = tmp.cost;

            if(nowCost>dis[now]) continue;

            for (Edge ob : graph.get(now)) {
                if (dis[ob.vex] > nowCost + ob.cost) {  // 정점의 최소비용 값이 nowCost+ob.cost 값보다 크다면
                    dis[ob.vex] = nowCost + ob.cost;    // 정점의 최소비용을 변경
                    pq.offer(new Edge(ob.vex, nowCost + ob.cost));  // 우선순위 큐에 삽입
                }
            }
        }

        for (int i = 2; i < dis.length; i++) {
            if (dis[i] != Integer.MAX_VALUE) {
                System.out.println(i + " : " + dis[i]);
            } else {
                System.out.println(i + " : impossible");
            }

        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        dis = new int[n + 1];   // 정점의 최소비용을 담는 배열
        Arrays.fill(dis, Integer.MAX_VALUE);    // 처음 모든 정점의 최소비용은 정수의 최대값으로 세팅

        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            graph.get(a).add(new Edge(b, c));
        }

        solution(1);
    }
}
