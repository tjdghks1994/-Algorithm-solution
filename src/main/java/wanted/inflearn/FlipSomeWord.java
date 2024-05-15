package main.java.wanted.inflearn;

public class FlipSomeWord {
    /**
     * 특정 문자 뒤집기
     * 문제 : 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
     * 특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.
     * <p>
     * 입력 : 첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.
     * <p>
     * 출력 : 첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.
     * <p>
     * 예시 : 입력 - a#b!GE*T@S     출력 - S#T!EG*b@a
     */

    public static void solution(String word) {
        int lp = 0;
        int rp = word.length() - 1;
        char[] chars = word.toCharArray();

        while (lp < rp) {
            char left = chars[lp];
            char right = chars[rp];

            boolean leftIsAlphabet = Character.isAlphabetic(left);
            boolean rightIsAlphabet = Character.isAlphabetic(right);
            // 자리 바꿈
            if (leftIsAlphabet && rightIsAlphabet) {
                char temp = chars[lp];
                chars[lp] = chars[rp];
                chars[rp] = temp;
                lp++;
                rp--;
                continue;
            }
            // 왼쪽 문자가 특수문자인 경우
            if (!leftIsAlphabet) {
                lp++;
            }
            // 오른쪽 문자가 특수문자인 경우
            if (!rightIsAlphabet) {
                rp--;
            }
        }

        System.out.println(new String(chars));
    }

    public static void main(String[] args) {
        String word = "a#b!GE*T@S";
        solution(word);
    }
}
