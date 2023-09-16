package main.java.wanted.programmers;

import java.util.Arrays;
import java.util.HashMap;

public class RunningRace {
    /**
     * 얀에서는 매년 달리기 경주가 열립니다. 해설진들은 선수들이 자기 바로 앞의 선수를 추월할 때 추월한 선수의 이름을 부릅니다.
     * 예를 들어 1등부터 3등까지 "mumu", "soe", "poe" 선수들이 순서대로 달리고 있을 때,
     * 해설진이 "soe"선수를 불렀다면 2등인 "soe" 선수가 1등인 "mumu" 선수를 추월했다는 것입니다.
     * 즉 "soe" 선수가 1등, "mumu" 선수가 2등으로 바뀝니다.
     *
     * 선수들의 이름이 1등부터 현재 등수 순서대로 담긴 문자열 배열 players와 해설진이 부른 이름을 담은 문자열 배열 callings가 매개변수로 주어질 때,
     * 경주가 끝났을 때 선수들의 이름을 1등부터 등수 순서대로 배열에 담아 return 하는 solution 함수를 완성해주세요.
     *
     * 예시
     * players
     * ["mumu", "soe", "poe", "kai", "mine"]
     * callings
     * ["kai", "kai", "mine", "mine"]
     * result
     * ["mumu", "kai", "mine", "soe", "poe"]
     */

    public static String[] solution(String[] players, String[] callings) {
        // players 원소들의 위치를 저장할 해시맵 선언 - key : players 원소 값, value : 원소의 index 값
        // 반복문(i=0; i<callings 길이; i++)
        //  int index = 해시맵.get(callings[i]);         - 현재 callings[i]의 값이 players 배열 몇번째 index 위치하는지 조회
        //  문자열 임시변수 = players[index]                - 위치 변동을 위해 임시로 저장할 변수 선언
        //  해시맵.put(players[index], index-1)          - 위치 변동으로 인해 players 원소 위치를 저장한 해시맵의 값도 변경 처리
        //  players[index] = players[index-1]           - 위치 변경
        //  해시맵.put(players[index-1], index);        - 위치 변동으로 인해 players 원소 위치를 저장한 해시맵의 값도 변경 처리
        //  players[index-1] = 문자열 임시변수에 저장된 값      - 위치 변경

        //  players 배열 반환

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (int i = 0; i < callings.length; i++) {
            int index = map.get(callings[i]);

            String temp = players[index];
            map.put(players[index], index - 1);
            players[index] = players[index - 1];
            map.put(players[index - 1], index);
            players[index - 1] = temp;
         }

        return players;
    }

    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        String[] result = solution(players, callings);

        System.out.println("result = " + Arrays.toString(result));
    }
}
