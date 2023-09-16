package main.java.wanted.datastructure;

import java.util.LinkedList;

public class SeparateChainingHashTable<K, V> {

    private LinkedList<Entry<K, V>>[] table; // 해시 테이블에서 bucket이 저장되는 배열 (각 bucket에는 연결 리스트 저장)
    private int numberOfItems;  // 해시 테이블의 총 원소 개수

    public SeparateChainingHashTable(int capacity) {
        table = new LinkedList[capacity];
        numberOfItems = 0;

        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // TODO: Change hashcode -> Object.hashcode()
    private int hash(String key) {  // 입력된 문자열의 ASCII 코드 합을 테이블 크기와 모듈러 연산을 통해 저장될 위치(Index) 반환
        int hashcode = 0;

        for (char c : key.toCharArray()) {
            hashcode += c;
        }

        return hashcode % table.length;
    }

    public void put(K key, V value) { // 해시 테이블에 Key-value 쌍을 삽입
        int indexOfBucket = hash((String) key);
        LinkedList<Entry<K, V>> bucket = table[indexOfBucket];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {    // 이미 동일한 key가 저장되어있다면 value를 업데이트
                entry.value = value;
                return;
            }
        }

        bucket.add(0, new Entry<>(key, value));
        numberOfItems++;
    }
    // 해시 테이블에서 key에 매칭되는 엔트리 삭제
    public Entry<K, V> remove(K key) {
        if (isEmpty()) {
            throw new RuntimeException("Hash Table is Empty");
        }

        int indexOfBucket = hash((String) key);
        LinkedList<Entry<K, V>> bucket = table[indexOfBucket];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                bucket.remove(entry);
                numberOfItems--;

                return entry;
            }
        }

        return null;
    }

    // 해시 테이블에서 key에 매칭되는 엔트리 조회/검색
    public V get(K key) {
        int indexOfBucket = hash((String) key);
        LinkedList<Entry<K, V>> bucket = table[indexOfBucket];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null;
    }
    // 해시 테이블에 요소 존재 유무 반환
    public boolean isEmpty() {
        return numberOfItems == 0;
    }

    class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        SeparateChainingHashTable<String, String> hashTable = new SeparateChainingHashTable<>(10);
        hashTable.put("강호동", "010-1111-1111");
        hashTable.put("유재석", "010-2222-2222");
        hashTable.put("이수근", "010-3333-3333");
        hashTable.put("서장훈", "010-4444-4444");
        hashTable.put("김희철", "010-5555-5555");
        hashTable.put("이수근", "010-6666-6666");  // 동일한 key 값으로 value가 업데이트됨

        System.out.println(hashTable.get("강호동"));   // "010-1111-1111"
        System.out.println(hashTable.get("유재석"));   // "010-2222-2222"
        System.out.println(hashTable.get("이수근"));   // "010-6666-6666"
        System.out.println(hashTable.get("서장훈"));   // "010-4444-4444"
        System.out.println(hashTable.get("김희철"));   // "010-5555-5555"
    }
}
