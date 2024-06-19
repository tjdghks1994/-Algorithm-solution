package main.java.wanted.inflearn.stackqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 응급실 {
    /**
     * 문제 : 메디컬 병원 응급실에는 의사가 한 명밖에 없습니다.
     *       응급실은 환자가 도착한 순서대로 진료를 합니다. 하지만 위험도가 높은 환자는 빨리 응급조치를 의사가 해야 합니다.
     *       이런 문제를 보완하기 위해 응급실은 다음과 같은 방법으로 환자의 진료순서를 정합니다.
     *       - 환자가 접수한 순서대로의 목록에서 제일 앞에 있는 환자 목록을 꺼냅니다.
     *       - 나머지 대기 목록에서 꺼낸 환자 보다 위험도가 높은 환자가 존재하면 대기목록 제일 뒤로 다시 넣습니다. 그렇지 않으면 진료를 받습니다.
     *       즉, 대기목록에 자기 보다 위험도가 높은 환자가 없을 때 자신이 진료를 받는 구조입니다.
     *       현재 N명의 환자가 대기목록에 있습니다.
     *       N명의 대기목록 순서의 환자 위험도가 주어지면, 대기목록상의 M번째 환자는 몇 번째로 진료를 받는지 출력하는 프로그램을 작성하세요.
     *       대기목록상의 M 번째는 대기목록의 제일 처음 환자를 0번째로 간주하여 표현한 것입니다.
     *
     * 입력 : 첫 줄에 자연수 N(5<=N<=100)과 M(0<=M<N)이 주어집니다.
     *       두 번째 줄에 접수한 순서대로 환자의 위험도(50<=위험도<=100)가 주어집니다.
     *       위험도는 값이 높을 수록 더 위험하다는 뜻입니다. 같은 값의 위험도가 존재할 수 있습니다.
     *
     * 출력 : M번째 환자는 몇 번째로 진료받는지 출력하세요.
     *
     * 예시 : 입력 - 5 2                출력 - 3
     *            60 50 70 80 90
     *       입력 - 6 3
     *            70 60 90 60 60 60  출력 - 4
     */
    static class Person {
        int idx;        // 순서
        int priority;   // 우선순위

        Person(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }

    }

    public static void solution(int[] p, int m) {
        int cnt = 1;
        Queue<Person> queue = new LinkedList<>();
        // 접수한 순서대로 환자를 큐에 삽입
        for (int i = 0; i < p.length; i++) {
            queue.add(new Person(i, p[i]));
        }

        while (!queue.isEmpty()) {
            // 대기목록 제일 상단에 있는 환자 추출
            Person poll = queue.poll();
            boolean isMedical = true;

            for (Person ps : queue) {
                // 제일 상단에 있는 환자의 우선순위보다 대기목록에 있는 환자의 우선순위가 높은 경우
                if (ps.priority > poll.priority) {
                    queue.offer(poll);  // 제일 상단에 있는 환자는 진료 받지 못하고, 대기목록 뒤에다 다시 삽입
                    isMedical = false;
                    break;
                }
            }
            // 제일 상단에 있는 환자가 진료를 받았다면
            if (isMedical) {
                // 제일 상단에 있는 환자의 idx가 m 번째 환자인지 확인
                if (poll.idx == m) {
                    // 진료받은 순서 출력
                    System.out.println(cnt);
                    return;
                } else {
                    // 진료받은 순서 값 증가
                    cnt++;
                }
            }
        }

        System.out.println(cnt);

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = in.nextInt();
        }

        solution(p, m);
    }
}
