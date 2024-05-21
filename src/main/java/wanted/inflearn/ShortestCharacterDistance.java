package main.java.wanted.inflearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ShortestCharacterDistance {
    /**
     * 가장 짧은 문자거리
     * 문제 : 한 개의 문자열 s 와 문자 t 가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
     *
     * 입력 : 첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
     *       문자열의 길이는 100을 넘지 않는다.
     *
     * 출력 : 첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
     *
     * 예시 : 입력 - teachermode  e     출력 - 1 0 1 2 1 0 1 2 2 1 0
     */
    public static void solution(String str, String ch) {
//        List<Integer> eIndexes = new ArrayList<>();
//        // e의 위치를 전부 찾아내서 index 값을 보관
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == ch.charAt(0)) {
//                eIndexes.add(i);
//            }
//        }
//
//        // 문자열 길이만큼 반복하면서
//        // 문자열 인덱스 값과 e의 위치 index 들과 값의 차이(절대값 활용)를 구해서 최소 값을 출력
//        for (int i = 0; i < str.length(); i++) {
//            int minDistance = Integer.MAX_VALUE;
//            // 자기자신의 거리는 무조건 0
//            if (str.charAt(i) == ch.charAt(0)) {
//                minDistance = 0;
//                // 최소거리 출력
//                System.out.print(minDistance+" ");
//                continue;
//            }
//            // 현재 문자의 최소 거리 구하기
//            for (int j = 0; j < eIndexes.size(); j++) {
//                // 문자열 인덱스 값과 e의 위치 index 값의 차이를 구함 (절대값 활용 - 음수는 없으므로)
//                int distance = Math.abs(i - eIndexes.get(j));
//                // 최소거리가 distance 보다 크면 최소 거리값 변경
//                if (minDistance > distance) {
//                    minDistance = distance;
//                }
//            }
//            // 최소거리 출력
//            System.out.print(minDistance+" ");
//        }

        char[] chars = str.toCharArray();
        char c = ch.charAt(0);

        int[] answer = new int[chars.length];
        int distance = 0;
        // 왼쪽에서 거리 계산
        for (int i=0; i<chars.length; i++) {
            if (chars[i] == c) {
                distance = 0;
            } else {
                distance++;
            }
            answer[i] = distance;
        }

        // 오른쪽에서 거리 계산
        distance = 0;
        for (int j = chars.length - 1; j >= 0; j--) {
            if (chars[j] == c) {
                distance = 0;
            } else {
                distance++;
                answer[j] = Math.min(answer[j], distance);
            }
        }

        System.out.println(Arrays.toString(answer));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] strArray = str.split(" ");

        solution(strArray[0], strArray[1]);
    }
}
