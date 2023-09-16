package main.java.wanted;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class MinimumAbsoluteDifferenceInBST {
    /**
     * BST(이진 검색 트리)의 루트가 주어지면 트리에 있는 두 개의 다른 노드 값 간의 최소 절대 차이를 반환합니다.
     *
     * 예시 1
     * Input: root = [4,2,6,1,3]
     * Output: 1
     *
     * 예시 2
     * Input: root = [1,0,48,null,null,12,49]
     * Output: 1
     */
    int min = Integer.MAX_VALUE;
    int prev = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 왼쪽 노드 재귀 호출
        getMinimumDifference(root.left);
        min = Math.min(min, Math.abs(root.val - prev)); // 최소값은 이전 계산된 최소값과 현재 노드값-이전노드값을 구한 절대값중에 작은 값으로 저장
        prev = root.val; // 현재 노드 값을 이전 값에 저장
        getMinimumDifference(root.right);

        return min;
    }

    public static void main(String[] args) {

    }
}
