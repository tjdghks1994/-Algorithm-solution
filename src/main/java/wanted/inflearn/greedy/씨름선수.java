package main.java.wanted.inflearn.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 씨름선수 {
    /**
     * 문제 : 현수는 씨름 감독입니다. 현수는 씨름 선수를 선발공고를 냈고, N명의 지원자가 지원을 했습니다.
     *       현수는 각 지원자의 키와 몸무게 정보를 알고 있습니다.
     *       현수는 씨름 선수 선발 원칙을 다음과 같이 정했습니다.
     *       "A라는 지원자를 다른 모든 지원자와 일대일 비교해서 키와 몸무게 모두 A지원자 보다 높은(크고, 무겁다) 지원자가 존재하면
     *       A지원자는 탈락하고, 그렇지 않으면 선발된다."
     *       N명의 지원자가 주어지면 위의 선발원칙으로 최대 몇 명의 선수를 선발할 수 있는지 알아내는 프로그램을 작성하세요.
     *
     * 입력 : 첫째 줄에 지원자의 수 N(5<=N<=30,000)이 주어집니다.
     *       두 번째 줄부터 N명의 키와 몸무게 정보가 차례로 주어집니다.
     *       각 선수의 키가 모두 다르고, 몸무게도 모두 다릅니다.
     *
     * 출력 : 첫째 줄에 씨름선수로 뽑히는 최대 인원을 출력하세요.
     *
     * 예시 : 입력 -  5             출력 - 3
     *             172 67
     *             183 65
     *             180 70
     *             170 72
     *             181 60
     */
    static class Person implements Comparable<Person> {
        int height;
        int width;

        public Person(int height, int width) {
            this.height = height;
            this.width = width;
        }

        @Override
        public int compareTo(Person o) {
            return o.height-this.height;    // 키를 기준으로 내림차순 정렬
        }
    }

    // n의 값이 최대 30,000 이므로 이중 for 문으로 풀면 시간 초과
    // 정렬 후 for 문으로 풀이해야 함
    public static int solution(ArrayList<Person> pList, int n) {
        int cnt = 0;    //  선발 인원
        Collections.sort(pList);    // Comparable 기준에 의해 정렬

        int max = Integer.MIN_VALUE;    //  현재 몸무게 최대 값
        for (Person p : pList) {
            // 현재 최대 몸무게 보다 크다면
            if (p.width > max) {
                max = p.width;  // max 값 변경
                cnt++;          // 선발
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Person> pList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int height = in.nextInt();
            int width = in.nextInt();
            pList.add(new Person(height, width));
        }

        System.out.println(solution(pList, n));
    }

}
