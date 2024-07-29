package main.java.wanted.baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class P2606 {
    /**
     * 문제 : 신종 바이러스인 웜 바이러스는 네트워크를 통해 전파된다.
     *       한 컴퓨터가 웜 바이러스에 걸리면 그 컴퓨터와 네트워크 상에서 연결되어 있는 모든 컴퓨터는 웜 바이러스에 걸리게 된다.
     *       어느 날 1번 컴퓨터가 웜 바이러스에 걸렸다.
     *       컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를
     *       출력하는 프로그램을 작성하시오.
     *
     * 입력 : 첫째 줄에는 컴퓨터의 수가 주어진다.
     *       컴퓨터의 수는 100이하인 양의 정수이고, 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다.
     *       둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터의 쌍의 수가 주어진다.
     *       이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.
     *
     * 출력 : 1번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 첫째 줄에 출력한다.
     *
     * 예시 : 입력 - 7          출력 - 4
     *            6
     *            1 2
     *            2 3
     *            1 5
     *            5 2
     *            5 6
     *            4 7
     */
    static int n, m;
    static int[] chk;   // 체크 배열
    static int answer;  // 바이러스에 걸리게 된 컴퓨터 수
    static ArrayList<ArrayList<Integer>> graph; // 무방향 그래프

    public static void recursive(int v) {
        for (int i : graph.get(v)) {
            // 방문을 한 정점인 경우
            if (chk[i] != 0) {
                continue;
            }
            // 방문을 하지 않은 정점인 경우
            answer++;   // 바이러스 걸림
            chk[i] = 1; // 방문 체크
            recursive(i);     // 연결된 컴퓨터도 방문
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = Integer.valueOf(in.nextLine());
        m = Integer.valueOf(in.nextLine());
        chk = new int[n + 1];
        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= m; i++) {
            String[] nums = in.nextLine().split(" ");
            int v1 = Integer.valueOf(nums[0]);
            int v2 = Integer.valueOf(nums[1]);
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        chk[1] = 1;
        recursive(1);

        System.out.println(answer);
    }
}
