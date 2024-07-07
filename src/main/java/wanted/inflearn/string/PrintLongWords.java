package main.java.wanted.inflearn.string;

public class PrintLongWords {
    /**
     * 가장 긴 단어 출력
     * 설명 : 한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
     * 문장속의 각 단어는 공백으로 구분됩니다.
     * 입력 : 첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다. 문장은 영어 알파벳으로만 구성되어 있습니다.
     * 출력 : 첫 줄에 가장 긴 단어를 출력합니다. 가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한 단어를 답으로 합니다.
     * <p>
     * 예시 : 입력 : it is time to study    출력 : study
     */

    private static String solution(String str) {
        String[] words = str.split(" ");
        int maxLengthIdx = 0;

        for (int i = 1; i < words.length; i++) {
            if (words[i].length() > words[maxLengthIdx].length()) {
                maxLengthIdx = i;
            }
        }

        return words[maxLengthIdx];
    }

    public static void main(String[] args) {
        System.out.println(solution("it is time to study"));
    }
}
