package main.java.wanted.inflearn.array;

import java.util.Scanner;

public class VisibleStudent {
    /**
     * [보이는 학생]
     * 문제 : 선생님이 N명의 학생을 일렬로 세웠습니다. 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, 맨 앞에 서 있는
     *       선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요.
     *       ( 앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다. )
     *
     * 입력 : 첫 줄에 정수 N (5<=N<=100,000) 이 입력된다. 그 다음줄에 N명의 학생의 키가 앞에서부터 순서대로 주어진다.
     *
     * 출력 : 선생님이 볼 수 있는 최대학생 수를 출력한다.
     *
     * 예시 : 입력 - 8                                  출력 - 5
     *            130 135 148 140 145 150 150 153
     */

    public static void solution(int[] keyArr) {
        int visibleCnt = 1; // 볼 수 있는 최대학생 수 - 맨 앞에 서 있는 학생은 무조건 보임
        int maxKey = keyArr[0]; // 현재 가장 큰 키

//        for (int i = 1; i < keyArr.length; i++) {
//            boolean isVisible = false;
//            // 자기 자신의 앞쪽에 있는 모든 학생들을 비교
//            for (int j = i - 1; j >= 0; j--) {
//                if (keyArr[i] > keyArr[j]) {
//                    isVisible = true;
//                } else {
//                    isVisible = false;
//                    break;
//                }
//            }
//
//            if(isVisible) visibleCnt++;
//        }

        for (int i = 1; i < keyArr.length; i++) {
            if (keyArr[i] > maxKey) {
                visibleCnt++;
                maxKey = keyArr[i]; // 현재 가장 큰 키를 변경
            }
        }

        System.out.println(visibleCnt);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cnt = in.nextInt();
        int[] keyArr = new int[cnt];

        for (int i = 0; i < cnt; i++) {
            keyArr[i] = in.nextInt();
        }

        solution(keyArr);
    }
}
