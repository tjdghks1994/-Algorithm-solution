package main.java.wanted.inflearn;

import java.util.Scanner;

public class RSP {
    /**
     * [가위 바위 보]
     * 문제 : A,B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다.
     * 비길 경우에는 D를 출력합니다.
     * 가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.
     * 예를 들어 N=5이이면 두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.
     * <p>
     * 입력 : 첫 번째 줄에 게임 횟수인 자연수 N(1<=N<=100)이 주어집니다.
     * 두 번째 줄에는 A가 낸 가위, 바위, 보 정보가 N개 주어집니다.
     * 세 번째 줄에는 B가 낸 가위, 바위, 보 정보가 N개 주어집니다.
     * <p>
     * 출력 : 각 줄에 각 회의 승자를 출력합니다. 비겼을 경우는 D를 출력합니다.
     * <p>
     * 예시 : 입력 - 5              A B A B D
     * 2 3 3 1 3
     * 1 1 2 2 3
     */

    public static void solution(int[] a, int[] b) {
        // 1-2 = -1 B 승
        // 1-3 = -2 A 승
        // 2-1 = 1 A 승
        // 2-3 = -1 B 승
        // 3-1 = 2 B 승
        // 3-2 = 1 A 승
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[i]) {
                System.out.println("D");
                continue;
            }
            int subtractResult = a[i] - b[i];

            if (subtractResult == -2 || subtractResult == 1) {
                System.out.println("A");
                continue;
            }

            if (subtractResult == -1 || subtractResult == 2) {
                System.out.println("B");
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cnt = in.nextInt();
        int[] a = new int[cnt];
        int[] b = new int[cnt];

        for (int i = 0; i < cnt; i++) {
            a[i] = in.nextInt();
        }

        for (int j = 0; j < cnt; j++) {
            b[j] = in.nextInt();
        }

        solution(a, b);
    }
}
