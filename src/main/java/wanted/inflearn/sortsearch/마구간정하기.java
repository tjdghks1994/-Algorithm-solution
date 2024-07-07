package main.java.wanted.inflearn.sortsearch;

import java.util.Arrays;
import java.util.Scanner;

public class 마구간정하기 {
    /**
     * 문제 : N개의 마구간이 수직선상에 있습니다. 각 마구간은 x1, x2, x3, ...., xN 의 좌표를 가지며, 마구간 간에 좌표가 중복되는 일은 없습니다.
     *       현수는 C 마리의 말을 가지고 있는데, 이 말들은 서로 가까이 있는 것을 좋아하지 않습니다.
     *       각 마구간에는 한 마리의 말만 넣을 수 있고, 가장 가까운 두 말의 거리가 최대가 되게 말을 마구간에 배치하고 싶습니다.
     *       C 마리의 말을 N개의 마구간에 배치했을 때, 가장 가까운 두 말의 거리가 최대가 되는 그 최대값을 출력하는 프로그램을 작성하세요.
     *
     * 입력 : 첫 줄에 자연수 N(3<=N<=200,000)과 C(2<=C<=N)이 공백을 사이에 두고 주어집니다.
     *       둘째 줄에 마구간의 좌표 xi(0<=xi<=1,000,000,000)가 차례로 주어집니다.
     *
     * 출력 : 첫 줄에 가장 가까운 두 말의 최대 거리를 출력하세요.
     *
     * 예시 : 입력 - 5 3            출력 - 3
     *            1 2 8 4 9
     */

    // 최대 거리가 distance 일 때, 총 배치할 수 있는 말의 수를 반환하는 함수
    public static int count(int distance, int[] arr) {
        int cnt = 1;        // 배치된 말의 수
        int ep = arr[0];    // 마지막 배치된 말의 좌표 값

        for (int i : arr) {
            // 현재 말의 좌표 - 마지막 배치된 말의 좌표 값을 뺀 값이 distance (최대 거리) 값 보다 큰 경우 현재 말은 배치가 가능한 말
            if (i - ep >= distance) {
                cnt++;          // 배치가 완료된 말이므로 카운트 증가
                ep = i;    // 마지막 배치된 말의 좌표 값을 현재 말의 좌표로 변경
            }
        }

        return cnt;
    }

    public static void solution(int c, int[] arr) {
        int answer = 0; //  최대 거리
        // 배열 정렬
        Arrays.sort(arr);

        int lt = 1; // 최대거리는 1부터
        int rt = arr[arr.length - 1];   // 배열의 마지막 원소

        while (lt <= rt) {
            int mid = (lt + rt) / 2;    // 최대 거리를 지정
            // 최대 거리가 mid 값일 때, 총 배치할 수 있는 말의 수가 c 보다 크거나 같으면 가능
            if (count(mid, arr) >= c) {
                answer = mid;
                lt = mid + 1;
            } else {    // 최대 거리가 mid 값일 때, 총 배치할 수 있는 말의 수가 c 보다 작으면 불가능한 거리
                rt = mid - 1;
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        solution(c, arr);
    }
}
