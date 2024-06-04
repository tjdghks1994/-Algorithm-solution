package main.java.wanted.inflearn.string;

import java.util.Scanner;

public class ValidPalindrome {
    /**
     * 유효한 팰린드롬
     * 문제 : 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 팰린드롬이라고 합니다.
     * 문자열이 입력되면 해당 문자열이 팰린드롬이면 "YES", 아니면 "NO"를 출력하는 프로그램을 작성하세요.
     * 단, 회문을 검사할 때 알파벳만 가지고 회문을 검사하며, 대소문자를 구분하지 않습니다.
     * 알파벳 이외의 문자들은 무시합니다.
     * <p>
     * 입력 : 첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.
     * <p>
     * 출력 : 첫 번째 줄에 팰린드롬인지의 결과를 "YES" 또는 "NO" 로 출력합니다.
     * <p>
     * 예시 : 입력 - found7, time: study; Yduts; emit, 7Dnuof   출력 - YES
     */

    public static void solution(String str) {
        // 알파벳이 아닌 문자열은 전부 ""로 치환해서 없애기
        String tmp = str.toUpperCase().replaceAll("[^A-Z]", "");

        int lp = 0;
        int rp = tmp.length() - 1;
        char[] chars = tmp.toCharArray();

        while (lp < rp) {
            // 비교대상이 서로 다른 문자열이라면 회문이 아니므로 NO 출력 후 메소드 종료
            if (chars[lp] != chars[rp]) {
                System.out.println("NO");
                return;
            }
            lp++;
            rp--;
        }
        // 반복문이 정상적으로 종료되었다면 회문이므로 YES 출력
        System.out.println("YES");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        solution(str);
    }
}
