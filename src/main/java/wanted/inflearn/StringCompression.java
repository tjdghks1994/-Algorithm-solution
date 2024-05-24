package main.java.wanted.inflearn;

import java.util.Scanner;

public class StringCompression {
    /**
     * 문자열 압축
     * 문제 : 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우
     * 반복되는 문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
     * 단, 반복횟수가 1인 경우 생략합니다.
     * <p>
     * 입력 : 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않습니다.
     * <p>
     * 출력 : 첫 줄에 압축된 문자열을 출력한다.
     * <p>
     * 예시 : 입력 - KKHSSSSSSSE           출력 - K2HS7E
     * 입력 - KSTTTSEEKFKKKDJJGG    출력 - KST3SE2KFK3DJ2G2
     */

    public static void solution(String str) {
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();

        // 슬라이딩 윈도우 문제풀이 방법을 이용
        int lp = 0;
        int rp = 0;
        int cnt = 0;
        // 오른쪽 윈도우 포인터가 배열의 길이를 초과하지 않을 때 까지 반복
        while (rp < chars.length) {
            // 왼쪽 포인터의 문자 값과 오른쪽 포인터의 문자 값이 같으면
            // 갯수 증가, 오른쪽 포인터 증가
            if (chars[lp] == chars[rp]) {
                cnt++;
                rp++;
            } else {
                // 왼쪽 포인터의 문자 값과 오른쪽 포인터의 문자 값이 달라졌다면
                // 왼쪽 포인터의 문자를 sb에 추가
                sb.append(chars[lp]);
                // 만약 갯수가 1보다 크다면
                // 갯수 값도 sb에 추가
                if (cnt > 1) {
                    sb.append(cnt);
                }
                // 왼쪽 포인터를 오른쪽 포인터로 변경 (윈도우의 시작점 변경)
                lp = rp;
                // 갯수 초기화
                cnt = 0;
            }
        }
        // 마지막 문자에 대한 처리 추가
        sb.append(chars[lp]);
        if (cnt != 1) {
            sb.append(cnt);
        }
        // 출력
        System.out.println(sb);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        solution(str);
    }
}
