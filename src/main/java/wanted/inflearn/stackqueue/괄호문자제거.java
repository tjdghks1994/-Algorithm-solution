package main.java.wanted.inflearn.stackqueue;

import java.util.Scanner;
import java.util.Stack;

public class 괄호문자제거 {
    /**
     * 문제 : 입력된 문자열에서 소괄호 () 사이에 존재하는 모든 문자를 제거하고, 남은 문자만 출력하는 프로그램을 작성하세요.
     * <p>
     * 입력 : 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
     * <p>
     * 출력 : 남은 문자만 출력한다.
     * <p>
     * 예시 : 입력 - (A(BC)D)EF(G(H)(IJ)K)LM(N)     출력 - EFLM
     */

    public static void solution(String str) {
        Stack<Character> stack = new Stack<>();
//        Stack<Character> result = new Stack<>();

        for (char ch : str.toCharArray()) {
            // 닫는 괄호가 나오면
            if (ch == ')') {
                // 여는 괄호가 나올 때 까지 스택 pop
                while (stack.peek() != '(') {
                    stack.pop();
                }
                stack.pop();    //  여는 괄호도 스택에서 pop
            } else {
                stack.push(ch);
            }
        }

        stack.stream().forEach((s) -> System.out.print(s));

//        while (!stack.isEmpty()) {
//            result.push(stack.pop());
//        }
//
//        while (!result.isEmpty()) {
//            System.out.print(result.pop());
//        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();

        solution(str);
    }
}
