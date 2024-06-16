package main.java.wanted.inflearn.stackqueue;

import java.util.Scanner;
import java.util.Stack;

public class 후위식연산 {
    /**
     * 문제 : 후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.
     *       만약 3*(5+2)-9 를 후위연산식으로 표현하면 352+*9-로 표현되며 그 결과는 12입니다.
     *
     * 입력 : 첫 줄에 후위연산식이 주어집니다. 연산식의 길이는 50을 넘지 않습니다.
     *       식은 1~9의 숫자와 +,-,*,/ 연산자로만 이루어집니다.
     *
     * 출력 : 연산한 결과를 출력합니다.
     *
     * 예시 : 입력 - 352+*9-        출력 - 12
     */

    public static void solution(String postfix) {
        char[] post = postfix.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int calcNum = 0;

        for (char ch : post) {
            // 숫자인지 판단
            boolean isDigit = Character.isDigit(ch);
            if (isDigit) {
                // 숫자인 경우 스택에 저장
                // 숫자 0~9 아스키코드 값은 48~57
                stack.push(ch - 48);
            } else {
                // 연산자인 경우 2개의 숫자를 스택에서 꺼내 연산하는데
                // 먼저 꺼낸 피연산자가 뒤로 연산
                int num2 = stack.pop();
                int num1 = stack.pop();

                switch (ch) {
                    case '+' :
                        calcNum = num1 + num2;
                        stack.push(calcNum);    // 연산 완료된 값을 다시 스택에 저장
                        break;
                    case '-' :
                        calcNum = num1 - num2;
                        stack.push(calcNum);    // 연산 완료된 값을 다시 스택에 저장
                        break;
                    case '*' :
                        calcNum = num1 * num2;
                        stack.push(calcNum);    // 연산 완료된 값을 다시 스택에 저장
                        break;
                    case '/':
                        calcNum = num1 / num2;
                        stack.push(calcNum);    // 연산 완료된 값을 다시 스택에 저장
                        break;
                    default:
                        break;
                }
            }
        }
        // 후위식 연산 값 출력
        System.out.println(calcNum);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String postfix = in.next();

        solution(postfix);
    }
}
