package main.java.wanted;

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

public class MyMinStack {
    private Node<Integer> top;  // 스택의 최상위 요소를 참조
    private Stack<Integer> minStack = new Stack<>(); // 최소값을 보관할 스택

    public MyMinStack() {
        top = null;
    }
    // val 요소를 스택에 푸시합니다.
    public void push(int val) {
        Node<Integer> newNode = new Node<>(Integer.valueOf(val));
        newNode.next = top; // 새 노드의 다음 노드는 현재 top 주소를 참조하도록 설정
        top = newNode; // 스택의 최상위 요소는 새 노드 주소를 참조하도록 설정
        minPush(val); // 최소값을 보관하는 스택에 푸시
    }
    // 스택의 맨 위에 있는 요소를 제거합니다.
    public void pop() {
        top = top.next; // 최상위 노드의 다음노드는 스택의 최상위 요소의 하위 요소를 의미하므로, 해당 요소를 top가 참조하도록 설정
        minStack.pop(); // 최소값을 보관하는 스택 요소도 제거
    }
    // 스택의 최상위 요소를 가져옵니다.
    public int top() {
        return top.data;
    }
    // 스택의 최소 요소를 검색합니다.
    public int getMin() {
        return minStack.peek();
    }
    // 스택이 비었는지 체크
    public boolean isEmpty() {
        return top==null;
    }
    // 최소값을 보관하는 스택에 푸시
    public void minPush(int val) {
        if (minStack.isEmpty()) {
            minStack.push(Integer.valueOf(val));
        } else {
            int currentMin = minStack.peek().intValue();
            if (currentMin > val) { // 현재 최소값이 전달된 val보다 큰 경우, 최소값을 보관하는 스택에 val를 저장
                minStack.push(val);
            } else { // 현재 최소값이 val보다 작은 경우, 최소값을 보관하는 스택에 현재 최소값 저장
                minStack.push(currentMin);
            }
        }
    }

    class Node<E> {
        public E data;
        public Node<E> next;

        public Node(E data) {
            this.data = data;
            next = null;
        }
    }
}
