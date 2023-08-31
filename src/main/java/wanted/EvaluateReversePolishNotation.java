package main.java.wanted;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    /**
     * 역폴란드 표기법(후위 표현식)으로 산술 표현식을 나타내는 문자열 토큰 배열이 제공됩니다.
     * 표현을 평가해 보세요. 표현식의 값을 나타내는 정수를 반환합니다.*
     *
     * 참고 사항 :
     * 유효한 연산자는 '+', '-', '*' 및 '/'입니다.
     * 각 피연산자는 정수이거나 다른 표현식일 수 있습니다.
     * 두 정수 사이의 나눗셈은 항상 0을 향해 잘립니다.
     * 0으로 나누는 일은 없을 것입니다.
     * 입력은 역방향 폴란드어 표기법으로 유효한 산술 표현식을 나타냅니다.
     * 답과 모든 중간 계산은 32비트 정수로 표현될 수 있습니다.
     *
     * 예시 1 :
     * Input: tokens = ["2","1","+","3","*"]
     * Output: 9
     * Explanation: ((2 + 1) * 3) = 9
     *
     * 예시 2 :
     * Input: tokens = ["4","13","5","/","+"]
     * Output: 6
     * Explanation: (4 + (13 / 5)) = 6
     */
    public static int evalRPN(String[] tokens) {
        // 후위표현식으로 제공된 문자열을 중위표현식으로 값을 계산하면 된다
        // 후위표현식은 연산자를 두 피연산자의 뒤에 위치시키는 표기법이므로
        // 후위표현식으로 제공된 문자열을 중위표현식으로 변경하여 값을 계산하는 방법으로는
        // 문자열의 피연산자를 보관할 스택을 선언하여, 해당 스택에는 피연산자를 보관하고
        // 연산자가 나오면 피연산자를 보관하는 스택의 값을 2개 pop()하여 산술연산을 하면 된다.
        // 위 과정을 tokens 요소 갯수만큼 반복한다

        // 피연산자 보관 스택 선언
        // for(i=0; i<tokens.length; i++)
        //      if(tokens[i]가 피연산자)
        //          피연산자 스택 push()
        //      else - tokens[i]가 연산자
        //          피연산자 스택 pop() - 피연산자1
        //          피연산자 스택 pop() - 피연산자2
        //          피연산자2 연산자 피연산자1 -> 산술연산 진행
        //          위 연산된 값을 다시 피연산자 스택에 push()

        // 반복문 종료 후 최종적으로 피연산자 스택에는 1개의 요소만 남으므로
        // 해당 값을 pop() 하여 값 반환 처리

        Stack<Integer> numStack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            // token이 연산자인 경우
            if (token.equals("+") || token.equals("-") || token.equals("/") || token.equals("*")) {
                int result = operation(numStack, token);
                numStack.push(Integer.valueOf(result));
            } else { // token이 피연산자인 경우
                numStack.push(Integer.valueOf(token));
            }
        }

        return numStack.pop();
    }

    public static int operation(Stack<Integer> numStack, String token) {
        int result = 0;
        int num1 = numStack.pop();
        int num2 = numStack.pop();

        switch (token) {
            case "+":
                result = num2 + num1;
                break;
            case "-":
                result = num2 - num1;
                break;
            case "/":
                result = num2 / num1;
                break;
            case "*":
                result = num2 * num1;
                break;
            default :
                throw new RuntimeException("token is not operator");
        }

        return result;
    }

    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens));

        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(tokens2));

    }
}
