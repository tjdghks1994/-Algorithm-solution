package main.java.wanted.datastructure;

class CircularQueue<E> {
    private E[] queue;  // 큐의 원소들이 저장될 배열
    private int front;  // 큐의 제일 앞 원소 index
    private int rear;   // 큐의 제일 마지막 원소 index
    private int numberOfItems;  // 큐 원소 개수
    private int capacity;   // 큐의 초기용량

    public CircularQueue() {
        this(10);
    }
    public CircularQueue(int capacity) {
        front = rear = -1;
        numberOfItems = 0;
        this.capacity = capacity;
        queue = (E[]) new Object[capacity];
    }

    // enqueue(e) - 큐의 끝 위치에 원소 e를 삽입합니다.
    public void enqueue(E data) {
        if (isFull()) {
            throw new RuntimeException("Queue is Full");
        }
        if (front == -1) {  // 제일 처음 원소가 삽입된 경우
            front = 0;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = data;
        numberOfItems++;
    }
    // dequeue() - 큐의 맨 앞에 위치한 원소 (가장 먼저 들어온 원소)를 반환하고 queue에서 제거합니다.
    public E dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }

        E oldData = queue[front];
        queue[front] = null;
        if (front == rear && numberOfItems == 1) {    // 마지막 남은 요소를 제거한 경우
            front = rear = -1;
        } else {
            front = (front + 1) % capacity;
        }
        numberOfItems--;

        return oldData;
    }

    // peek() - 큐의 맨 앞에 위치한 원소를 반환한다.
    public E peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }
        return queue[front];
    }

    // isEmpty() - 큐가 비었는지 확인한다.
    public boolean isEmpty() {
        return numberOfItems == 0;
    }
    // isFull() - 큐가 가득 찼는지 확인한다.
    public boolean isFull() {
        return numberOfItems == capacity;
    }
    public void dequeueAll() {
        queue = (E[]) new Object[capacity];
        front = rear = -1;
        numberOfItems = 0;
    }
    public int queueSize() {
        return capacity;
    }
}

public class CircularArrayQueue {
    public static void main(String[] args) {
        CircularQueue<String> q = new CircularQueue<>(5); // capacity 5인 String Queue를 생성

        // Enqueue 테스트
        q.enqueue("One");
        q.enqueue("Two");
        q.enqueue("Three");
        q.enqueue("Four");
        q.enqueue("Five");

        // Queue Full 테스트
        try {
            q.enqueue("Six"); // 오류 발생 예상
        } catch (RuntimeException e) {
            System.out.println("Expected Exception: " + e.getMessage());
        }

        // Peek 테스트
        System.out.println("Peek: " + q.peek()); // "One"이 출력될 것

        // Dequeue 테스트
        System.out.println("Dequeue: " + q.dequeue()); // "One"이 출력될 것
        System.out.println("Dequeue: " + q.dequeue()); // "Two"가 출력될 것
        System.out.println("Dequeue: " + q.dequeue()); // "Three"가 출력될 것
        System.out.println("Dequeue: " + q.dequeue()); // "Four"가 출력될 것
        System.out.println("Dequeue: " + q.dequeue()); // "Five"가 출력될 것
        System.out.println("After dequeueAll, is the queue empty?: " + q.isEmpty()); // true가 출력될 것

        // Queue Empty 테스트
        try {
            System.out.println("Dequeue: " + q.dequeue()); // 오류 발생 예상
        } catch (RuntimeException e) {
            System.out.println("Expected Exception: " + e.getMessage());
        }

        // Queue 비운뒤, Enqueue 테스트
        q.enqueue("Hi");
        q.enqueue("Hi2");
        q.enqueue("Hi3");
        System.out.println("Peek: " + q.peek());
        System.out.println("queue size = " + q.queueSize());

        // DequeueAll 테스트
        q.dequeueAll();
        System.out.println("After dequeueAll, is the queue empty?: " + q.isEmpty()); // true가 출력될 것
        // Queue Empty 테스트
        try {
            System.out.println("Dequeue: " + q.dequeue()); // 오류 발생 예상
        } catch (RuntimeException e) {
            System.out.println("Expected Exception: " + e.getMessage());
        }
    }
}
