package main.java.wanted.inflearn.sortsearch;

import java.util.Arrays;
import java.util.Scanner;

public class 버블정렬 {
    /**
     * 문제 : N개의 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
     *       정렬하는 방법은 버블정렬입니다.
     *
     * 입력 : 첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
     *       두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다.
     *       각 자연수는 정수형 범위 안에 있습니다.
     *
     * 출력 : 오름차순으로 정렬된 수열을 출력합니다.
     *
     * 예시 : 입력 - 6                  출력 -  5 7 11 13 15 23
     *            13 5 11 7 23 15
     */

    public static void solution(int[] arr) {

        // 버블 정렬의 오름차순은 큰 숫자부터 (뒤의 인덱스부터) 정렬되어진다
        for (int i = arr.length - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {
                // 인접한 두 수중 앞의 수가 뒤의 수보다 큰 경우
                // 자리 바꿈
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        solution(arr);
    }
}
