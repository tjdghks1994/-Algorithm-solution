package main.java.wanted.inflearn.mapset;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 아나그램 {
    /**
     * 문제 : Anagram이란 두 문자열이 알파벳의 나열 순서를 다르지만 그 구성이 일치하면 두 단어는 아나그램이라고 합니다.
     *       예를 들면 AbaAeCe 와 baeeACA 는 알파벳을 나열 순서는 다르지만 그 구성을 살펴보면 A(2), a(1), b(1), C(1), e(2)로
     *       알파벳과 그 개수가 모두 일치합니다.
     *       즉, 어느 한 단어를 재 배열하면 상대편 단어가 될 수 있는 것을 아나그램이라 합니다.
     *       길이가 같은 두 개의 단어가 주어지면 두 단어가 아나그램인지 판별하는 프로그램을 작성하세요.
     *       아나그램 판별시 대소문자가 구분됩니다.
     * <p>
     * 입력 : 첫 줄에 첫 번째 단어가 입력되고, 두 번째 줄에 두 번째 단어가 입력됩니다.
     *       단어의 길이는 100을 넘지 않습니다.
     * <p>
     * 출력 : 두 단어가 아나그램이면 "YES"를 출력하고, 아니면 "NO"를 출력합니다.
     * <p>
     * 예시 : 입력 - AbaAeCe        출력 - YES
     *             baeeACA
     *       입력 - abaCC          출력 - NO
     *             Caaab
     */

    public static void solution(String str1, String str2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (char ch : str1.toCharArray()) {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        for (char ch : str2.toCharArray()) {
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }

        for (char ch : map1.keySet()) {
            // map1에 존재하는 key 가 map2에 존재하지 않는 경우
            // or
            // map1에 존재하는 key 의 value 값과 map2에 존재하는 key 의 value 값이 다른 경우
            if ( map2.get(ch) == null || map1.get(ch) != map2.get(ch) ) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.next();
        String str2 = in.next();

        solution(str1, str2);
    }
}
