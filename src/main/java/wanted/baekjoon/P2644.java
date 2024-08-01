package main.java.wanted.baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2644 {
    /**
     * 문제 : 우리나라는 가족 혹은 친척들 사이의 관계를 촌수라는 단위로 표현하는 독특한 문화를 가지고 있다.
     *       이러한 촌수는 다음과 같은 방식으로 계산된다.
     *       기본적으로 부모와 자식 사이를 1촌으로 정의하고, 이로부터 사람들 간의 촌수를 계산한다.
     *       예를 들면 나와 아버지, 아버지와 할아버지는 각각 1촌으로 나와 할아버지는 2촌이 되고, 아버지 형제들과 할아버지는 1촌,
     *       나와 아버지 형제들과는 3촌이 된다.
     *       여러 사람들에 대한 부모 자식들 간의 관계가 주어졌을 때, 주어진 두 사람의 촌수를 계산하는 프로그램을 작성하시오.
     *
     * 입력 : 사람들은 1,2,3,...,n (1<=n<=100)의 연속된 번호로 각각 표시된다.
     *       입력 파일의 첫째 줄에는 전체 사람의 수 n이 주어지고, 둘째 줄에는 촌수를 계산해야 하는 서로 다른 두 사람의 번호가 주어진다.
     *       그리고 셋째 줄에는 부모 자식들 간의 관계의 개수 m이 주어진다.
     *       넷째 줄부터는 부모 자식간의 관계를 나타내는 두번호 x,y가 각 줄에 나온다.
     *       이때 각 사람의 부모는 최대 한 명만 주어진다.
     *
     * 출력 : 입력에서 요구한 두 사람의 촌수를 나타내는 정수를 출력한다.
     *       어떤 경우에는 두 사람의 친척 관계가 전혀 없어 촌수를 계산할 수 없을 때가 있다.
     *       이때에는 -1을 출력한다.
     *
     * 예시 : 입력 - 9          출력 - 3
     *            7 3
     *            7
     *            1 2
     *            1 3
     *            2 7
     *            2 8
     *            2 9
     *            4 5
     *            4 6
     */
    static int n, m, x, y;
    static ArrayList<ArrayList<Vertex>> list;   // 그래프
    static boolean[] visited;   //  방문 체크 배열

    static class Vertex {
        int x;
        int level;

        public Vertex(int x, int level) {
            this.x = x;
            this.level = level;
        }
    }

    public static void BFS(int start) {
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(new Vertex(start, 0));
        visited[start] = true;  //  방문 체크
        int answer = 0;         // 촌수

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            // 현재 사람과 1촌 관계에 있는 사람을 탐색
            for (Vertex i : list.get(current.x)) {
                // 이미 탐색한 사람 스킵
                if(visited[i.x]) continue;

                visited[i.x] = true;    // 방문 체크
                i.level = current.level + 1;  // 촌수 증가
                queue.add(i);           // 다음 사람 방문을 위해 큐에 삽입
                // 촌수를 계산해야 하는 사람인 경우
                if (i.x == y) {
                    answer += i.level;  // 촌수 값을 저장
                    break;
                }
            }
        }
        // 둘이 친척 관계인 경우 촌수 출력
        if (answer > 0) {
            System.out.println(answer);
        } else {    // 둘이 친척 관계가 아닌 경우 -1 출력
            System.out.println(-1);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        x = in.nextInt();
        y = in.nextInt();
        m = in.nextInt();
        list = new ArrayList<>();
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int j = 0; j < m; j++) {
            int x = in.nextInt();
            int y = in.nextInt();
            list.get(x).add(new Vertex(y, 0));
            list.get(y).add(new Vertex(x, 0));
        }

        BFS(x);
    }
}
