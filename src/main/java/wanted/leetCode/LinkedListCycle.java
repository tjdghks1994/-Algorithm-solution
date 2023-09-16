package main.java.wanted.leetCode;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class LinkedListCycle {

    /**
     * 연결된 목록인 head가 주어지면 연결된 목록에 순환이 있는지 확인합니다.
     * 다음 포인터를 계속 따라가면 다시 도달할 수 있는 노드가 목록에 있는 경우 연결 목록에는 순환이 있습니다.
     * 내부적으로 pos는 tail의 다음 포인터가 연결된 노드의 인덱스를 나타내는 데 사용됩니다.
     * pos는 매개변수로 전달되지 않습니다.
     * 연결리스트에 순환이 있으면 true를 반환합니다.
     * 그렇지 않으면 false를 반환합니다.
     *
     * 예시
     * 입력: head = [3,2,0,-4], pos = 1
     * 출력: true
     * 설명: 연결된 목록에는 꼬리가 첫 번째 노드(0-인덱스)에 연결되는 순환이 있습니다.
     */

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        // 거북이와 토끼 알고리즘을 활용
        // 2개의 노드를 선언
        // ListNode 자체가 null인 경우는 순환을 확인할 필요가 없으므로 false 반환
        // 반복문에서 1개의 노드는 1칸씩 다음 노드를 이동하고, 다른 1개의 노드는 2칸씩 다음 노드를 이동하도록 한다
        // 이동하는 도중 null이 발생하면 NullPointerException이 발생할 수 있으니 null 체크 로직 필요
        // 만약 두 노드가 이동하다 null인 경우가 생긴다면 순환이 없는 LinkedList를 의미하므로 false 반환
        // 만약 순환이 있다면 빠르게 이동한 노드와 느리게 이동하는 노드가 서로 만나는 경우가 생기므로 true 반환

        ListNode slowNode = head;
        ListNode fastNode = head;

        if (head == null) {
            return false;
        }

        while (true) {
            slowNode = slowNode.next == null ? null : slowNode.next;
            fastNode = fastNode.next == null ? null : fastNode.next.next;

            if (fastNode == null || slowNode == null) {
                return false;
            }

            if (slowNode == fastNode) {
                return true;
            }
        }

    }

    public static void main(String[] args) {

    }
}
