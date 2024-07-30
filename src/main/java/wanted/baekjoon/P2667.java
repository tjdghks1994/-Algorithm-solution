package main.java.wanted.baekjoon;

import java.util.*;

public class P2667 {
    /**
     * 문제 : <그림1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다.
     *       철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다.
     *       여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다.
     *       대각선상에 집이 있는 경우는 연결된 것이 아니다.
     *       <그림2>는 <그림1>을 단지별로 번호를 붙인 것이다.
     *       지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.
     *
     *       0 1 1 0 1 0 0          0 1 1 0 2 0 0
     *       0 1 1 0 1 0 1          0 1 1 0 2 0 2
     *       1 1 1 0 1 0 1          1 1 1 0 2 0 2
     *       0 0 0 0 1 1 1          0 0 0 0 2 2 2
     *       0 1 0 0 0 0 0          0 3 0 0 0 0 0
     *       0 1 1 1 1 1 0          0 3 3 3 3 3 0
     *       0 1 1 1 0 0 0          0 3 3 3 0 0 0
     *          <그림1>                  <그림2>
     *
     * 입력 : 첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 길이는 같으며 5<=N<=25)이 입력되고,
     *       그 다음 N줄 에는 각각 N개의 자료(0혹은 1)가 입력된다.
     *
     * 출력 : 첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.
     *
     * 예시 : 입력 - 7          출력 - 3
     *            0110100          7
     *            0110101          8
     *            1110101          9
     *            0000111
     *            0100000
     *            0111110
     *            0111000
     */
    static int n;   // 지도 크기
    static int[][] map; // 지도
    static int[] dx = {-1, 0, 1, 0};    // 상,우,하,좌
    static int[] dy = {0, 1, 0, -1};    // 상,우,하,좌
    static ArrayList<Integer> cntList;   // 단지내 집의 수

    static class House {
        int x;
        int y;

        public House(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void BFS(int i, int j) {
        Queue<House> queue = new LinkedList<>();
        queue.add(new House(i, j)); // 단지내 첫 집을 큐에 삽입
        int answer = 1;             // 총 단지수 초기화
        map[i][j] = 0;              // 첫 집은 방문했으므로 이동 불가하도록 0으로 변경

        while (!queue.isEmpty()) {
            House current = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nx = current.x + dx[k]; // 이동할 x 좌표
                int ny = current.y + dy[k]; // 이동할 y 좌표
                // 연결되어 있는 집(이동 가능한 경로)인 경우 같은 단지
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == 1) {
                    queue.add(new House(nx, ny));
                    answer++;           // 총 단지수 값 증가
                    map[nx][ny] = 0;    // 방문한 집은 이동 불가능하게 0으로 변경
                }
            }
        }
        // 단지의 총 집의 수 저장
        cntList.add(answer);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = Integer.valueOf(in.nextLine());
        map = new int[n][n];
        cntList = new ArrayList<>();
        // 지도 생성
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }
        // 생성된 지도 중 집인 경우 BFS 실행
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    BFS(i, j);
                }
            }
        }
        // 총 단지수 출력
        System.out.println(cntList.size());
        Collections.sort(cntList);  // 오츪차순 정렬
        // 단지내 집의 수 출력
        for (int i : cntList) {
            System.out.println(i);
        }
    }
}
