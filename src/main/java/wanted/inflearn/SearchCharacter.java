package main.java.wanted.inflearn;

public class SearchCharacter {
    /**
     * 문자 찾기
     * 문제 : 한 개의 문자열을 입력 받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요.
     *       대소문자를 구분하지 않습니다. 문자열의 길이는 100을 넘지 않습니다.
     * 입력 : 첫 줄에 문자열이 주어지고, 두 번째 줄에 문자가 주어진다.
     *       문자열은 영어 알파벳으로만 구성되어 있습니다.
     * 출력 : 첫 줄에 해당 문자의 개수를 출력한다.
     *
     * 예시 : 입력 :  Computercooler      출력 : 2
     *              c
     */

    private static int solution(String str, char ch) {
        int cnt = 0;

        str = str.toUpperCase();
        ch = Character.toUpperCase(ch);

        for (int i = 0; i < str.length(); i++) {
//            // ch 가 대문자인 경우와 소문자인 경우 값 비교
//            // ch 가 소문자인 경우 대문자 아스키 코드값 + 32 를 하면 된다
//            if (str.charAt(i) == ch || str.charAt(i) + 32 == ch) {
//                cnt++;
//            }
            if (str.charAt(i) == ch) {
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(solution("Computercooler", 'c'));
    }
}
