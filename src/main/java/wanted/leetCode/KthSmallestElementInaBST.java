package main.java.wanted;

import java.util.Stack;

public class KthSmallestElementInaBST {
    /**
     * 이진 검색 트리의 루트와 정수 k가 주어지면 트리에 있는 모든 노드 값 중 k번째로 작은 값을 반환합니다.
     *
     * 예시1
     * Input: root = [3,1,4,null,2], k = 1
     * Output: 1
     *
     * 예시2
     *Input: root = [5,3,6,2,4,null,null,1], k = 3
     * Output: 3
     */
    Stack<Integer> stack = new Stack();
    int kth = Integer.MAX_VALUE;
    public int kthSmallest(TreeNode root, int k) {
        findKthSmallest(root, k);
        return kth;
    }

    public void findKthSmallest(TreeNode root, int k) {
        // 이후 필요없는 작업을 계속 진행하지 않도록 stack.size() >= k 조건 추가
        if(root == null || stack.size() >= k) {
            return;
        }

        findKthSmallest(root.left, k);

        stack.push(root.val);
        if(stack.size() == k) {
            kth = stack.peek();
            return;
        }

        findKthSmallest(root.right, k);

    }

    public static void main(String[] args) {

    }
}
