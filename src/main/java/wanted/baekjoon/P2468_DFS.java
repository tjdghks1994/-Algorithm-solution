package main.java.wanted.baekjoon;

import java.util.Scanner;

public class P2468_DFS {
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
    static int[][] arr;     // 지역
    static int maxHeight;   // 최대 높이
    static boolean[][] visited; // 방문 체크 배열
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void DFS(int i, int j, int height) {

        for (int x = 0; x < 4; x++) {
            int nx = i + dx[x];
            int ny = j + dy[x];
            // 이동 불가능한 영역은 패스
            if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            // 이미 방문한 영역은 패스
            if(visited[nx][ny]) continue;
            // 물에 잠긴 영역은 패스
            if(arr[nx][ny] <= height ) continue;
            // 방문 체크
            visited[nx][ny] = true;
            // 물에 잠기지 않은 영역은 탐색
            DFS(nx, ny, height);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        arr = new int[n][n];

        // 지역 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
                maxHeight = Math.max(maxHeight, arr[i][j]);
            }
        }

        int answer = 0; // 안전 영역의 최대 개수
        // 물에 잠기는 높이를 변경하면서 안전 영역의 개수를 탐색
        for (int height = 0; height < maxHeight; height++) {
            int cnt = 0;    // 현재 height 에서 안전 영역의 개수
            visited = new boolean[n][n];    // 방문 체크 배열 초기화
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && arr[i][j] > height) {
                        DFS(i, j, height);
                        cnt++;
                    }
                }
            }
            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);
    }
}
