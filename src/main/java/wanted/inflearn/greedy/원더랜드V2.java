package main.java.wanted.inflearn.greedy;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 원더랜드V2 {
    /**
     * 문제 : 원더랜드에 문제가 생겼따. 원더랜드의 각 도르를 유지보수하는 재정이 바닥난 것이다.
     *       원더랜드는 모든 도시를 서로 연결하면서 최소의 유지비용이 들도록 도로를 선택하고, 나머지 도로는 폐쇄하려고 한다.
     *       각 도시가 1부터 9로 표현되었고, 지도의 오른쪽은 최소비용 196으로 모든 도시를 연결하는 방법을 찾아낸 것이다.
     *
     * 입력 : 첫째 줄에 도시의 개수 V(1<=V<=100)와 도로의 개수 E(1<=E<=1,000)가 주어진다.
     *       다음 E개의 줄에는 각 도로에 대한 정보를 나타내는 세 정수 A,B,C가 주어진다.
     *       이는 A번 도시와 B번 도시가 유지비용이 C인 도로로 연결되어 있다는 의미이다.
     *
     * 출력 : 모든 도시를 연결하면서 드는 최소비용을 출력한다.
     *
     * 예시 : 입력 - 9 12       출력 -  196
     *            1 2 12
     *            1 9 25
     *            2 3 10
     *            2 8 17
     *            2 9 8
     *            3 4 18
     *            3 7 55
     *            4 5 44
     *            5 6 60
     *            5 7 38
     *            7 8 35
     *            8 9 15
     */

    static class Edge implements Comparable<Edge> {
        int vex;
        int cost;

        public Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;  // 비용을 기준으로 오름차순 정렬
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();   // 무방향 그래프
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] ch = new int[n + 1];  // 체크 배열

        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            graph.get(a).add(new Edge(b, c));  // 무방향 그래프이므로 양쪽 방향 모두 add
            graph.get(b).add(new Edge(a, c));  // 무방향 그래프이므로 양쪽 방향 모두 add
        }

        int answer = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0));   // 첫 번째 정점인 1번 정점 삽입

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int ev = edge.vex;  // 현재 정점의 연결되어 있는 정점
            // 체크가 되지 않은 정점만
            if (ch[ev] == 0) {
                ch[ev] = 1; //  체크
                answer += edge.cost;    // 최소 비용에 비용 추가
                // 연결된 정점인 ev와 연결되어 있는 모든 정점 목록만큼 반복
                for (Edge ob : graph.get(ev)) {
                    if(ch[ob.vex]==0) {
                        pq.offer(new Edge(ob.vex, ob.cost));
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
