package main.java.wanted.inflearn.sortsearch;

import java.util.Arrays;
import java.util.Scanner;

public class 이분검색 {
    /**
     * 문제 : 임의의 N개의 숫자가 입력으로 주어집니다. N개의 수를 오름차순으로 정렬한 다음 N개의 수 중 한개의 수인 M이 주어지면
     *       이분검색으로 M이 정렬된 상태에서 몇 번째에 있는지 구하는 프로그램을 작성하세요.
     *       단 중복값은 존재하지 않습니다.
     *
     * 입력 : 첫 줄에 한 줄에 자연수 N(3<=N<=1,000,000)과 M이 주어집니다.
     *       두 번째 줄에 N개의 수가 공백을 사이에 두고 주어집니다.
     *
     * 출력 : 첫 줄에 정렬 후 M의 값의 위치 번호를 출력합니다.
     *
     * 예시 : 입력 - 8 32                       출력 - 3
     *            23 87 65 12 57 32 99 81
     */
    public static void solution(int m, int[] arr) {
        // 배열 오름차순 정렬
        Arrays.sort(arr);
        // 이분 검색
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int point = (left + right) / 2;

            if (m == arr[point]) {
                System.out.println(point+1);
                break;
            } else if (m > arr[point]) {
                left = point + 1;
            } else {
                right = point - 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        solution(m, arr);
    }
}
