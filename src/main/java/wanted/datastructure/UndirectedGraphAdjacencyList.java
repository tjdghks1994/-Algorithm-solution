package main.java.wanted.datastructure;

import java.util.*;

/**
 * 무방향 그래프를 인접 리스트로 구현
 * ADT
 * Data(데이터)
 *  numberOfVertices - 정점의 수
 *  numberOfEdges - 간선의 수
 *  List<Integer>[] adjacencyList - 각 정점들의 인접 리스트를 담을 리스트 배열
 * Operation(연산)
 *  생성자 : 최대 n개의 노드를 가지는 공백 그래프를 생성
 *  hasEdge : 두 정점 간에 간선이 있는지 확인
 *  addEdge : 그래프에 정점 u와 정점 v를 연결하는 새로운 간선 e를 추가
 *  removeEdge : 두 정점간의 간선을 제거
 *  getAdjacentVertices(v) : 노드 v에 인접한 모든 노드를 반환
 *  toString : 그래프의 문자열 표현을 반환
 */
public class UndirectedGraphAdjacencyList {
    private int numberOfVertices;
    private int numberOfEdge;
    private List<Integer>[] adjacencyList;
    // 전달받은 정점의 수 만큼 최대 정점의 개수를 가지는 무방향 그래프 초기화
    public UndirectedGraphAdjacencyList(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        this.numberOfEdge = 0;
        this.adjacencyList = new LinkedList[numberOfVertices];

        for (int i = 0; i < numberOfVertices; i++) {
            this.adjacencyList[i] = new LinkedList<>();
        }
    }
    private boolean hasEdge(int vertices1, int vertices2) {
        return adjacencyList[vertices1].contains(vertices2);
    }
    public void addEdge(int vertices1, int vertices2) {
        if (!hasEdge(vertices1, vertices2)) {
            adjacencyList[vertices1].add(vertices2);
            adjacencyList[vertices2].add(vertices1);
            numberOfEdge++;
        }
    }

    public void removeEdge(int vertices1, int vertices2) {
        if (hasEdge(vertices1, vertices2)) {
            // 형변환을 작성해주지 않으면 remove(int index) 메서드가 수행되므로 의도치 않은 동작이 발생할 수 있다
            adjacencyList[vertices1].remove((Integer) vertices2);
            adjacencyList[vertices2].remove((Integer) vertices1);
            numberOfEdge--;
        }
    }

    public List<Integer> getAdjacencyList(int vertices) {
        return adjacencyList[vertices];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfVertices; i++) {
            sb.append(i).append(": ").append(adjacencyList[i].toString()).append("\n");
        }
        return sb.toString();
    }
    // dfs 구현
    // dfs 구현은 스택 자료구조를 사용
    // dfs는 현재노드의 인접한 노드 중 1개를 선택하여 계속 선택한 노드의 인접 노드 중 1개를 탐색하는 방법 (깊이 탐색)
    // 무한 루프를 방지하기 위해서 전역적으로 방문했던 노드를 트래킹 하는 방법 사용
    public void dfs(int vertex) {
        Stack<Integer> stack = new Stack<>(); // 탐색해야할 노드 목록
        HashSet<Integer> visited = new HashSet<>(); // 탐색이 완료된 노드 목록

        stack.push(vertex); // 탐색할 노드 추가

        while (!stack.isEmpty()) {
            int currentNode = stack.pop();
            // 탐색했던 노드는 다시 탐색할 필요 없음
            if (!visited.contains(currentNode)) {
                System.out.println("current : " + currentNode);
                visited.add(currentNode); // 탐색 완료되었다는 표시
                // 현재 노드의 인접한 노드 목록
                for (int v : adjacencyList[currentNode]) {
                    if (!visited.contains(v)) { // 아직 탐색한 적 없는 노드인 경우
                        stack.push(v); // 탐색해야할 노드 목록에 추가
                    }
                }
            }
        }

        System.out.println("모든 노드 탐색 완료!");
    }

    // bfs 구현
    // bfs 구현은 큐 자료구조를 사용
    // bfs는 현재 노드의 모든 인접한 노드를 탐색한 후에 다음 노드를 탐색하는 방식으로 동작 (너비 탐색)
    public void bfs(int vertex) {
        Queue<Integer> queue = new LinkedList<>(); // 탐색해야할 노드 목록
        HashSet<Integer> visited = new HashSet<>(); // 탐색 완료된 노드 목록
        queue.add(vertex); // 탐색할 노드 목록에 추가

        while (!queue.isEmpty()) {
            int currentNode = queue.poll(); // 탐색할 노드

            if (!visited.contains(currentNode)) { // 탐색 완료된 노드 목록에 없는 노드인 경우
                visited.add(currentNode); // 탐색 완료했다는 표시를 위해 탐색 완료된 노드 목록에 추가
                System.out.println("current : " + currentNode);
                // 탐색해야할 노드의 인접한 노드 목록
                for (int v : adjacencyList[currentNode]) {
                    if (!visited.contains(v)) { // 탐색 완료된 노드가 아닌 경우
                        queue.add(v); // 탐색해야할 노드 목록에 추가
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        UndirectedGraphAdjacencyList ugal = new UndirectedGraphAdjacencyList(5);
        ugal.addEdge(0, 1);
        ugal.addEdge(0, 2);
        ugal.addEdge(1, 3);
        ugal.addEdge(2, 4);
        ugal.addEdge(3, 4);
        ugal.addEdge(3, 2);
        ugal.addEdge(4, 0);
        ugal.removeEdge(0, 2);

        System.out.println("0의 인접한 노드 목록 : "+ ugal.getAdjacencyList(0));
        System.out.println("2의 인접한 노드 목록 : "+ ugal.getAdjacencyList(2));
        System.out.println(ugal.toString());

        ugal.dfs(0);
        ugal.bfs(0);

    }
}
