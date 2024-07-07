package main.java.wanted.inflearn.recursivetreegraph;

import java.util.Scanner;

public class 재귀함수 {
    /**
     * 문제 : 자연수 N이 입력되면 재귀함수를 이용하여 1부터 N까지를 출력하는 프로그램을 작성하세요.
     *
     * 입력 : 첫 번째 줄은 정수 N(3<=N<-10)이 입력된다.
     *
     * 출력 : 첫째 줄에 출력한다.
     *
     * 예시 : 입력 - 3  출력 - 1 2 3
     */

    public static void solution(int n) {

        if (n == 0) {
            return;
        } else{
            solution(n - 1);
            System.out.print(n + " ");
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        solution(n);
    }
}
