package main.java.wanted.inflearn.recursivetreegraph;

import java.util.LinkedList;
import java.util.Queue;

class DNode2 {
    int data;
    DNode2 lt,rt;

    public DNode2(int data) {
        this.data = data;
        lt = rt = null;
    }
}

public class 말단노드까지가장짧은경로BFS {
    DNode2 root;

    public int bfs(int level, DNode2 root) {
        Queue<DNode2> queue = new LinkedList<>();
        queue.offer(root);  // 큐에 루트 노드 삽입

        while (!queue.isEmpty()) {
            int len = queue.size(); // 현재 레벨에 존재하는 노드 개수 (큐의 사이즈)

            for (int i = 0; i < len; i++) {
                DNode2 currentNode = queue.poll();  //  현재노드 방문

                // 왼쪽,오른쪽 노드가 존재하지 않는 말단 노드라면 레벨 반환
                if (currentNode.lt == null && currentNode.rt == null) {
                    return level;
                }
                // 왼쪽 노드가 존재하면 말단 노드가 아니므로 큐에 왼쪽 노드 삽입
                if (currentNode.lt != null) {
                    queue.offer(currentNode.lt);
                }
                // 오른쪽 노드가 존재하면 말단 노드가 아니므로 큐에 오른쪽 노드 삽입
                if (currentNode.rt != null) {
                    queue.offer(currentNode.rt);
                }

            }
            level++;    // 레벨 증가
        }

        return -1;
    }

    public static void main(String[] args) {
        말단노드까지가장짧은경로BFS tree = new 말단노드까지가장짧은경로BFS();
        tree.root = new DNode2(1);
        tree.root.lt = new DNode2(2);
        tree.root.rt = new DNode2(3);
        tree.root.lt.lt = new DNode2(4);
        tree.root.lt.rt = new DNode2(5);

        System.out.println(tree.bfs(0, tree.root));
    }
}
