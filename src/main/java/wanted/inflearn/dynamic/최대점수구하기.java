package main.java.wanted.inflearn.dynamic;

import java.util.ArrayList;
import java.util.Scanner;

public class 최대점수구하기 {
    /**
     * 문제 : 이번 정보올림피아드대회에서 좋은 성적을 내기 위하여, 현수는 선생님이 주신 N개의 문제를 풀려고 합니다.
     *       각 문제는 그것을 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어지게 됩니다.
     *       제한시간 M안에 N개의 문제 중, 최대점수를 얻을 수 있도록 해야 합니다.
     *       (해당문제는 해당시간이 걸리면 푸는 걸로 간주한다. 한 유형당 한 개만 풀 수 있습니다.)
     *
     * 입력 : 첫 번째 줄에 문제의 개수 N(1<=N<=50)과 제한 시간 M(10<=M<=300)이 주어집니다.
     *       두 번째 줄부터 N줄에 걸쳐 문제를 풀었을 때의 점수와 푸는데 걸리는 시간이 주어집니다.
     *
     * 출력 : 첫 번째 줄에 제한 시간안에 얻을 수 있는 최대 점수를 출력합니다.
     *
     * 예시 : 입력 - 5 20       출력 - 41
     *            10 5
     *            25 12
     *            15 8
     *            6 3
     *            7 4
     */

    static class Question implements Comparable<Question> {
        int score;
        int time;

        public Question(int score, int time) {
            this.score = score;
            this.time = time;
        }

        @Override
        public int compareTo(Question o) {
            return this.time - o.time;   // 시간을 기준으로 오름차순 정렬
        }
    }

    static int[] dy;    // 인덱스를 제한 시간으로 했을 때, 최대 점수를 저장할 배열

    public static void solution(ArrayList<Question> list, int m) {

        for (int i = 0; i < list.size(); i++) {
            // 현재 리스트 원소의 시간 값부터 반복
            for (int j = m; j >= list.get(i).time; j--) {
                // 제한시간이 j일 때, 현재 리스트 원소의 시간 값으로 만들 수 있는 최대 점수를 구해서 비교 후, 배열에 저장
                dy[j] = Math.max(dy[j - list.get(i).time] + list.get(i).score, dy[j]);
            }
        }

        System.out.println(dy[m]);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        dy = new int[m+1];
        ArrayList<Question> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int score = in.nextInt();
            int time = in.nextInt();
            list.add(new Question(score, time));
        }

        solution(list, m);
    }
}
