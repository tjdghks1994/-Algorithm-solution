package main.java.wanted.datastructure;

class LinkedListQueue<E> {
    // 큐의 마지막 위치를 가리키는 포인터로서 Singly Circular Linked List에서 tail은 첫번째 노드에 접근이 가능하므로,
    // head를 참조하는 변수는 필요 없습니다.
    private QueueNode<E> tail;
    private int numberOfItems;  // 큐에 저장된 요소 개수

    public LinkedListQueue() {
        this.tail = null;
        numberOfItems = 0;
    }
    // 큐의 끝 위치에 원소 e를 삽입한다.
    public void enqueue(E data) {
        QueueNode<E> newNode = new QueueNode<>(data);
        if (tail == null) { // 첫 요소를 넣는 경우
            newNode.next = newNode; // 요소가 1개이므로 자기자신의 다음요소도 자기자신을 참조 (원형)
        } else {
            newNode.next = tail.next; // 새 노드의 다음 요소는 첫 노드가 되야하므로(원형,순환) 기존 tail의 다음 요소를 참조하도록 설정
            tail.next = newNode; // 기존 tail의 다음 요소 참조는 새 노드로 변경
        }
        tail = newNode; // tail의 참조는 새 노드로 변경
        numberOfItems++;
    }
    // 큐의 맨 앞에 위치한 원소를 반환하고 queue에서 제거한다.
    // Circular Singly Linked List에서는 tail 노드가 head(front) 노드를 참조하고 있다는 특징을 이용해서
    // 맨 앞 노드를 dequeue 할 수 있습니다.
    public E dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }
        QueueNode<E> frontNode = tail.next;
        E frontNodeData = frontNode.data;
        // 맨 앞 노드의 다음노드가 맨 앞노드가 되는 것이고
        // 기존 tail 노드의 next는 해당 노드를 참조하도록 해야한다
        // 만약 tail의 다음 노드가 자기자신을 참조하고 있는 경우라면 요소가 1개있는 상태이므로, tail=null로 설정해야한다
        if (tail == frontNode) {
            tail = null;
        } else {
            tail.next = frontNode.next;
        }
        numberOfItems--;

        return frontNodeData;
    }
    // 큐의 맨 앞에 위치한 원소를 반환한다.
    public E peek() {
        return tail.next.data;
    }
    // 큐가 비었는지 확인한다
    public boolean isEmpty() {
        return tail == null;
    }
    // 큐를 비운다
    public void dequeueAll() {
        tail = null;
    }
}
class QueueNode<E> {
    public E data;
    public QueueNode<E> next;

    public QueueNode(E data) {
        this.data = data;
        this.next = null;
    }

    public QueueNode(E data, QueueNode<E> next) {
        this.data = data;
        this.next = next;
    }
}

public class SinglyCircularLinkedListQueue {
    public static void main(String[] args) {
        LinkedListQueue<String> q = new LinkedListQueue<>();

        // Enqueue 테스트
        q.enqueue("One");
        q.enqueue("Two");
        q.enqueue("Three");
        q.enqueue("Four");
        q.enqueue("Five");

        // Peek 테스트
        System.out.println("Peek: " + q.peek()); // "One"이 출력될 것

        // Dequeue 테스트
        System.out.println("Dequeue: " + q.dequeue()); // "One"이 출력될 것
        System.out.println("Dequeue: " + q.dequeue()); // "Two"가 출력될 것
        System.out.println("Dequeue: " + q.dequeue()); // "Three"가 출력될 것

        // DequeueAll 테스트
        q.dequeueAll();
        System.out.println("After dequeueAll, is the queue empty?: " + q.isEmpty()); // true가 출력될 것

        // Queue Empty 테스트
        try {
            System.out.println("Dequeue: " + q.dequeue()); // 오류 발생 예상
        } catch (RuntimeException e) {
            System.out.println("Expected Exception: " + e.getMessage());
        }

        q.enqueue("Six");
        q.enqueue("Seven");
        System.out.println("Dequeue: " + q.dequeue()); // "Six"가 출력될 것
        System.out.println("Dequeue: " + q.dequeue()); // "Seven"가 출력될 것
        q.enqueue("One");
        System.out.println("Peek: " + q.peek()); // "One"이 출력될 것
    }
}
