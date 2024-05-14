package main.java.wanted.inflearn;

import java.util.Scanner;
import java.util.Stack;

public class FlipWorld {
    /**
     * 단어 뒤집기
     * 문제 : N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.
     * <p>
     * 입력 : 첫 줄에 자연수 N(3<=N<=20)이 주어집니다.
     * 두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.
     * <p>
     * 출력 : N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.
     * <p>
     * 예시 : 입력 - 3 good Time Big    출력 - doog emiT giB
     */

    public static void solution(String[] words) {
        Stack<String> st = new Stack<>();
        StringBuilder sb = null;

        for (int i = 0; i < words.length; i++) {
            sb = new StringBuilder();
            String word = words[i];

            for (int j = 0; j < word.length(); j++) {
                st.push(String.valueOf(word.charAt(j)));
            }

            while (!st.isEmpty()) {
                sb.append(st.pop());
            }

            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int cnt = in.nextInt();
        String[] words = new String[cnt];

        for (int i = 0; i < cnt; i++) {
            words[i] = in.next();
        }

        solution(words);
    }
}
