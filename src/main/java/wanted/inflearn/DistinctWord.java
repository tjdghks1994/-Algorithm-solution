package main.java.wanted.inflearn;

import java.util.*;

public class DistinctWord {
    /**
     * 중복문자제거
     * 문제 : 소문자로 된 한 개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
     * 중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.
     * <p>
     * 입력 : 첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않는다.
     * <p>
     * 출력 : 첫 줄에 중복문자가 제거된 문자열을 출력합니다.
     * <p>
     * 예시 : 입력 - ksekkset   출력 - kset
     */

    public static void solution(String words) {
        // jdk 1.8 버전에서는 sb.isEmpty() 메서드가 존재하지 않음
//        if (sb.length() == 0) {
//            sb.append(word);
//        }
//
//        boolean isAlready = false;
//
//        for (int i = 0; i < sb.length(); i++) {
//            if (word == sb.charAt(i)) {
//                isAlready = true;
//            }
//        }
//
//        if (!isAlready) {
//            sb.append(word);
//        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length(); i++) {
            char ch = words.charAt(i);

            if (words.indexOf(ch) == i) {
                sb.append(ch);
            }
        }

        System.out.println(sb.toString());
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String words = in.next();
        solution(words);

//        char[] chars = words.toCharArray();
//        StringBuilder sb = new StringBuilder();
//
//        for (char ch : chars) {
//            solution(sb, ch);
//        }
//
//        System.out.println(sb.toString());
    }
}
