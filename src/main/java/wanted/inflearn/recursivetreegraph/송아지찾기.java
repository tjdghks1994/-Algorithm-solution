package main.java.wanted.inflearn.recursivetreegraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 송아지찾기 {
    /**
     * 문제 : 현수는 송아지를 잃어버렸다. 다행히 송아지에는 위치추적기가 달려 있다.
     *       현수의 위치와 송아지의 위치가 수직선상의 좌표 점으로 주어지면, 현수는 현재 위치에서 송아지의 위치까지 다음과 같은 방법으로 이동한다.
     *       송아지는 움직이지 않고 제자리에 있다.
     *       현수는 스카이 콩콩을 타고 가는데 한 번의 점프로 앞으로 1, 뒤로 1, 앞으로 5를 이동할 수 있다.
     *       최소 몇 번의 점프로 현수가 송아지의 위치까지 갈 수 있는지 구하는 프로그램을 작성하세요.
     *
     * 입력 : 첫 번째 줄에 현수의 위치 S와 송아지의 위치 E가 주어진다. 직선의 좌표 점은 1부터 10,000까지이다.
     *
     * 출력 : 점프의 최소횟수를 구한다. 답은 1이상이며 반드시 존재합니다.
     *
     * 예시 : 입력 - 5 14       출력 - 3
     */

    public static void solution(int s, int e) {
        Queue<Integer> q = new LinkedList<>();
        int[] chk = new int[10001]; // 좌표를 한번이라도 방문한 적이 있는지 체크하기 위한 배열
        chk[s] = 1; // 현재 현수 위치는 방문한 원소라고 표시
        q.offer(s); // 큐에 첫 원소 삽입
        int level = 0;  // 현재 원소의 레벨


        while (!q.isEmpty()) {
            int len = q.size(); //  현재 큐 원소의 개수

            for (int i = 0; i < len; i++) {
                Integer currentNode = q.poll(); //  큐에 첫 번째 원소 제거
                // 현재 현수의 위치가 송아지 위치랑 같으면 레벨 출력
                if (currentNode == e) {
                    System.out.println(level);
                    return;
                }

                if (chk[currentNode + 1] != 1) {
                    q.offer(currentNode + 1);   // 현재 현수 위치에서 앞으로 1칸 이동한 위치를 큐에 삽입
                    chk[currentNode + 1] = 1;      // 앞으로 1칸 이동한 위치를 삽입했으므로 방문 표시
                }

                if (currentNode - 1 != 0 && chk[currentNode-1] != 1) {
                    q.offer(currentNode - 1);   // 현재 현수 위치에서 뒤로 1칸 이동한 위치를 큐에 삽입
                    chk[currentNode - 1] = 1;      // 뒤로 1칸 이동한 위치를 삽입했으므로 방문 표시
                }

                if (chk[currentNode + 5] != 1) {
                    q.offer(currentNode + 5);   // 현재 현수 위치에서 앞으로 5칸 이동한 위치를 큐에 삽입
                    chk[currentNode + 5] = 1;      // 앞으로 5칸 이동한 위치를 삽입했으므로 방문 표시
                }

            }
            level++;    // 원소의 레벨 증가
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int e = in.nextInt();

        solution(s, e);
    }
}
