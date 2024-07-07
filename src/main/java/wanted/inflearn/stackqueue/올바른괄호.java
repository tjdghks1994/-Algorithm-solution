package main.java.wanted.inflearn.stackqueue;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class 올바른괄호 {
    /**
     * 문제 : 괄호가 입력되면 올바른 괄호이면 "YES", 올바르지 않으면 "NO"를 출력합니다.
     *       (())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.
     * <p>
     * 입력 : 첫 번째 줄에 괄호 문자열이 입력됩니다. 문자열의 최대 길이는 30이다.
     * <p>
     * 출력 : 첫 번째 줄에 YES, NO를 출력한다.
     * <p>
     * 예시 : 입력 - (()(()))(()    출력 - NO
     */

    public static void solution(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            // 여는 괄호라면 스택에 push
            if (ch == '(') {
                stack.push(ch);
            } else {    // 닫는 괄호라면 스택에서 pop
                try {
                    stack.pop();
                } catch (EmptyStackException e) {
                    // 여는 괄호가 없이 닫는 괄호가 나온 것이므로 올바르지 못한 괄호
                    System.out.println("NO");
                    return;
                }
            }
        }
        // 스택이 비어있다면 올바른 괄호
        if (stack.isEmpty()) {
            System.out.println("YES");
        } else {    // 비어있지 않다면 올바르지 않은 괄호
            System.out.println("NO");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        solution(str);
    }
}
