package main.java.wanted.datastructure;

/**
 * circular doubly linked list로 구현
 * 기존 DoublyLinkedList 구현에서 dummyHead와 dummyTail이 연결된 구조
 */
class CircleLinkedList<E> {
    private BidirectionalNode<E> dummyHead;
    private BidirectionalNode<E> dummyTail;
    private int size;

    public CircleLinkedList() {
        dummyHead = new BidirectionalNode<>();
        dummyTail = new BidirectionalNode<>();
        dummyHead.next = dummyTail;
        dummyHead.prev = dummyTail;
        dummyTail.next = dummyHead;
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

        System.out.println("dummy tail <-> dummy head");
    }
}

public class CircularLinkedList {
    public static void main(String[] args) {
        CircleLinkedList<Integer> list = new CircleLinkedList<>();
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

        // 현재 원형연결리스트는 dummyHead와 dummyTail을 사용하는 구조로 되어있어서
        // 원형연결리스트의 마지막 노드의 다음노드의 데이터를 가져오면 dummyTail의 데이터를 가져와 null이 나오게 된다
        // 첫번째 노드의 이전노드 데이터를 가져오는 것 또한 dummyHead의 데이터를 가져와 null이 나오게 된다
        // 위와 같은 문제를 해결하기 위해서는 3가지 방법이 있다.
        // 1. 사용하는 코드에서 조건문을 사용하여 더미 노드 확인하는 방법
        // public BidirectionalNode<E> getNext(BidirectionalNode<E> node) {
        //        if (node.next == dummyTail) {
        //            return node.next.next.next;
        //        }
        //        return node.next;
        //    }
        //
        //    public BidirectionalNode<E> getPrev(BidirectionalNode<E> node) {
        //        if (node.prev == dummyHead) {
        //            return node.prev.prev.prev;
        //        }
        //        return node.prev;
        //    }
        // 2. 더미 노드를 사용하지 않는 설계로 변경하는 방법
        // 3. API를 노출하는 쪽에서 더미 노드를 숨기는 방법
        BidirectionalNode<Integer> lastNode = list.getNode(5);
        System.out.println(lastNode.next.data);
        BidirectionalNode<Integer> firstNode = list.getNode(0);
        System.out.println(firstNode.prev.data);

    }
}
