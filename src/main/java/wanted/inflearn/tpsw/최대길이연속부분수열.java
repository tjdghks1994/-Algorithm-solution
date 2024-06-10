package main.java.wanted.inflearn.tpsw;

import java.util.Scanner;

public class 최대길이연속부분수열 {
    /**
     * 문제 : 0과 1로 구성된 길이가 N인 수열이 주어집니다.
     *       여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다.
     *       여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.
     *       만약 길이가 14인 다음과 같은 수열이 주어지고 k=2라면
     *       1 1 0 0 1 1 0 1 1 0 1 1 0 1
     *       여러분이 만들 수 있는 1이 연속된 연속부분수열은
     *       1 1 0 0 1 1 1 1 1 1 1 1 0 1
     *       이며 그 길이는 8 입니다.
     * <p>
     * 입력 : 첫 번째 줄에 수열의 길이인 자연수 N(5<=N<100,000)이 주어집니다.
     *       두 번째 줄에 N 길이의 0과 1로 구성된 수열이 주어집니다.
     * <p>
     * 예시 : 입력 -  14 2                          출력 - 8
     *              1 1 0 0 1 1 0 1 1 0 1 1 0 1
     */
    public static void solution(int[] arr, int k) {
        int answer = 0; // 최대 길이
        int cnt = 0;    // 0을 1로 변경한 갯수
        int lp = 0;     // 왼쪽 포인터
        // 오른쪽 포인터
        for (int rp = 0; rp < arr.length; rp++) {
            // 오른쪽 포인터가 가리키는 배열 원소의 값이 0이라면 1로 변경했다고 가정하고 cnt 값을 증가
            if (arr[rp] == 0) {
                cnt++;
            }
            // cnt 값이 k번을 초과하는 경우 반복
            while (cnt > k) {
                // 왼쪽 포인터가 가리키는 배열 원소의 값이 0이라면
                // 오른쪽 포인터가 변경한 1의 값을 다시 0으로 변경했다고 가정하고 cnt 값을 감소
                if (arr[lp] == 0) {
                    cnt--;
                }
                lp++;   // 왼족 포인터 값은 증가
            }
            // 현재 저장되있는 최대 길이 값과 현재 길이를 비교 후 더 큰 값을 저장
            // 현재 길이는 오른쪽 포인터 - 왼쪽 포인터 + 1 을 하면 된다
            answer = Math.max(answer, rp - lp + 1);
        }

        System.out.println(answer);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = in.nextInt();
        }

        solution(arr, k);
    }
}
