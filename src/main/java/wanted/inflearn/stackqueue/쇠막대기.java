package main.java.wanted.inflearn.stackqueue;

import java.util.Scanner;
import java.util.Stack;

public class 쇠막대기 {
    /**
     * 문제 : 여러 개의 쇠막대기를 레이저로 절단하려고 한다. 효율적인 작업을 위해서 쇠막대기를 아래에서 위로 겹쳐 놓고,
     *       레이저를 위에서 수직으로 발사하여 쇠막대기들을 자른다. 쇠막대기와 레이저의 배치는 다음 조건을 만족한다.
     *       - 쇠막대기는 자신보다 긴 쇠막대기 위에만 놓일 수 있다.
     *       - 쇠막대기를 다른 쇠막대기 위에 놓는 경우 완전히 포함되도록 놓되, 끝점은 겹치지 않도록 놓는다.
     *       - 각 쇠막대기를 자르는 레이저는 적어도 하나 존재한다.
     *       - 레이저는 어떤 쇠막대기의 양 끝점과도 겹치지 않는다.
     *       이러한 레이저와 쇠막대기의 배치는 다음과 같이 괄호를 이용하여 왼쪽부터 순서대로 표현할 수 있다.
     *       1. 레이저는 여는 괄호와 닫는 괄호의 인접한 쌍'()'으로 표현된다. 또한 모든'()'는 반드시 레이저를 표현한다.
     *       2. 쇠막대기의 왼쪽 끝은 여는 괄호'('로, 오른쪽 끝은 닫힌 괄호')'로 표현된다.
     *       쇠막대기는 레이저에 의해 몇 개의 조각으로 잘려지는데, 쇠막대기와 레이저의 배치를 나타내는 괄호 표현이 주어졌을 때
     *       잘려진 쇠막대기 조각의 총 개수를 구하는 프로그램을 작성하세요.
     *
     * 입력 : 한 줄에 쇠막대기와 레이저의 배치를 나타내는 괄호 표현이 공백없이 주어진다. 괄호 문자의 개수는 최대 100,000이다.
     *
     * 출력 : 잘려진 조각의 총 개수를 나타내는 정수를 한 줄에 출력한다.
     *
     * 예시 : 입력 - ()(((()())(())()))(())         출력 - 17
     *       입력 - (((()(()()))(())()))(()())     출력 - 24
     */

    public static void solution(String str) {
        int slice = 0;
        Stack<Character> brackets = new Stack<>();
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {    // 여는 괄호
                brackets.push(chars[i]);
            } else {    // 닫는 괄호
                brackets.pop(); // 스택에서 상단 괄호 제거
                // 이전 괄호가 무엇인지 확인
                char prevBracket = chars[i - 1];
                // 이전 괄호가 여는 괄호라면 레이저
                if (prevBracket == '(') {
                    // 레이저로 잘라야되므로 현재 스택에 쌓인 괄호 갯수만큼 쇠막대기 왼쪽에 조각 남
                    slice += brackets.size();
                } else {    // 이전 괄호가 닫는 괄호라면 나무막대
                    // 나무막대의 끝이므로 잘려나서 남은 조각 추가
                    slice++;
                }
            }
        }

        System.out.println(slice);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();

        solution(str);
    }
}
