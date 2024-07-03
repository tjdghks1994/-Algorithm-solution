package main.java.wanted.inflearn.recursivetreegraph;

import java.util.Scanner;

public class 합이같은부분집합 {
    /**
     * 문제 : N개의 원소로 구성된 자연수 집합이 주어지면, 이 집합을 두 개의 부분집합으로 나누었을 때
     * 두 부분집합의 원소의 합이 서로 같은 경우가 존재하면 "YES"를 출력하고, 그렇지 않으면 "NO"를 출력하는 프로그램을 작성하세요.
     * 둘로 나뉘는 부분집합은 서로소 집합이며, 두 부분집합을 합하면 입력으로 주어진 원래의 집합이 되어야 합니다.
     * 예를 들어 {1,3,5,6,7,10} 이 입력되면 {1,3,5,7} = {6,10} 으로 두 부분집합의 합이 16으로 같은 경우가 존재하는 것을 알 수 있다.
     * <p>
     * 입력 : 첫 번째 줄에 자연수 N(1<=N<=10)이 주어집니다.
     * 두 번째 줄에 집합의 원소 N개가 주어진다. 각 원소는 중복되지 않는다.
     * <p>
     * 출력 : 첫 번째 줄에 "YES" 또는 "NO"를 출력한다.
     * <p>
     * 예시 : 입력 - 6              출력 - YES
     * 1 3 5 6 7 10
     */
    static boolean answer = false;
    static int[] ch;    // 부분집합에 속하는지 체크 배열

    public static void solution(int idx, int[] arr) {
        // 마지막 노드까지 방문했다면
        // 체크 배열을 확인해 0과 1 값을 가진 부분집합으로 나누고 두 부분집합의 합을 구해 같은 경우 "YES" 출력
        if (idx == arr.length) {
            int sum1 = 0, sum2 = 0;
            for (int i = 0; i < ch.length; i++) {
                // 0 값을 가진 부분집합의 합
                if (ch[i] == 0) {
                    sum1 += arr[i];
                } else {    // 1 값을 가진 부분집합의 합
                    sum2 += arr[i];
                }
            }

            if (sum1 == sum2) {
                answer = true;
            }
        } else {
            ch[idx] = 1;    // 부분집합에 속하도록 표시
            solution(idx + 1, arr);
            ch[idx] = 0;    // 부분집합에 속하지않도록 표시
            solution(idx + 1, arr);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        ch = new int[n];
        solution(0, arr);

        if (answer) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
