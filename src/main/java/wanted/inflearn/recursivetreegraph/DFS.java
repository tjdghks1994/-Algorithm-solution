package main.java.wanted.inflearn.recursivetreegraph;

class Node {
    int data;
    Node lt, rt;

    public Node(int data) {
        this.data = data;
        lt = rt = null;
    }
}

public class DFS {
    Node root;

    public void dfs(Node root) {
        if (root == null) {
            return;
        } else {
            // 전위 순회로 출력 - 부모 -> 왼쪽 -> 오른쪽
//            System.out.print(root.data + " ");
            dfs(root.lt);   // 왼쪽 노드로 이동
            // 중위 순회로 출력 - 왼쪽 -> 부모 -> 오른쪽
//            System.out.print(root.data + " ");
            dfs(root.rt);   // 오른쪽 노드로 이동
            // 후위 순회로 출력 - 왼쪽 -> 오른쪽 -> 부모
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        DFS tree = new DFS();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.dfs(tree.root);
    }
}
