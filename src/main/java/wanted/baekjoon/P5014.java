package main.java.wanted.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P5014 {
    /**
     * 문제 : 강호는 코딩 교육을 하는 스타트업 스타트링크에 지원했다. 오늘은 강호의 면접날이다.
     *       하지만, 늦잠을 잔 강호는 스타트링크가 있는 건물에 늦게 도착하고 말았다.
     *       스타트링크는 총 F층으로 이루어진 고층 건물에 사무실이 있고, 스타트링크가 있는 곳의 위치는 G층이다.
     *       강호가 지금 있는 곳은 S층이고, 이제 엘리베이터를 타고 G층으로 이동하려고 한다.
     *       보통 엘리베이터에는 어떤 층으로 이동할 수 있는 버튼이 있지만, 강호가 탄 엘리베이터는 버튼이 2개밖에 없다.
     *       U버튼은 위로 U층을 가는 버튼, D버튼은 아래로 D층을 가는 버튼이다.
     *       (만약 U층 위, 또는 D층 아래에 해당하는 층이 없을 때는 엘리베이터가 움직이지 않는다.)
     *       강호가 G층에 도착하려면, 버튼을 적어도 몇 번 눌러야 하는지 구하는 프로그램을 작성하시오.
     *       만약, 엘리베이터를 이용해서 G층에 갈 수 없다면, "use the stairs"를 출력한다.
     *
     * 입력 : 첫째 줄에 F,S,G,U,D가 주어진다.
     *       (1<=S,G<=F<=1,000,000, 0<=U,D<=1,000,000)
     *       건물은 1층부터 시작하고, 가장 높은 층은 F층이다.
     *
     * 출력 : 첫째 줄에 강호가 S층에서 G층으로 가기 위해 눌러야 하는 버튼의 수의 최솟값을 출력한다.
     *       만약, 엘리베이터로 이동할 수 없을 때는 "use the stairs"를 출력한다.
     *
     * 예시 : 입력 - 10 1 10 2 1        출력 - 6
     *       입력 - 100 2 1 1 0        출력 - use the stairs
     */
    static int f;   // 건물의 총 층수
    static int g, s;    // 스타트링크 층수, 강호의 현재 층수
    static int u,d;     // 위로 이동하는 층수, 아래로 이동하는 층수
    static boolean[] visited;  // 방문 체크 배열

    static class GanHo {
        int floor;
        int count;

        public GanHo(int floor, int count) {
            this.floor = floor;
            this.count = count;
        }
    }

    public static void BFS(int start) {
        Queue<GanHo> queue = new LinkedList<>();
        queue.offer(new GanHo(start, 0));
        visited[start] = true;  // 방문 체크
        int[] ud = {u, -d};      // 이동 가능 층수 배열

        while (!queue.isEmpty()) {
            GanHo current = queue.poll();
            // 강호의 위치가 스타트링크 위치가 되었다면 출력
            if (current.floor == g) {
                System.out.println(current.count);
                return;
            }

            for (int i = 0; i <= 1; i++) {
                int nf = current.floor + ud[i];   // 다음 이동 층

                if (nf >= 1 && nf <= f && !visited[nf]) {
                    queue.offer(new GanHo(nf, current.count + 1));
                    visited[nf] = true; //  방문 체크
                }
            }
        }

        // 스타트링크로 가지 못한다면 출력
        System.out.println("use the stairs");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        f = in.nextInt();
        s = in.nextInt();
        g = in.nextInt();
        u = in.nextInt();
        d = in.nextInt();
        visited = new boolean[f + 1];

        BFS(s);
    }
}
