package main.java.wanted.inflearn.recursivetreegraph;

import java.util.Scanner;

public class 최대점수구하기 {
    /**
     * 문제 : 이번 정보올림피아드대회에서 좋은 성적을 내기 위하여 현수는 선생님이 주신 N개의 문제를 풀려고 합니다.
     *       각 문제는 그것을 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어지게 됩니다.
     *       제한시간 M안에 N개의 문제 중 최대점수를 얻을 수 있또록 해야 합니다.
     *       (해당문제는 해당시간이 걸리면 푸는 걸로 간주합니다. 한 유형당 한 개만 풀 수 있습니다.)
     *
     * 입력 : 첫 번째 줄에 문제의 개수(1<=N<=20)과 제한 시간(10<=M<=300)이 주어집니다.
     *       두 번째 줄부터 N줄에 걸쳐 문제를 풀었을 때의 점수와 푸는데 걸리는 시간이 주어집니다.
     *
     * 출력 : 첫 번째 줄에 제한 시간안에 얻을 수 있는 최대 점수를 출력합니다.
     *
     * 예시 : 입력 - 5 20           출력 - 41
     *            10 5
     *            25 12
     *            15 8
     *            6 3
     *            7 4
     */
    static int sum = 0;
    public static class Node {
        int score;  // 점수
        int time;   // 시간
        public Node(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }

    public static void solution(int level, int currentSum, int currentTime, int m, Node[] nodes) {
        // 이미 시간을 초과한 경우 다음 노드를 방문할 필요 없음
        if (currentTime > m) {
            return;
        }
        // 리프노드까지 방문을 완료했다면 최대 점수를 기록
        if (level == nodes.length) {
            sum = Math.max(sum, currentSum);
        } else {
            // 현재까지의 sum 값에 현재 노드의 점수를 더하고, 현재까지의 time 값에 현재 노드의 시간을 더하고 다음 노드를 방문
            solution(level + 1, currentSum + nodes[level].score, currentTime + nodes[level].time, m, nodes);
            // 현재까지의 sum 값에 현재 노드의 점수를 더하지 않고, 현재까지의 time 값에 현재 노드의 시간을 더하지 않고 다음 노드를 방문
            solution(level + 1, currentSum, currentTime, m, nodes);
        }

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            int score = in.nextInt();
            int time = in.nextInt();
            nodes[i] = new Node(score, time);
        }

        solution(0, 0, 0, m, nodes);
        System.out.println(sum);
    }
}
