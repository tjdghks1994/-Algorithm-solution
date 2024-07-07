package main.java.wanted.inflearn.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 멘토링 {
    /**
     * 문제 : 현수네 반 선생님은 반 학생들의 수학점수를 향상시키기 위해 멘토링 시스템을 만들려고 합니다.
     *       멘토링은 멘토(도와주는 학생)와 멘티(도움을 받는 학생)가 한 짝이 되어 멘토가 멘티의 수학공부를 도와주는 것입니다.
     *       선생님은 M번의 수학테스트 등수를 가지고 멘토와 멘티를 정합니다.
     *       만약 A 학생이 멘토이고, B 학생이 멘티가 되는 짝이 되었다면, A 학생은 M번의 수학테스트에서 모두 B 학생보다 등수가 앞서야 합니다.
     *       M번의 수학성적이 주어지면 멘토와 멘티가 되는 짝을 만들 수 있는 경우가 총 몇 가지 인지 출력하는 프로그램을 작성하세요.
     *
     * 입력 : 첫 번째 줄에 반 학생 수 N(1<=N<=20)과 M(1<=M<=10)이 주어진다.
     *       두 번째 줄부터 M개의 줄에 걸쳐 수학테스트 결과가 학생번호로 주어진다. 학생번호가 제일 앞에서부터 1등,2등,...N등 순으로 표현된다.
     *       만약 한 줄에 N=4이고, 테스트 결과가 3 4 1 2로 입력되었다면 3번학생이 1등, 4번학생이 2등, 1번학생이 3등, 2번학생이 4등을 의미합니다.
     *
     * 출력 : 첫 번째 줄에 짝을 만들 수 있는 총 경우를 출력합니다.
     *
     * 예시 : 입력 - 4 3            출력 - 3
     *            3 4 1 2
     *            4 3 2 1
     *            3 1 4 2
     */
    public static void solution(int[][] tdArr) {
        int pair = 0;
        for (int i = 1; i <= tdArr[0].length; i++) {        // 학생 번호
            for (int j = 1; j <= tdArr[0].length; j++) {    // 학생 번호
                int cnt = 0;
                for (int k = 0; k < tdArr.length; k++) {    // 테스트 회차
                    int poi = 0;    // (i,j) 일때 i의 등수
                    int poj = 0;    // (i,j) 일때 j의 등수
                    for (int s = 0; s < tdArr[k].length; s++) { // 등수
                        if (tdArr[k][s] == i) { // i의 등수를 저장
                            poi = s;
                        }
                        if (tdArr[k][s] == j) { // j의 등수를 저장
                            poj = s;
                        }
                    }
                    // 멘토, 멘티 가능한 조합이라 cnt 값 증가
                    if(poi < poj) cnt++;
                }
                // (i,j) 조합이 K번 회차 모두 멘토, 멘티가 가능한 조합이라면 cnt 값이 tdArr.length 값과 같다
                // pari 값 증가
                if(cnt == tdArr.length) pair++;
            }
        }
        // 멘토, 멘티 가능한 조합 수 출력
        System.out.println(pair);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] nmArr = in.nextLine().split(" ");
        int n = Integer.valueOf(nmArr[0]);  // 학생 수 (열)
        int m = Integer.valueOf(nmArr[1]);  // 테스트 수 (행)
        int[][] tdArr = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tdArr[i][j] = in.nextInt();
            }
        }

        solution(tdArr);
    }
}
