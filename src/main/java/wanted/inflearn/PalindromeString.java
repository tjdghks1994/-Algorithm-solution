package main.java.wanted.inflearn;

import java.util.Scanner;

public class PalindromeString {
    /**
     * 회문 문자열
     * 문제 : 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
     * 문자열이 입력되면 해당 문자열이 회문 문자열이라면 "YES", 회문 문자열이 아니면 "NO"를 출력하는 프로그램을 작성하세요.
     * 단, 회문을 검사할 때 대소문자를 구부낳지 않습니다.
     * <p>
     * 입력 : 첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.
     * <p>
     * 출력 : 첫 번째 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다.
     * <p>
     * 예시 : 입력 - gooG   출력 - YES
     */

    public static void solution(String str) {
//        int lp = 0;
//        int rp = str.length() - 1;
//        str = str.toUpperCase();
//        char[] chars = str.toCharArray();
//
//        while (lp < rp) {
//            if (chars[lp] != chars[rp]) {
//                System.out.println("NO");
//                return;
//            }
//
//            lp++;
//            rp--;
//        }
//
//        System.out.println("YES");
        StringBuilder sb = new StringBuilder(str);
        String tmp = sb.reverse().toString();

        if (str.equals(tmp)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        solution(str);
    }
}
