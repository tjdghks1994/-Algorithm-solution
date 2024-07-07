package main.java.wanted.inflearn.recursivetreegraph;

class DNode {
    int data;
    DNode lt, rt;

    public DNode(int data) {
        this.data = data;
        lt = rt = null;
    }
}

public class 말단노드까지가장짧은경로DFS {
    DNode root;

    public int dfs(int level, DNode root) {
        // 현재 노드의 왼쪽과 오른쪽 자식이 존재하지 않는 경우 말단 노드이다
        if (root.lt == null && root.rt == null) {
            return level;   // 현재 노드의 레벨을 반환
        } else {
            return Math.min(dfs(level + 1, root.lt), dfs(level + 1, root.rt));
        }
    }

    public static void main(String[] args) {
        말단노드까지가장짧은경로DFS tree = new 말단노드까지가장짧은경로DFS();
        tree.root = new DNode(1);
        tree.root.lt = new DNode(2);
        tree.root.rt = new DNode(3);
        tree.root.lt.lt = new DNode(4);
        tree.root.lt.rt = new DNode(5);

        System.out.println(tree.dfs(0, tree.root));
    }
}
