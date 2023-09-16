package main.java.wanted.leetCode;

import java.util.*;

/**
 * 연결된 무방향 그래프의 노드에 대한 참조가 제공됩니다.
 * 그래프의 전체 복사본(클론)을 반환 해야합니다.
 * 그래프의 각 노드에는 노드의 값(int)과 이웃노드목록(List[Node])이 포함되어 있습니다.
 *
 * class Node {
 *    public int value;
 *    public List<Node> neighbors;
 * }
 *
 * 테스트 케이스 형식
 * 단순화를 위해 각 노드의 값은 노드의 인덱스와 동일합니다. 예를 들어, val = 1인 첫 번째 노드, val = 2인 두 번째 노드 등입니다.
 *
 * 그래프는 인접 목록을 사용하여 테스트 케이스에 표시됩니다.
 * 인접 목록은 유한 그래프를 나타내는 데 사용 되는 순서가 지정되지 않은 목록의 모음입니다. 각 목록은 그래프에 있는 노드의 이웃 집합을 설명합니다.
 * 주어진 노드는 항상 val = 1인 첫 번째 노드가 됩니다.
 *
 * 복제된 그래프에 대한 참조로 주어진 노드의 복사본을 반환해야 합니다.
 *
 * 예시
 *
 * Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
 * Output: [[2,4],[1,3],[2,4],[1,3]]
 * Explanation: There are 4 nodes in the graph.
 * 1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 * 3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 */
public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    // BFS 알고리즘을 활용해 그래프를 복사한다
    // BFS - 너비 우선 탐색

    // 전달된 노드(복사할 노드)를 저장할 큐 선언
    // key-복사한 노드의 값, value-복사한노드 를 저장할 맵 선언
    // 첫 노드를 복사할 복사노드 생성
    // 큐에 전달된 노드 저장
    // 맵에 key-초기 노드값, value-복사노드 저장

    // 반복문(큐가 비어있지 않는동안)
    //     노드 복사대상 = 큐에 있는 노드 poll
    //     반복문(복사대상노드의 이웃노드)
    //         if(맵에 복사대상노드의 값이 존재하지 않으면) {
    //             이웃노드의 값을 가지는 새로운 노드 생성
    //             맵에 key-새로운 노드의 값, value-새로운 노드 저장 -> 복사가 완료된 대상임을 알고 있기 위해
    //             큐에 이웃노드 저장
    //         }
    //         맵에서 이웃노드의 값을 key로 가지고 있는 노드를 조회하고
    //         해당 노드의 이웃노드로 위의 if문에서 저장한 새로운 노드를 꺼내와 저장

    // 복사한 노드 반환
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        Queue<Node> q = new LinkedList<>();
        HashMap<Integer, Node> m = new HashMap<>();
        Node cloneNode = new Node(node.val);
        q.add(node);
        m.put(node.val, cloneNode);

        while(!q.isEmpty()) {
            Node pollNode = q.poll();

            for(Node n : pollNode.neighbors) {
                if(m.get(n.val) == null) {
                    Node adjacencyNode = new Node(n.val);
                    m.put(adjacencyNode.val, adjacencyNode);
                    q.add(n);
                }

                m.get(pollNode.val).neighbors.add(m.get(n.val));
            }

        }
        return cloneNode;
    }
}
