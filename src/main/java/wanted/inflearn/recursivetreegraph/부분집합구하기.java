package main.java.wanted.inflearn.recursivetreegraph;

import java.util.Scanner;

public class 부분집합구하기 {
    /**
     * 문제 : 자연수 N이 주어지면 1부터 N 까지의 원소를 갖는 집합의 부분집합을 모두 출력하는 프로그램을 작성하세요.
     *
     * 입력 : 첫 번째 줄에 자연수 N(1<=N<=10)이 주어집니다.
     *
     * 출력 : 첫 번째 줄부터 각 줄에 하나씩 부분집합을 아래와 출력예제와 같은 순서로 출력합니다.
     *       단 공집합은 출력하지 않습니다.
     *
     * 예시 : 입력 - 3          출력 - 1 2 3
     *                             1 2
     *                             1 3
     *                             1
     *                             2 3
     *                             2
     *                             3
     */
    static int n;
    static int[] ch;

    public static void dfs(int l) {
        // 입력된 n보다 높은 레벨인 경우 부분집합을 출력함
        if (l == n + 1) {
            String tmp = "";    // 부분집합
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) {   // 사용한다는 표시가 되어있음
                    tmp += i + " "; // 부분집합에 추가
                }
            }
            // 부분집합이 공집합이 아닌 경우 출력
            if (tmp.length() > 0) {
                System.out.println(tmp);
            }
        } else {
            ch[l] = 1;  // 사용한다고 표시
            dfs(l + 1); // 왼쪽 - 사용한다
            ch[l] = 0;  // 사용안한다고 표시
            dfs(l + 1); // 오른쪽 - 사용안한다
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        ch = new int[n + 1];

        dfs(1);
    }
}
