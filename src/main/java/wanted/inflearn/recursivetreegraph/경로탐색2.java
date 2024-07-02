package main.java.wanted.inflearn.recursivetreegraph;

import java.util.ArrayList;
import java.util.Scanner;

public class 경로탐색2 {
    /**
     * 문제 : 방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프로그램을 작성하세요.
     *       (인접리스트로 풀이)
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
    static int n, m, answer = 0;   // 정점의 수, 간선의 수, 총 가지수
    static ArrayList<ArrayList<Integer>> graph; // 인접리스트
    static int[] ch;    // 방문 체크 배열

    public void dfs(int v) {
        // 방문한 정점이 마지막(n)이라면 경우의 수 증가
        if (v == n) {
            answer++;
        } else {
            // v번 인접리스트의 정점 만큼 반복
            for (int i : graph.get(v)) {
                // 방문안한 정점이라면
                if (ch[i] == 0) {
                    ch[i] = 1;  // 방문 체크
                    dfs(i);     // 정점 방문
                    ch[i] = 0;  // 정점 방문 완료로 체크 해제
                }
            }
        }
    }

    public static void main(String[] args) {
        경로탐색2 t = new 경로탐색2();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        ch = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            graph.get(a).add(b);
        }
        ch[1] = 1;  // 1번 정점 방문
        t.dfs(1); // 1번 정점부터 경로 탐색
        System.out.println(answer);
    }
}
