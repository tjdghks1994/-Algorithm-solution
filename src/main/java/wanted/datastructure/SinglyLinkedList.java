package main.java.wanted.datastructure;

/**
 * Singly Linked List는 head, tail 참조를 갖는 구조로 만든다. (한 방향으로만 연결된 구조)조
 * 마지막 요소 (tail)를 참조하는 포인터를 가지고 있어야
 * 마지막 요소에 값을 추가하는 시간복잡도가 O(n)이 아니라 O(1)로 만들 수 있다.
 */
class SingleLinkedList<E> {
    private Node<E> head;   // 연결 리스트의 처음 요소를 참조
    private Node<E> tail;   // 연결 리스트의 마지막 요소를 참조
    private int size = 0;   // 연결 리스트의 요소 갯수

    public SingleLinkedList() {
        this.head = null;
        this.tail = null;
    }
    // 연결 리스트 맨 앞에 요소 추가
    public void addFirst(E data) {
        Node<E> newNode = new Node<>(data, null);

        if (head == null) { // 처음 요소가 존재하지 않는 경우 (연결 리스트의 요소가 없다는 것을 의미)
            head = newNode;
            tail = newNode;
        } else {
            // 새 노드가 기존 head를 다음 노드로 참조하도록 설정
            newNode.next = head;
            head = newNode; // head가 새 노드를 참조하도록 변경
        }
        size++;
    }
    // 연결 리스트 맨 마지막에 요소 추가
    public void addLast(E data) {
        Node<E> newNode = new Node<>(data, null);

        if (tail == null) { // 연결 리스트의 마지막 요소가 존재하지 않는 경우 (연결 리스트의 요소가 없다는 것을 의미)
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;    // 기존 tail노드의 다음노드를 새 노드로 지정
            tail = newNode; // tail이 새 노드를 참조하도록 변경
        }
        size++;
    }
    // 특정 위치에 요소를 추가
    public void add(int index, E data) {
        if (index == 0) {   // 삽입하려는 위치가 첫번째
            addFirst(data);
        } else if (index == size - 1) { // 삽입하려는 위치가 마지막
            addLast(data);
        } else {
            Node<E> prevNode = getNode(index - 1);
            // 삽입하려는 위치의 이전 노드가 참조하고 있는 다음 노드를 새 노드가 참조
            Node<E> newNode = new Node<>(data, prevNode.next);
            // 삽입하려는 위치의 다음 노드를 새 노드를 참조하도록 설정
            prevNode.next = newNode;
            size++;
        }
    }
    // 특정 위치에 요소를 반환
    public E get(int index) {
        return getNode(index).data;
    }
    // 특정 위치의 노드를 반환
    public Node<E> getNode(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("List Size = " + size + ", Max Index = " + (size - 1));
        }
        Node<E> currentNode = head; // 첫 요소
        // 전달받은 index 만큼 첫 요소로부터 다음 요소로 이동
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        return currentNode;
    }
    // 특정 위치에 요소를 parameter로 전달된 요소로 변환
    public E set(int index, E data) {
        Node<E> node = getNode(index);
        E oldData = node.data;
        node.data = data;

        return oldData;
    }
    // 특정 위치에 요소를 삭제
    public E remove(int index) {
        Node<E> node = null;
        E removeData = null;

        if (index == 0) {   // 첫 요소 삭제
            node = getNode(index);
            removeData = node.data;
            node = node.next;
            head = node;    // 첫 노드가 다음 노드를 참조하도록 설정
        } else if (index == size - 1) { // 마지막 요소 삭제
            node = getNode(index - 1); // 마지막 노드의 이전 노드 조회
            removeData = node.next.data;
            node.next = null;   // 이전 노드의 다음 노드를 null로 변경
            tail = node;    // 마지막 노드가 이전 노드를 참조하도록 설정
        } else {
            node = getNode(index - 1);  // 삭제하려는 노드의 이전 노드 조회
            Node<E> currentNode = node.next;    // 삭제하려는 노드
            removeData = currentNode.data;
            node.next = currentNode.next;   // 이전 노드의 다음노드 참조를 삭제하려는 노드의 다음노드로 설정
        }
        size--;

        return removeData;
    }
    // 연결 리스트가 비어있는지 확인
    public boolean isEmpty() {
        return this.size == 0;
    }
    public void printAllData() {
        Node<E> currentNode = head;
        if (currentNode == null) {
            System.out.println("EMPTY LinkedList!");
        }
        while (currentNode != null) {
            System.out.println("data = " + currentNode.data);
            currentNode = currentNode.next;
        }
    }
}

class Node<E> {
    public E data;
    public Node<E> next;

    public Node(E data) {
        this.data = data;
        this.next = null;
    }

    public Node(E data, Node<E> next) {
        this.data = data;
        this.next = next;
    }
}

public class SinglyLinkedList {
    public static void main(String[] args) {
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();

        linkedList.addFirst("A");
        linkedList.addFirst("A-");
        linkedList.addLast("A+");
        linkedList.printAllData(); // (0) A-, (1) A, (2) A+

        Node<String> node = linkedList.getNode(2);
        System.out.println("node = " + node.data);

        linkedList.add(0, "N"); // (0) N, (1) A-, (2) A, (3) A+
        linkedList.add(2, "P"); // (0) N, (1) A-, (2) P, (3) A, (4) A+
        linkedList.add(5, "Q"); // (0) N, (1) A-, (2) P, (3) A, (4) A+, (5) Q

        System.out.println(" ======================== ");
        linkedList.printAllData();

        System.out.println(" ======================== ");
        linkedList.set(5, "New Q"); // (0) N, (1) A-, (2) P, (3) A, (4) A+, (5) New Q
        linkedList.set(0, "New N"); // (0) New N, (1) A-, (2) P, (3) A, (4) A+, (5) New Q
        linkedList.printAllData();

        System.out.println(" ======================== ");
        System.out.println("remove = " + linkedList.remove(5)); // (0) New N, (1) A-, (2) P, (3) A, (4) A+
        System.out.println("remove = " + linkedList.remove(3)); // (0) New N, (1) A-, (2) P, (3) A+
        System.out.println("remove = " + linkedList.remove(0)); // (0) A-, (1) P, (2) A+
        linkedList.printAllData();
    }
}
