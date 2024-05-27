package main.java.wanted.inflearn;

import com.mysql.cj.util.StringUtils;

import java.util.Scanner;

public class InvertedEratosthenes {
    /**
     * [뒤집은 소수]
     * 문제 : N개의 자연수가 입력되면 각 자연수를 뒤집은 후, 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.
     * 예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력한다.
     * 단, 910을 뒤집으면 19로 숫자화 해야 한다.
     * 첫 자리부터의 연속된 0은 무시한다.
     * <p>
     * 입력 : 첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고, 그 다음 줄에 N개의 자연수가 주어진다.
     * 각 자연수의 크기는 100,000를 넘지 않는다.
     * <p>
     * 출력 : 첫 줄에 뒤집은 소수를 출력합니다. 출력순서는 입력된 순서대로 출력합니다.
     * <p>
     * 예시 : 입력 - 9                                  출력 - 23 2 73 2 3
     *            32 55 62 20 250 370 200 30 100
     */

    public static void solution(int num) {
        String numStr = String.valueOf(num);
        char[] cArr = numStr.toCharArray();

        int lp=0;
        int rp = numStr.length() - 1;
        // 숫자 뒤집기
        while (lp < rp && lp != rp) {
            char tmp = numStr.charAt(lp);
            cArr[lp++] = cArr[rp];
            cArr[rp--] = tmp;
        }
        numStr = new String(cArr);
        // 뒤집은 수
        int invertNum = Integer.valueOf(numStr);

        // 2보다 작은 수는 소수가 아님
        if(invertNum < 2) return;

        for (int i = 2; i < invertNum; i++) {
            // 2~invertNum-1 까지 mod 연산의 값이 0이 있다면 소수가 아님
            if (invertNum % i == 0) {
                return;
            }
        }
        // 위 반복문을 모두 통과한 경우 소수이므로 출력
        System.out.print(invertNum + " ");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cnt = in.nextInt();
        int[] numArr = new int[cnt];

        for (int i = 0; i < cnt; i++) {
            numArr[i] = in.nextInt();
        }

        for (int num : numArr) {
            solution(num);
        }
    }
}
