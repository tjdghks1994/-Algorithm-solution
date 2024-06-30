package main.java.wanted.inflearn.recursivetreegraph;

import java.util.LinkedList;
import java.util.Queue;

class BNode {
    int data;
    BNode lt, rt;

    public BNode(int data) {
        this.data = data;
        lt = rt = null;
    }
}

public class BFS {
    BNode root;

    public void bfs(BNode root) {
        Queue<BNode> q = new LinkedList<>();
        q.offer(root);  // 첫 루트 노드 큐에 삽입
        int level = 0;  // 노드의 레벨

        while (!q.isEmpty()) {
            int len = q.size(); // 현재 큐의 원소 개수 ( 같은 레벨의 원소들이 삽입되어 있음 )
            // 현재 레벨의 원소들 탐색
            for (int i = 0; i < len; i++) {
                BNode current = q.poll();   // 큐의 맨 첫 번째 원소 제거
                System.out.print(current.data + " ");   // 데이터 출력
                // 제거한 원소의 왼쪽 노드가 존재하면 큐에 삽입
                if (current.lt != null) {
                    q.offer(current.lt);
                }
                // 제거한 원소의 오른쪽 노드가 존재하면 큐에 삽입
                if (current.rt != null) {
                    q.offer(current.rt);
                }
            }
            level++;    // 레벨 증가
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BFS tree = new BFS();
        tree.root = new BNode(1);
        tree.root.lt = new BNode(2);
        tree.root.rt = new BNode(3);
        tree.root.lt.lt = new BNode(4);
        tree.root.lt.rt = new BNode(5);
        tree.root.rt.lt = new BNode(6);
        tree.root.rt.rt = new BNode(7);
        tree.bfs(tree.root);
    }
}
