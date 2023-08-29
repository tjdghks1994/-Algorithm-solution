package main.java.wanted.datastructure;

import java.util.EmptyStackException;

class ArrayStack<E> {
    private E[] stack;  // 데이터를 저장할 배열
    private int top;    // top을 가리키는 index
    private int capacity;   // stack 용량

    ArrayStack() {
        stack = (E[]) new Object[5];
        top = -1;
        capacity = 5;
    }
    ArrayStack(int capacity) {
        stack = (E[]) new Object[capacity];
        top = -1;
        this.capacity = capacity;
    }

    void push(E element) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        stack[++top] = element;
    }

    E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E popElement = stack[top];
        stack[top--] = null;

        return popElement;
    }

    E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[top];
    }

    boolean isEmpty() {
        return top < 0;
    }

    boolean isFull() {
        return top == (capacity - 1);
    }
}

public class MyArrayStack {
    public static void main(String[] args) {
        ArrayStack<String> stringArrayStack = new ArrayStack<>();
        stringArrayStack.push("hello");
        stringArrayStack.push("hi");
        stringArrayStack.push("test");

        for (int i = 1; i < 3; i++) {
            System.out.println(stringArrayStack.pop());
        }
//        System.out.println(stringArrayStack.pop());

        ArrayStack<Integer> integerArrayStack = new ArrayStack<>(6);
        for (int i = 1; i <= 6; i++) {
            integerArrayStack.push(i);
        }
//        integerArrayStack.push(7);
        for (int i = 1; i <= 6; i++) {
            System.out.println(integerArrayStack.pop());
        }
    }
}
