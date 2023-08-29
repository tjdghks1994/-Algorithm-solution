package main.java.wanted.datastructure;

/**
 * Singly LinkedList는 한 방향으로만 연결되어, 어떤 노드를 한 번 지나면 따로 저장하지 않는 한 반대 방향으로 돌아갈 수 없다.
 * 각 노드가 앞뒤로 연결되는 구조를 갖는 양방향(Doubly LinkedList)는 이러한 문제를 쉽게 해결해준다.
 * 여기서는 마지막 요소를 참조하는 tail을 사용하지 않고 고정된 dummyTail을 사용한다.
 * 장점
 * - 일관성 : dummyTail을 사용하면 리스트의 끝 부분에서의 연산을 처리하는 로직이 일관성을 유지하면서 간결해집니다.
 *          예를 들어, 노드를 추가하거나 제거할 때 별도의 조건문 없이 일반적인 방식으로 연산을 수행할 수 있습니다.
 * - 코드 복잡도 감소 : dummyTail을 사용하면 edge cases 처리가 간단해지므로 코드의 복잡도가 줄어듭니다.
 *                  또한, dummyTail의 사용으로 인해 끝 부분에서의 별도의 조건 확인이 필요 없게 되어 코드가 더 간결해집니다.
 * 단점
 * - 메모리 오버헤드 : dummyTail은 실제 데이터를 저장하지 않는 노드이기 때문에 약간의 메모리 오버헤드가 발생합니다.
 *                 그러나 대부분의 경우, 이 오버헤드는 무시할만한 수준입니다.
 */
class DoubleLinkedList<E> {
    private BidirectionalNode<E> dummyHead; // 연결 리스트의 처음 위치에 dummy head 요소를 참조
    private BidirectionalNode<E> dummyTail; // 연결 리스트의 마지막 위치에 dummy tail 요소를 참조
    private int size = 0; // 저장된 요소의 갯수

    public DoubleLinkedList() {
        dummyHead = new BidirectionalNode<>();
        dummyTail = new BidirectionalNode<>();
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }
    // 연결 리스트 맨 앞에 요소 추가
    public void addFirst(E data) {
        BidirectionalNode<E> newNode = new BidirectionalNode<>(data);

        newNode.next = dummyHead.next; // 새 노드의 다음 노드를 기존 dummyHead의 다음노드를 참조하도록 설정
        newNode.prev = dummyHead; // 새 노드의 이전 노드는 dummyHead를 참조하도록 설정
        dummyHead.next.prev = newNode; // 기존 dummyHead의 다음노드가 참조할 이전노드를 새 노드로 참조하도록 설정
        dummyHead.next = newNode;   // 기존 dummyHead의 다음노드는 새 노드를 참조하도록 설정
        size++;
    }

    // 연결 리스트 맨 마지막에 요소 추가
    public void addLast(E data) {
        BidirectionalNode<E> newNode = new BidirectionalNode<>(data);

        newNode.next = dummyTail; // 새 노드의 다음 노드는 dummyTail을 참조하도록 설정
        newNode.prev = dummyTail.prev; // 새 노드의 이전 노드 참조는는 기존 dummyTail의 이전노드로 설정
        dummyTail.prev.next = newNode;  // 기존 dummyTail의 이전노드가 참조하고 있던 다음노드의 참조를 새 노드로 설정
        dummyTail.prev = newNode; // 기존 dummyTail의 이전노드 참조를 새 노드로 설정
        size++;
    }

    // 특정 위치에 요소를 추가
    public void add(int index, E data) {
        BidirectionalNode<E> prevNode = getNode(index - 1);
        BidirectionalNode<E> newNode = new BidirectionalNode<>(data);
        newNode.prev = prevNode; // 새 노드의 이전노드는 추가하려는 index의 이전노드를 참조하도록 설정
        newNode.next = prevNode.next; // 새 노드의 다음노드는 추가하려는 index의 이전노드가 참조하고 있던 다음노드를 참조하도록 설정
        prevNode.next.prev = newNode; // 추가하려는 index의 다음노드가 참조하고 있던 이전노드는 새 노드를 참조하도록 설정
        prevNode.next = newNode; // 추가하려는 index의 이전노드가 참조하고 있던 다음노드는 새 노드를 참조하도록 설정
        size++;
    }
    // 특정 위치의 요소를 반환
    public E get(int index) {
        return getNode(index).data;
    }
    // 특정 위치의 노드를 반환
    public BidirectionalNode<E> getNode(int index) {
        if (index < -1 || index > size-1) {
            throw new IndexOutOfBoundsException("Size = " + size + ", Max Index = " + (size - 1));
        }
        BidirectionalNode node = null;
        // 현재 요소 갯수/2 값이 전달받은 index 보다 크다면 앞쪽 노드에서부터 다음노드를 조회하면 더 빠르게 찾을 수 있다
        if (index < size / 2) {
            node = dummyHead;
            for (int i = -1; i < index; i++) {  // 첫 node가 dummyHead 이므로 i=-1부터 진행
                node = node.next;
            }
        } else {    // 현재 요소 갯수/2 값이 전달받은 index 보다 작거나 같다면 뒤쪽 노드에서부터 이전노드로 조회하면 더 빠르게 찾을 수 있다
            node = dummyTail;
            for (int i = size; i > index; i--) { // 첫 node가 dummyTail 이므로 i=size부터 진행
                node = node.prev;
            }
        }
        return node;
    }
    // 특정 위치의 요소를 parameter로 전달된 요소로 변환
    public E set(int index, E data) {
        BidirectionalNode<E> currentNode = getNode(index);
        E oldData = currentNode.data;
        currentNode.data = data;

        return oldData;
    }
    // 특정 위치에 요소를 삭제
    public E remove(int index) {
        BidirectionalNode<E> currentNode = getNode(index);
        BidirectionalNode<E> prevNode = currentNode.prev;
        E removeData = currentNode.data;

        currentNode.next.prev = prevNode;   // 삭제하려는 노드의 다음노드가 참조하고 있던 이전노드를 삭제하려는 노드의 이전노드를 참조하도록 설정
        prevNode.next = currentNode.next;
        size--;

        return removeData;
    }
    public void print() {
        BidirectionalNode<E> currNode = dummyHead;

        System.out.print("dummy head <-> ");

        while (currNode.next != dummyTail) {
            currNode = currNode.next;
            System.out.print(currNode.data + " <-> ");
        }

        System.out.println("dummy tail");
    }
}

class BidirectionalNode<E> {
    public BidirectionalNode<E> prev;  // 이전노드를 참조
    public E data; // 데이터
    public BidirectionalNode<E> next;  // 다음노드를 참조

    public BidirectionalNode() {
        this.prev = null;
        this.next = null;
        this.data = null;
    }
    public BidirectionalNode(E data) {
        this.prev = null;
        this.next = null;
        this.data = data;
    }
    public BidirectionalNode(BidirectionalNode<E> prev, BidirectionalNode<E> next, E data) {
        this.prev = prev;
        this.next = next;
        this.data = data;
    }
}

public class DoublyLinkedList {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        // Test addFirst()
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        System.out.print("After addFirst(): ");
        list.print(); // Expected output: 1 <-> 2 <-> 3 <-> null

        // Test addLast()
        list.addLast(4);
        list.addLast(5);
        System.out.print("After addLast(): ");
        list.print(); // Expected output: 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> null

        // Test add(index, element)
        list.add(0, 0); // Add 0 at the beginning
        list.add(6, 6); // Add 6 at the end
        list.add(4, 99); // Add 99 at index 4
        System.out.print("After add(index, element): ");
        list.print(); // Expected output: 0 <-> 1 <-> 2 <-> 3 <-> 99 <-> 4 <-> 5 <-> 6 <-> null

        // Test get(index)
        System.out.println("Element at index 3: " + list.get(3)); // Expected output: 3

        // Test set(index, element)
        list.set(4, 100);
        System.out.print("After set(index, element): ");
        list.print(); // Expected output: 0 <-> 1 <-> 2 <-> 3 <-> 100 <-> 4 <-> 5 <-> 6 <-> null

        // Test remove(index)
        list.remove(0); // Remove the first element
        list.remove(6); // Remove the last element
        System.out.print("After remove(index): ");
        list.print(); // Expected output: 1 <-> 2 <-> 3 <-> 100 <-> 4 <-> 5 <-> null
    }
}
