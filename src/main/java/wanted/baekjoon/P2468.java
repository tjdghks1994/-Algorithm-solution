package main.java.wanted.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2468 {
    /**
     * 문제 : 재난방재청에서는 많은 비가 내리는 장마철에 대비해서 다음과 같은 일을 계획하고 있다.
     *       먼저 어떤 지역의 높이 정보를 파악한다.
     *       그 다음에 그 지역에 많은 비가 내렸을 때 물에 잠기지 않는 안전한 영역이 최대로 몇 개가 만들어 지는 지를 조사하려고 한다.
     *       이때, 문제를 간단하게 하기 위하여, 장마철에 내리는 비의 양에 따라 일정한 높이 이하의 모든 지점은 물에 잠긴다고 가정한다.
     *       어떤 지역의 높이 정보는 행과 열의 크기가 각각 N인 2차원 배열 형태로 주어지며,
     *       배열의 각 원소는 해당 지점의 높이를 표시하는 자연수이다.
     *       예를 들어 N=5인 지역의 높이 정보는 아래와 같다.
     *       6 8 2 6 2
     *       3 2 3 4 6
     *       6 7 3 3 2
     *       7 2 5 3 6
     *       8 9 5 2 7
     *       이제 위와 같은 지역에 많은 비가 내려서 높이가 4 이하인 모든 지점이 물에 잠겼다고 하자.
     *       물에 잠기지 않는 안전한 영역이라 함은 물에 잠기지 않는 지점들이 위,아래,오른쪽 혹은 왼쪽으로 인접해 있으며
     *       그 크기가 최대인 영역을 말한다.
     *       위의 경우에서 물에 잠기지 않는 안전한 영역은 5개가 된다.
     *       또한 위와 같은 지역에서 높이가 6 이하인 지점을 모두 잠기게 만드는 많은 비가 내리면 물에 잠기지 않는 안전한 영역은 4개가 된다.
     *       이와 같이 장마철에 내리는 비의 양에 따라서 물에 잠기지 않는 안전한 영역의 개수는 다르게 된다.
     *       위의 예와 같은 지역에서 내리는 비의 양에 따른 모든 경우를 다 조사해 보면 물에 잠기지 않는 안전한 영역의 개수 중에서 최대인 경우는 5이다.
     *       어떤 지역의 높이 정보가 주어졌을 때, 장마철에 물에 잠기지 않는 안전한 영역의 최대 개수를 계산하는 프로그램을 작성하시오.
     *
     * 입력 : 첫째 줄에는 어떤 지역을 나타내는 2차원 배열의 행과 열의 개수를 나타내는 수 N이 입력된다.
     *       N은 2이상 100이하의 정수이다.
     *       둘째 줄부터 N개의 각 줄에는 2차원 배열의 첫 번째 행부터 N번재 행까지 순서대로 한 행씩 높이 정보가 입력된다.
     *       각 줄에는 각 행의 첫 번째 열부터 N번째 열까지 N개의 높이 정보를 나타내는 자연수가 빈 칸을 사이에 두고 입력된다.
     *       높이는 1이상 100이하의 정수이다.
     *
     * 출력 : 첫째 줄에 장마철에 물에 잠기지 않는 안전한 영역의 최대 개수를 출력한다.
     *
     * 예시 : 입력 - 5           출력 - 5
     *            6 8 2 6 2
     *            3 2 3 4 6
     *            6 7 3 3 2
     *            7 2 5 3 6
     *            8 9 5 2 7
     */
    static int n;
    static int[][] arr;
    static int maxHeight;   // 최대 높이
    static int[] dx = {-1, 0, 1, 0};    // 이동 x좌표
    static int[] dy = {0, 1, 0, -1};    // 이동 y좌표
    static boolean[][] check;   //  방문 체크 배열

    public static int BFS(int x, int y, int h) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        check[x][y] = true;  // 안전한 영역 확인했으므로 체크

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            // 인접한 지역이 안전한 영역인지 확인
            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                // 인접한 지역이 안전한 영역
                if (nx >= 0 && nx < n && ny >= 0 && ny < n &&
                        !check[nx][ny] && arr[nx][ny] > h) {
                    queue.offer(new int[]{nx, ny});  // 큐에 삽입
                    check[nx][ny] = true;                // 안전한 영역 확인했으므로 0으로 변경
                }
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        arr = new int[n][n];

        // 지역 정보 저장, 최대 높이 저장
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
                maxHeight = Math.max(maxHeight, arr[i][j]);
            }
        }

        int answer = 0; // 최대 안전한 영역 개수

        for (int i = 0; i < maxHeight; i++) {   // 장마철에 물에 잠기는 높이 지정
            check = new boolean[n][n];  // 방문 체크 배열 초기화
            int safeCount = 0;  // 현재 for 문에서 안전한 영역 개수

            // 장마철 물에 잠기는 높이가 i일 때 안전한 영역 개수 탐색
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (!check[j][k] && arr[j][k] > i) {
                        safeCount += BFS(j, k, i);
                    }
                }
            }
            // 안전한 영역 개수가 최대인 값을 저장
            answer = Math.max(safeCount, answer);
        }
        // 출력
        System.out.println(answer);
    }
}
