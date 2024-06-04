package main.java.wanted.inflearn.string;

import java.util.Scanner;

public class ConvertWord {
    /**
     * 대소문자 변환
     * 문제 : 대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.
     * <p>
     * 입력 : 첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다.
     * 문자열은 영어 알파벳으로만 구성되어 있습니다.
     * 출력 : 첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력합니다.
     * <p>
     * 예시 : 입력 - StuDY  출력 - sTUdy
     */
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();

        for (char c : word.toCharArray()) {
//            if (c >= 65 && c <= 90) {
//                sb.append(Character.toLowerCase(c));
//            } else if (c >= 97 && c <= 122) {
//                sb.append(Character.toUpperCase(c));
//            }
            // 대문자
            if (Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            } else if (Character.isLowerCase(c)) {  // 소문자
                sb.append(Character.toUpperCase(c));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = in.next();

        System.out.println(solution(word));
    }
}
