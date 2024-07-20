package main.java.wanted.inflearn.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 원더랜드V1 {
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
        int vex1;   // 정점1
        int vex2;   // 정점2
        int cost;   // 가중치(비용)

        public Edge(int vex1, int vex2, int cost) {
            this.vex1 = vex1;
            this.vex2 = vex2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;// cost 값을 기준으로 오름차순 정렬
        }
    }

    static int[] unf;   // 각 원소들의 집합 값을 담고 있을 배열
    static ArrayList<Edge> edges;

    static int find(int v) {
        if (v == unf[v]) {
            return v;
        } else {
            return unf[v] = find(unf[v]);
        }
    }
    static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            unf[fa] = fb;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        unf = new int[n + 1];
        edges = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            edges.add(new Edge(a, b, c));
        }

        Collections.sort(edges);    // cost 값에 의해 오름차순 정렬

        int answer = 0;  // 최소비용

        for (Edge ob : edges) {
            int fv1 = find(ob.vex1);
            int fv2 = find(ob.vex2);

            if (fv1 != fv2) {   // 집합이 서로 다르다면 연결 가능
                answer += ob.cost;  // 최소 비용에 비용 저장
                union(fv1, fv2);    // 집합 연결
            }
        }

        System.out.println(answer);
    }
}
