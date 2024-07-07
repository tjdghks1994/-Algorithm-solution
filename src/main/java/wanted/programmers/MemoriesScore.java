package main.java.wanted.programmers;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 사진들을 보며 추억에 젖어 있던 루는 사진별로 추억 점수를 매길려고 합니다.
 * 사진 속에 나오는 인물의 그리움 점수를 모두 합산한 값이 해당 사진의 추억 점수가 됩니다.
 * 예를 들어 사진 속 인물의 이름이 ["may", "kein", "kain"]이고 각 인물의 그리움 점수가 [5점, 10점, 1점]일 때 해당 사진의 추억 점수는 16(5 + 10 + 1)점이 됩니다.
 * 다른 사진 속 인물의 이름이 ["kali", "mari", "don", "tony"]이고 ["kali", "mari", "don"]의 그리움 점수가 각각 [11점, 1점, 55점]]이고,
 * "tony"는 그리움 점수가 없을 때, 이 사진의 추억 점수는 3명의 그리움 점수를 합한 67(11 + 1 + 55)점입니다.
 *
 * 그리워하는 사람의 이름을 담은 문자열 배열 name, 각 사람별 그리움 점수를 담은 정수 배열 yearning,
 * 각 사진에 찍힌 인물의 이름을 담은 이차원 문자열 배열 photo가 매개변수로 주어질 때,
 * 사진들의 추억 점수를 photo에 주어진 순서대로 배열에 담아 return하는 solution 함수를 완성해주세요.
 *
 * 입출력 예시1
 * name : ["may", "kein", "kain", "radi"]
 * yearning : [5, 10, 1, 3]
 * photo : [["may", "kein", "kain", "radi"],["may", "kein", "brin", "deny"], ["kon", "kain", "may", "coni"]]
 * result : [19, 15, 6]
 *
 * 입출력 예시2
 * name : ["kali", "mari", "don"]
 * yearning : [11, 1, 55]
 * photo : [["kali", "mari", "don"], ["pony", "tom", "teddy"], ["con", "mona", "don"]]
 * result : [67, 0, 55]
 *
 * 입출력 예시3
 * name : ["may", "kein", "kain", "radi"]
 * yearning : [5, 10, 1, 3]
 * photo : [["may"],["kein", "deny", "may"], ["kon", "coni"]]
 * result : [5, 15, 0]
 */
public class MemoriesScore {
    // name배열의 원소를 key, yearning배열의 원소를 value로 갖는 해시맵 선언
    // 반복문(i=0; i<name배열이나 yearning배열 길이; i++)
    //      해시맵.put(name배열 원소, yearning배열 원소);

    // 사진들의 추억점수를 담을 결과배열 선언 - 배열의 길이는 photo배열의 길이만큼
    // 반복문(i=0; i<photo배열 길이; i++) {
    //  추억점수의 합산을 계산할 변수 선언
    //  반복문(j=0; j<photo[i]배열 길이; j++) {
    //      만약 photo[i][j]의 값이 해시맵 키에 포함된 값이라면
    //          추억점수 += 해시맵.get(photo[i][j])
    //      }
    //  추억점수 결과배열[i] = 추억점수 합산 값
    // }

    // 추억점수 결과배열 반환

    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        int[] result = new int[photo.length];
        for (int i = 0; i < photo.length; i++) {
            int score = 0;
            for (int j = 0; j < photo[i].length; j++) {
                if (map.containsKey(photo[i][j])) {
                    score += map.get(photo[i][j]);
                }
            }
            result[i] = score;
        }

        return result;
    }

    public static void main(String[] args) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};
        System.out.println(Arrays.toString(solution(name,yearning,photo)));

        String[] name2 = {"kali", "mari", "don"};
        int[] yearning2 = {11, 1, 55};
        String[][] photo2 = {{"kali", "mari", "don"}, {"pony", "tom", "teddy"}, {"con", "mona", "don"}};
        System.out.println(Arrays.toString(solution(name2,yearning2,photo2)));

        String[] name3 = {"may", "kein", "kain", "radi"};
        int[] yearning3 = {5, 10, 1, 3};
        String[][] photo3 = {{"may"},{"kein", "deny", "may"}, {"kon", "coni"}};
        System.out.println(Arrays.toString(solution(name3,yearning3,photo3)));
    }
}
