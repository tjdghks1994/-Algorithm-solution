package main.java.wanted.inflearn;

import java.util.Scanner;

public class CreateNumber {
    /**
     * 숫자만 추출
     * 문제 : 문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듭니다.
     * 만약 "tge0a1h205er" 에서 숫자만 추출하면 0,1,2,0,5 이고 이것을 자연수를 만들면 1205 가 됩니다.
     * 추출하여 만들어지는 자연수는 100,000,000 을 넘지 않습니다.
     * <p>
     * 입력 : 첫 줄에 숫자가 섞인 문자열이 주어집니다. 문자열의 길이는 100을 넘지 않습니다.
     * <p>
     * 출력 : 첫 줄에 자연수를 출력합니다.
     * <p>
     * 예시 : 입력 - g0en2T0s8eSoft     출력 - 208
     */

    public static void solution(String str) {
        String onlyNumber = str.replaceAll("[^0-9]", "");
        Integer stringToNumber = Integer.valueOf(onlyNumber);
        System.out.println(stringToNumber);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        solution(str);
    }
}
