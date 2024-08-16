package main.java.wanted.baekjoon;

import java.util.Scanner;

public class P1978 {
    /**
     * 문제 : 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
     *
     * 입력 : 첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.
     *
     * 출력 : 주어진 수들 중 소수의 개수를 출력한다.
     *
     * 예시 : 입력 - 4          출력 - 3
     *            1 3 5 7
     */

    public static void main(String[] args) {
        // 소수 - 자기자신과 1만 약수로 가지고 있는 수
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i] == 1) continue;
            boolean disPrime = false;   // 소수가 아닌지에 대한 여부
            // 2부터 자기자신보다 이전 수 까지 반복
            for (int j = 2; j < arr[i]; j++) {
                // 나머지가 0으로 떨어지는 경우 소수가 아님
                if (arr[i] % j == 0) {
                    disPrime = true;    // 소수가 아니므로 true 설정
                    break;
                }
            }
            // 소수인 경우 카운트
            if(!disPrime) cnt++;
        }

        System.out.println(cnt);
    }
}
