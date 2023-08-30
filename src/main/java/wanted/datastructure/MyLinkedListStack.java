package main.java.wanted.datastructure;

import java.util.EmptyStackException;

class LinkedListStack<E> {
    private StackNode<E> top;
    public int size;
    LinkedListStack() {
        this.top = null;
    }
    // 스택의 맨 위에 원소를 삽입한다
    public void push(E data) {
        StackNode<E> newNode = new StackNode<>(data);
        newNode.next = top; // 기존 top 주소를 새 노드의 다음노드가 참조하도록 설정
        top = newNode;  // top 참조를 새 노드로 설정
        size++;
    }
    // 스택의 맨 위에 있는 원소를 반환한다. (반환 후에는 삭제한다.)
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        StackNode<E> removeNode = top;
        E oldData = removeNode.data;
        top = top.next;
        size--;

        return oldData;
    }
    // 스택의 맨 위에 있는 원소를 확인한다.
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        StackNode<E> topNode = top;
        return topNode.data;
    }
    // 스택이 비었는지 확인한다.
    public boolean isEmpty() {
        return top == null;
    }
    // 스택을 전부 비우기
    public void popAll() {
        top = null; // 참조가 사라진 객체는 GC에 의해서 제거 대상이 된다
    }
}

class StackNode<E> {
    public E data;
    public StackNode<E> next;
    StackNode(E data) {
        this.data = data;
        this.next = null;
    }
}

public class MyLinkedListStack {
    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();

        System.out.println("Is the stack empty? : " + stack.isEmpty());

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element is: " + stack.peek());
        System.out.println("Stack size after pushes: " + stack.size);

        System.out.println("Popped element: " + stack.pop());
        System.out.println("Top element after pop: " + stack.peek());

        stack.popAll();
        System.out.println("Is the stack empty after popAll? : " + stack.isEmpty());

        try {
            stack.pop();
        } catch (EmptyStackException e) {
            e.printStackTrace();
            System.out.println("Stack is Empty!!");
        }
    }
}
