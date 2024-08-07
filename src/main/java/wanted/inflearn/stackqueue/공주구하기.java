package main.java.wanted.inflearn.stackqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 공주구하기 {
    /**
     * 문제 : 정보 왕국의 이웃 나라 외동딸 공주가 숲속의 괴물에게 잡혀갔습니다.
     *       정보 왕국에는 왕자가 N명이 있는데, 서로 공주를 구하러 가겠다고 합니다.
     *       정보왕국의 왕은 다음과 같은 방법으로 공주를 구하러 갈 왕자를 결정하기로 했습니다.
     *       왕은 왕자들을 나이 순으로 1번부터 N번 까지 차례로 번호를 매깁니다.
     *       그리고 1번 왕자부터 N번 왕자까지 순서대로 시계 방향으로 돌아가며 동그랗게 앉게 합니다.
     *       그리고 1번 왕자부터 시계방향으로 돌아가며 1부터 시작하여 번호를 외치게 합니다.
     *       한 왕자가 K(특정 숫자)를 외치면 그 왕자는 공주를 구하러 가는데서 제외되고 원 밖으로 나오게 됩니다.
     *       그리고 다음 왕자부터 다시 1부터 시작하여 번호를 외칩니다.
     *       이렇게 해서 마지막까지 남은 왕자가 공주를 구하러 갈 수 있습니다.
     *
     *       예를 들어 총 8명의 왕자가 있고, 3을 외친 왕자가 제외된다고 합시다.
     *       처음에는 3번 왕자가 3을 외쳐 제외됩니다.
     *       이어 6,1,5,2,8,4번 왕자가 차례대로 제외되고 마지막까지 남게 된 7번 왕자가 공주를 구하러갑니다.
     *       N과 K가 주어질 때 공주를 구하러 갈 왕자의 번호를 출력하는 프로그램을 작성하세요.
     *
     * 입력 : 첫 줄에 자연수 N(5<=5<=1,000)과 K(2<=K<=9)가 주어집니다.
     *
     * 출력 : 첫 줄에 마지막 남은 왕자의 번호를 출력합니다.
     *
     * 예시 : 입력 - 8 3        출력 - 7
     */

    public static void solution(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();

        // 모든 왕자를 큐에 삽입
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            // k번째 위치의 왕자가 되기 전까지 큐에서 제거 후 맨 뒷 순서로 다시 삽입
            for (int i = 1; i < k; i++) {
                int kingNumber = queue.poll();
                queue.add(kingNumber);
            }

            queue.poll();   // k번째 위치의 왕자는 제거
        }
        // 맨 마지막 남은 왕자의 번호 출력
        System.out.println(queue.poll());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        solution(n, k);
    }
}
