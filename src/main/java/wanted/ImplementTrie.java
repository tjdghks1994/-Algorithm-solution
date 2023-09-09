package main.java.wanted;

import java.util.HashMap;
import java.util.Map;
/**
 * Trie 클래스를 구현합니다.
 * Trie() : trie 객체를 초기화합니다.
 * void insert(String word) : 주어진 문자열 단어를 트라이에 삽입합니다.
 * boolean search(String word) :
 * 문자열 단어가 트라이에 있으면(즉, 이전에 삽입된 경우) true를 반환하고 그렇지 않으면 false를 반환합니다.
 * boolean startWith(String prefix) :
 * 주어진 접두사로 시작하는 문자열 단어가 있으면 true를 반환하고, 그렇지 않으면 false를 반환합니다.
 */
class Trie {
    private Node root;  // 최상위 노드
    private boolean result;

    public Trie() { // 최상위 노드 생성
        this.root = new Node();
    }

    public void insert(String words) {
        insert(root, words);
    }
    // 재귀호출 통해 문자열 삽입
    private void insert(Node root, String words) {
        if(words.length() == 0) {    // 마지막 문자 삽입완료
            root.isEndOfWord = true; // 해당 노드는 마지막 문자임을 나타내므로 true 설정
            return;
        }
        char word = words.charAt(0); // 삽입할 문자열의 첫번째 문자
        // 삽입할 문자가 자식노드로 존재하는지 조회
        Node child = root.children.get(word);
        // 이미 존재한다면 삽입할 필요 없음
        // 존재하지않는다면, 현재 노드의 새로운 자식노드로 추가
        if(child == null) {
            child = new Node();
            root.children.put(word, child);
        }
        // 자식노드와 현재 문자를 제외한 다음 문자열 삽입 재귀호출
        insert(child, words.substring(1));
    }
    // 재귀호출을 통해 문자열 탐색
    public boolean search(String words) {
        search(root, words);
        return result;
    }
    private void search(Node root, String words) {
        // 주어진 문자열에 대해 모든 탐색이 완료되었다면
        if(words.length() == 0) {
            // 해당 문자가 마지막 문자임을 나타내는 값을 반환처리
            result = root.isEndOfWord;
            return;
        }
        char word = words.charAt(0);
        Node child = root.children.get(word);
        if(child == null) { // 주어진 문자열의 문자를 갖는 child가 존재하지 않는다면 탐색 실패
            result = false;
            return;
        } else { // 주어진 문자열의 문자를 갖는 child가 존재하면 재귀호출
            search(child, words.substring(1));
        }
    }
    // 재귀호출을 통해 접두사 탐색
    public boolean startsWith(String prefix) {
        startsWith(root, prefix);
        return result;
    }
    private void startsWith(Node root, String prefix) {
        // 주어진 접두사에 대한 탐색이 모두 완료되었을 때
        if(prefix.length() == 0) {
            result = true;
            return;
        }
        char word = prefix.charAt(0);
        // 주어진 접두사의 문자가 자식노드로 존재하는지 조회
        Node child = root.children.get(word);
        // 접두사의 문자가 자식노드로 존재하지 않는다면 탐색 실패
        if(child == null) {
            result = false;
            return;
        }
        startsWith(child, prefix.substring(1));
    }
}

class Node {
    public Map<Character, Node> children; // 문자를 key로 갖고 Node를 value로 갖는 자식노드들을 저장할 Map 선언
    public boolean isEndOfWord; // 해당 데이터가 단어의 끝나는 지점인지의 여부

    public Node() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}
public class ImplementTrie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello");
        System.out.println("trie search words hello = " + trie.search("hello"));
        System.out.println("trie search words hel = " + trie.search("hel"));
        System.out.println("trie startsWith words hel = " + trie.startsWith("hel"));
    }
}
