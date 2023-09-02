package main.java.wanted.datastructure;

import java.util.Objects;

public class LinearProbingHashTable<K, V> {
    // 해시 충돌 해결방안 중 Open Addressing 방안 - 추가 공간을 사용하지 않고 해결하는 방안
    // 다음 주소를 정하는 방법 중 선형탐색을 통해 다음 주소를 저장하는 HashTable 구현 (즉 비어있는 공간을 찾아 저장해야 한다)
    // 데이터를 추가할 때 해시 충돌로 인해, 선형탐색에 의해 원래 주소가 아닌 다른 주소로 저장되는 경우가 생기므로
    // 그런 데이터를 삭제처리할 때, 삭제가 되었다는 표시를 해야한다

    // LoadFactor를 활용하여 동적 리사이징을 구현한다
    // LoadFactor -> 해시테이블 원소의 총 개수 / 해시테이블의 크기로 해시테이블 가득찬 정도를 의미한다
    // 일반적으로 선형탐색방식의 HashTable은 LoadFactor를 0.5~0.6을 기준으로 한다
    class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    private static final float LOAD_FACTOR = 0.5f;
    private Entry<K, V>[] buckets; // 해시테이블에서 bucket이 저장되는 배열
    private int numberOfItems;  // 해시테이블의 총 원소 개수

    public LinearProbingHashTable(int capacity) {
        buckets = new Entry[capacity];  // 전달받은 초기용량만큼의 크기를 갖는 buckes 배열 생성
        numberOfItems = 0;
    }

    // Objects 클래스에서 제공하는 hashCode()를 활용
    private int hashFunction(K key) {
        return Objects.hashCode(key) % buckets.length;
    }

    public void put(K key, V value) { // 해시 테이블에 key-value 쌍을 삽입
        int bucketIndex = hashFunction(key);
        Entry<K, V> bucket = buckets[bucketIndex];

        // bucketIndex 위치에 이미 저장된 Entry가 존재한다면 선형탐색을 통해 비어있는 주소를 찾는다
        // 단, Entry의 key값이 null인 경우에는 이미 삭제된 영역이라 비어있는 주소라 판단해야 한다
        if (bucket != null && bucket.key != null) {
            bucketIndex = getSaveBucketIndex(key, bucketIndex);
        }
        // 해시 테이블에 저장
        buckets[bucketIndex] = new Entry<>(key, value);

        numberOfItems++;

        if (isResizingTable()) {
            resize();
        }
    }

    // 해시 테이블에서 key에 매칭되는 엔트리 삭제
    public K remove(K key) {
        if (isEmpty()) {
            throw new RuntimeException("HashTable is Empty");
        }
        int bucketIndex = hashFunction(key);
        // 삭제할 Entry가 해당되는 index 위치를 조회
        bucketIndex = getDeleteBucketIndex(key, bucketIndex);
        // 삭제할 Entry 조회
        Entry<K, V> removeBucket = buckets[bucketIndex];
        K removeKey = null;
        // 삭제할 Entry가 존재하는 경우
        if (removeBucket != null) {
            removeKey = removeBucket.key;
            buckets[bucketIndex] = new Entry<>(null, null); // 삭제시 key와 value를 null로 설정하여 삭제되었단 표시를 한다
            numberOfItems--;
        }

        return removeKey;
    }

    // 해시 테이블에서 key에 매칭되는 엔트리 조회/검색
    public V get(K key) {
        V findValue = null;

        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null && buckets[i].key != null && buckets[i].key.equals(key)) {
                findValue = buckets[i].value;
                break;
            }
        }

        return findValue;
    }

    // 해시 테이블에 요소 존재 유무 반환
    public boolean isEmpty() {
        return numberOfItems == 0;
    }

    // 해시 테이블에 저장된 요소 개수 반환
    public int size() {
        return numberOfItems;
    }

    // 해시테이블 동적리사이징
    private void resize() {
        Entry<K, V>[] original = buckets;
        Entry[] newBuckets = new Entry[buckets.length * 2];
        // 기존 bucket에 있는 요소들 복사
        for (int i = 0; i < original.length; i++) {
            newBuckets[i] = original[i];
        }

        buckets = newBuckets;
    }

    // 해시테이블의 크기를 리사이징 해야하는지 여부
    private boolean isResizingTable() {
        return (float) size() / buckets.length > LOAD_FACTOR;
    }

    // 해시 충돌이 발생한 경우 저장될 다른 위치를 찾기 위한 작업
    private int getSaveBucketIndex(K key, int bucketIndex) {
        Entry<K, V> bucket;

        while (buckets[bucketIndex] != null) {
            bucket = buckets[bucketIndex];

            // 해시 테이블의 데이터 삭제시, Enrty의 key-value를 모두 null로 저장하여 삭제된 데이터임을 표시했으므로,
            // bucket.key가 null인 경우에도 비어있는 공간이므로 해당 위치에 데이터를 새로 추가할 수 있는 Index 이다.
            // 저장하려는 Entry의 key와 현재 저장된 Entry의 key가 동일한 경우, key는 중복이 안되므로 현재 bucketIndex를 반환
            if (bucket.key == null || bucket.key.equals(key)) {
                numberOfItems--;    // put() 에서 중복되도 무조건 요소 개수를 증가시키므로, 증가되지 않도록 감소 시킨다
                break;
            }

            bucketIndex++;

            // bucketIndex가 배열의 크기랑 동일해졌다면 Index를 0으로 초기화
            if (bucketIndex == buckets.length) {
                bucketIndex = 0;
            }
        }

        return bucketIndex;
    }

    // 전달된 key와 같은 값을 가지고 있는 Entry의 index 위치를 조회
    private int getDeleteBucketIndex(K key, int bucketIndex) {
        Entry<K, V> bucket;

        while (buckets[bucketIndex] != null) {
            bucket = buckets[bucketIndex];

            if (bucket.key != null && bucket.key.equals(key)) {
                break;
            }

            bucketIndex++;

            // bucketIndex가 배열의 크기랑 동일해졌다면 Index를 0으로 초기화
            if (bucketIndex == buckets.length) {
                bucketIndex = 0;
            }
        }

        return bucketIndex;
    }

    public static void main(String[] args) {
        LinearProbingHashTable<String, String> table = new LinearProbingHashTable<>(10);
        // [Put Test]
        table.put("Kim", "Kim");
        table.put("Park", "Park");
        table.put("Han", "Han");
        // [Duplicate Key Test]
        table.put("Kim", "Kim2");
        table.put("Park", "Park2");
        // [Remove Test]
        System.out.println("remove = " + table.remove("Park")); // 삭제
        table.put("Park", "Park3");
        // [Get Test]
        System.out.println(table.get("Kim"));   // Kim2
        System.out.println(table.get("Park")); // Park3
        System.out.println(table.get("Han"));   // Han
        System.out.println("size = " + table.size()); // 3

        // [Dynamic Resizing Test]
        table.put("Test", "Test");
        table.put("Min", "Min");
        table.put("Yang", "Yang");
        table.put("Yoo", "Yoo");
        table.put("Lee", "Lee");
        table.put("Shin", "Shin");
        table.put("DDDD", "DDDD");
        table.put("테스트2", "테스트2");
        System.out.println("size = " + table.size());   // 11
        System.out.println(table.get("Test"));      // test
        System.out.println(table.get("Yang"));     // Yang
        System.out.println(table.get("DDDD"));     // DDDD

    }
}
