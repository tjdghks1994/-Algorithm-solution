package main.java.wanted.inflearn.mapset;

import java.util.HashMap;
import java.util.Scanner;

public class 모든아나그램찾기 {
    /**
     * 문제 : S 문자열에서 T 문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
     *       아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.
     *
     * 입력 : 첫 줄에 첫 번째 S 문자열이 입력되고, 두 번째 줄에 T 문자열이 입력됩니다.
     *       S 문자열의 길이는 10,000 넘지 않으며, T 문자열은 S 문자열보다 길이가 작거나 같습니다.
     *
     * 출력 : S 단어에 T 문자열과 아나그램이 되는 부분 문자열의 개수를 출력합니다.
     *
     * 예시 : 입력 - bacaAacba          출력 - 3
     *            abc
     */

    public static void solution(String s, String t) {
        int anagramCnt = 0;
        HashMap<Character, Integer> tMap = new HashMap<>(); // T 문자열 map
        for (char ch : t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> sMap = new HashMap<>(); // S 문자열 구간 map
        char[] sChars = s.toCharArray();
        // 첫 번째 구간
        for (int i = 0; i < t.length(); i++) {
            sMap.put(sChars[i], sMap.getOrDefault(sChars[i], 0) + 1);
        }
        // 첫 번째 구간의 sMap 이 tMap 과 동일한지 비교
        if (tMap.equals(sMap)) {
            anagramCnt++;   // 아나그램이므로 값 증가
        }

        int lp=0;
        // 두 번째 구간 ~ N 번째 구간
        for (int rp = t.length(); rp < s.length(); rp++) {
            sMap.put(sChars[lp], sMap.get(sChars[lp]) - 1); // 이전 구간 첫 번째 원소 제거
            sMap.put(sChars[rp], sMap.getOrDefault(sChars[rp], 0) + 1); // 현재 구간 원소 추가
            if (sMap.get(sChars[lp]) == 0) {    // 이전 구간의 첫 번째 원소를 제거했더니 key 의 value 값이 0 이면
                sMap.remove(sChars[lp]);    // key 제거
            }
            lp++;   // 왼쪽 포인터 값 증가
            // 현재 구간의 sMap 이 tMap 과 동일한지 비교
            if (tMap.equals(sMap)) {
                anagramCnt++;   // 아나그램이므로 값 증가
            }
        }

        System.out.println(anagramCnt);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();

        solution(s, t);
    }
}
