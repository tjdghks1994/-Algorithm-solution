package main.java.wanted.inflearn.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 최대수입스케쥴 {
    /**
     * 문제 : 현수는 유명한 강연자이다. N개의 기업에서 강연 요청을 해왔다.
     *       각 기업은 D일 안에 와서 강연을 해주면 M만큼의 강연료를 주기로 했다.
     *       각 기업이 요청한 D와 M을 바탕으로 가장 많은 돈을 벌 수 있도록 강연 스케쥴을 짜야 한다.
     *       단, 강연의 특성상 현수는 하루에 하나의 기업에서만 강연을 할 수 있다.
     *
     * 입력 : 첫 번째 줄에 자연수 N(1<=N<=10,000)이 주어지고, 다음 N개의 줄에 M(1<=M<=10,000)과 D(1<=D<=10,000)가 차례로 주어진다.
     *
     * 출력 : 첫 번째 줄에 최대로 벌 수 있는 수입을 출력한다.
     *
     * 예시 : 입력 - 6          출력 - 150
     *            50 2
     *            20 1
     *            40 2
     *            60 3
     *            30 3
     *            30 1
     */
    public static class Lecture implements Comparable<Lecture> {
        int money;
        int deadLine;

        public Lecture(int money, int deadLine) {
            this.money = money;
            this.deadLine = deadLine;
        }

        @Override
        public int compareTo(Lecture o) {   // 강연 마감일자를 기준으로 내림차순 정렬
            return o.deadLine - this.deadLine;
        }
    }

    static int n;
    static int maxDay = Integer.MIN_VALUE;  // 최대 강연 마감일자

    public static void solution(ArrayList<Lecture> lectures) {
        int answer = 0; // 최대 수입
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());  // 강연료를 담을 우선순위 큐 - 큰 강연료가 우선순위가 높음

        Collections.sort(lectures); // 강연 마감일자를 기준으로 내림차순

        int j = 0;
        for (int i = maxDay; i > 0; i--) {  // 최대 강연 마감일자만큼 반복
            for (; j < n; j++) {    // 강연 수 만큼 반복
                if (i == lectures.get(j).deadLine) {    // 반복문의 마감일자와 강연의 마감일자가 같은 경우
                    pq.offer(lectures.get(j).money);    // 우선순위 큐에 삽입
                } else {    // 반복문의 마감일자보다 강연의 마감일자가 작은(다른) 경우
                    break;  // 현재 안쪽 반복문은 종료
                }
            }

            answer += pq.poll();    // 현재 우선순위 큐에 담긴 값 중 가장 큰 값을 최대 수입에 저장
        }

        System.out.println(answer);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        ArrayList<Lecture> lectures = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int money = in.nextInt();
            int deadLine = in.nextInt();

            lectures.add(new Lecture(money, deadLine));
            maxDay = Math.max(maxDay, deadLine);
        }

        solution(lectures);
    }
}
