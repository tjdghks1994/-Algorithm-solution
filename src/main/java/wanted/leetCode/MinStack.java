package main.java.wanted.leetCode;

import java.util.Stack;

/**
 * 푸시, 팝, 상단 및 일정한 시간에 최소 요소 검색을 지원하는 스택을 설계합니다.
 * MinStack 클래스를 구현합니다.
 *
 * MinStack()은 스택 개체를 초기화합니다.
 * void push(int val)는 val 요소를 스택에 푸시합니다.
 * void pop()은 스택의 맨 위에 있는 요소를 제거합니다.
 * int top()은 스택의 최상위 요소를 가져옵니다.
 * int getMin()은 스택의 최소 요소를 검색합니다.
 * 각 기능에 대해 O(1) 시간 복잡도를 갖는 솔루션을 구현해야 합니다.
 *
 * 예시 1
 * 입력
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 출력
 * [null,null,null,null,-3,null,0,-2]
 *
 * 설명
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 */

public class MinStack {
    private Stack<Integer> integerStack; // 데이터를 저장할 스택
    private Stack<Integer> minNumStack; // 최소값을 저장할 스택

    public MinStack() {
        integerStack = new Stack<>();
        minNumStack = new Stack<>();
    }
    // val 요소를 스택에 푸시합니다.
    public void push(int val) {
        integerStack.push(Integer.valueOf(val));
        minNumPush(val); // 최소값을 보관할 스택에 요소 저장
    }
    // 스택의 맨 위에 있는 요소를 제거합니다.
    public void pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        integerStack.pop();
        minNumPop(); // 최소값을 보관할 스택의 요소 삭제
    }
    // 스택의 최상위 요소를 가져옵니다.
    public int top() {
        return integerStack.peek();
    }
    // 스택의 최소 요소를 검색합니다.
    public int getMin() {
        return minNumStack.peek();
    }
    // 스택이 비었는지 체크
    public boolean isEmpty() {
        return integerStack.isEmpty();
    }
    // 최소값을 보관할 스택에 요소 저장
    private void minNumPush(int val) {
        // 최소값을 보관하는 스택이 비어있다면 전달받은 val는 무조건 최소값을 의미
        if (minNumStack.isEmpty()) {
            minNumStack.push(val);
        } else {
            int currentMin = minNumStack.peek().intValue();
            // 최소값을 보관하는 스택의 가장 최근에 저장된 값이 새로 저장된 val 보다 큰 경우
            // 최소값 스택에 val를 push()
            if (currentMin > val) {
                minNumStack.push(Integer.valueOf(val));
            } else {    /// 그게 아니라면 이전 최소값을 push()
                minNumStack.push(currentMin);
            }
        }
    }
    // 최소값을 보관할 스택의 요소 삭제
    private void minNumPop() {
        minNumStack.pop();
    }
}
