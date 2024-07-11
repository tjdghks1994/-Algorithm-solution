package main.java.wanted.inflearn.recursivetreegraph;

import java.util.*;

public class 피자배달거리 {
    /**
     * 문제 : NxN 크기의 도시지도가 있습니다. 도시지도는 1x1 크기의 격자칸으로 이루어져 있습니다.
     *       각 격자칸에는 0은 빈칸, 1은 집, 2는 피자집으로 표현됩니다.
     *       각 격자칸은 좌표(행번호, 열번호)로 표현됩니다.
     *       행번호는 1번부터 N번 까지이고, 열번호도 1부터 N 까지입니다.
     *       도시에는 각 집마다 "피자배달거리"가 있는데 각 집의 피자배달거리는 해당 집과 도시의 존재하는
     *       피자집들과의 거리 중 최소값을 해당 집의 "피자배달거리"라고 한다.
     *       집과 피자집의 피자배달거리는 |x1-x2|+|y1-y2| 이다.
     *       예를 들어, 도시의 지도가 아래와 같다면
     *       0 1 0 0
     *       0 0 2 1
     *       0 0 1 0
     *       1 2 0 2
     *       (1,2)에 있는 집과 (2,3)에 있는 피자집과의 피자 배달 거리는 |1-2|+|2-3| = 2 가 된다.
     *       최근 도시가 불경기에 접어들어 우후죽순 생겼던 피자집들이 파산하고 있습니다.
     *       도시 시장은 도시에 있는 피자집 중 M개만 살리고 나머지는 보조금을 주고 폐업시키려고 합니다.
     *       시장은 살리고자 하는 피자집 M개를 선택하는 기준으로 도시의 피자배달거리가 최소가 되는 M개의 피자집을 선택하려고 합니다.
     *       도시의 피자 배달 거리는 각 집들의 피자 배달 거리를 합한 것을 말합니다.
     *
     * 입력 : 첫째 줄에 N(2<=N<=50)과 M(1<=M<=12)이 주어집니다.
     *       둘째 줄부터 도시 정보가 입력됩니다.
     *
     * 출력 : 첫째 줄에 M개의 피자집이 선택되었을 때, 도시의 최소 피자배달거리를 출력합니다.
     *
     * 예시 : 입력 -  4 4           출력 - 6
     *             0 1 2 0
     *             1 0 2 1
     *             0 2 1 2
     *             2 0 1 2
     */
    static int n;
    static int m;           // 선택할 피자집 개수
    static int len = 0;     // 총 피자집 개수
    static int answer = Integer.MAX_VALUE;  // 최소거리 값
    static int[] combi;     // m개 만큼 뽑은 피자집을 담을 배열
    static int[][] arr;     // 지도
    static ArrayList<Node> houseList = new ArrayList<>();  // 집 좌표
    static ArrayList<Node> pizzaList = new ArrayList<>();  // 피자집 좌표

    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void solution(int level, int s) {

        if (level == m) {   // 피자집을 전부 다 뽑은 경우
            int sum = 0;
            for (Node h : houseList) {  // 집의 목록
                int dis = Integer.MAX_VALUE;    // 집과 피자집의 거리

                for (int i : combi) {   // 뽑은 피자집 목록
                    // 집과 피자집의 모든 목록을 비교하면서 최소 피자배달거리를 저장
                    dis = Math.min(dis, Math.abs(h.x - pizzaList.get(i).x) + Math.abs(h.y - pizzaList.get(i).y));
                }

                sum += dis;
            }

            answer = Math.min(answer, sum);
        } else {
            for (int i = s; i < len; i++) {
                combi[level] = i;   // 피자집 뽑기 ( pizzaList 의 인덱스 번호 )
                solution(level + 1, i + 1);
            }
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int nextInt = in.nextInt();
                if (nextInt == 1) {
                    houseList.add(new Node(i, j));  // 집 좌표 삽입
                } else if (nextInt == 2) {
                    pizzaList.add(new Node(i, j));  // 피자집 좌표 삽입
                }
            }
        }

        len = pizzaList.size(); // 피자집 총 개수
        combi = new int[m]; // 뽑은 피자집

        solution(0, 0);
        System.out.println(answer);
    }
}
