package main.java.wanted.inflearn.dynamic;

import java.util.ArrayList;
import java.util.Scanner;

public class 최대부분증가수열 {
    /**
     * 문제 : N개의 자연수로 이루어진 수열이 주어졌을 때, 그 중에서 가장 길게 증가하는(작은 수에서 큰 수로) 원소들의 집합을 찾는 프로그램을 작성하라.
     *       예를 들어, 원소가 2, 7, 5, 8, 6, 4, 7, 12, 3 이면 가장 길게 증가하도록 원소들을 차례대로 뽑아내면 2, 5, 6, 7, 12를 뽑아내어
     *       길이가 5인 최대 부분 증가수열을 만들 수 있다.
     *
     * 입력 : 첫째 줄은 입력되는 데이터의 수 N(3<=N<=1,000, 자연수)를 의미하고,
     *       둘째 줄은 N개의 입력 데이터들이 주어진다.
     *
     * 출력 : 첫 번째 줄에 부분증가수열의 최대 길이를 출력한다.
     *
     * 예시 : 입력 - 8                  출력 - 4
     *            5 3 7 8 6 2 9 4
     */

    static int[] dy;    // index 에 해당하는 값을 마지막 항으로 했을 때 부분증가수열의 최대 길이를 담는 배열

    public static void solution(int[] arr) {
        int answer = 0;
        dy[0] = 1;  // 첫번째 index 는 최대 길이를 1로 설정

        for (int i = 1; i < arr.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {  // i 인덱스 보다 앞의 원소들을 비교
                // i 인덱스보다 값이 작으면서, j 인덱스의 최대 길이가 max 값보다 큰 경우
                if (arr[j] < arr[i] && dy[j] > max) {
                    // max 를 dy[j] 값으로 변경
                    max = dy[j];
                }
            }
            // max 에 + 자기자신 1을 더함
            dy[i] = max + 1;
            answer = Math.max(answer, dy[i]);
        }

        System.out.println(answer);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        dy = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        solution(arr);
    }
}
