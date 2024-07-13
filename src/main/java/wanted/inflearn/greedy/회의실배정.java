package main.java.wanted.inflearn.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 회의실배정 {

    /**
     * 문제 : 한 개의 회의실이 있는데 이를 사용하고자 하는 n개의 회의들에 대하여 회의실 사용표를 만들려고 한다.
     *       각 회의에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 최대수의 회의를 찾아라.
     *       단, 회의는 한번 시작하면 중간에 중단될 수 없으며, 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
     *
     * 입력 : 첫째 줄에 회의의 수 n(1<=n<=100,000)이 주어진다. 둘째 줄부터 n+1 줄까지 각 회의의 정보가 주어지는데
     *       이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 회의시간은 0시부터 시작한다.
     *       회의의 시작시간과 끝나는 시간의 조건은 (시작시간 <= 끝나는 시간)입니다.
     *
     * 출력 : 첫째 줄에 최대 사용할 수 있는 회의 수를 출력하여라.
     *
     * 예시 : 입력 - 5          출력 - 3
     *            1 4
     *            2 3
     *            3 5
     *            4 6
     *            5 7
     *
     *      입력 - 3          출력 - 2
     *           3 3
     *           1 3
     *           2 3
     */
    static class Time implements Comparable<Time> {
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
            int result = this.end - o.end;

            if (result == 0) {
                result = this.start - o.start;
            }

            return result;
        }
    }

    public static int solution(ArrayList<Time> tList, int n) {
        int cnt = 0;
        Collections.sort(tList);    // 끝나는 시간으로 오름차순 정렬, 끝나는 시간이 같으면 시작하는 시간으로 오름차순 정렬

        int endTime = Integer.MIN_VALUE;
        for (Time t : tList) {
            if (t.start >= endTime) {
                endTime = t.end;
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Time> tList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            tList.add(new Time(start, end));
        }

        System.out.println(solution(tList, n));
    }
}
