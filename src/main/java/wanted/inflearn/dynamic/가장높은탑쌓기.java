package main.java.wanted.inflearn.dynamic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 가장높은탑쌓기 {
    /**
     * 문제 : 밑면이 정사각형인 직육면체 벽돌들을 사용하여 탑을 쌓고자 한다.
     *       탑은 벽돌을 한 개씩 아래에서 위로 쌓으면서 만들어 간다.
     *       아래의 조건을 만족하면서 가장 높은 탑을 쌓을 수 있는 프로그램을 작성하시오.
     *       (조건1) 벽돌은 회전시킬 수 없다. 즉 옆면을 밑면으로 사용할 수 없다.
     *       (조건2) 밑면의 넓이가 같은 벽돌은 없으며, 또한 무게가 같은 벽돌도 없다.
     *       (조건3) 벽돌들의 높이는 같을 수도 있다.
     *       (조건4) 탑을 쌓을 때, 밑면이 좁은 벽돌 위에 밑면이 넓은 벽돌을 놓을 수 없다.
     *       (조건5) 무게가 무거운 벽돌을 무게가 가벼운 벽돌 위에 놓을 수 없다.
     *
     * 입력 : 입력 파일의 첫째 줄에는 입력될 벽돌의 수가 주어진다. 입력으로 주어지는 벽돌의 수는 최대 100개이다.
     *       둘째 줄부터는 각 줄에 한 개의 벽돌에 관한 정보인 벽돌 밑면의 넓이, 벽돌의 높이 그리고 무게가 차례대로 양의 정수로 주어진다.
     *       각 벽돌은 입력되는 순서대로 1부터 연속적인 번호를 가진다.
     *       벽돌의 넓이, 높이 무게는 10,000보다 작거나 같은 자연수이다.
     *
     * 출력 : 첫 번째 줄에 가장 높이 쌓을 수 있는 탑의 높이를 출력한다.
     *
     * 예시 : 입력 - 5          출력 - 10
     *            25 3 4
     *            4 4 6
     *            9 2 3
     *            16 2 5
     *            1 5 2
     */

    static class Tower implements Comparable<Tower> {
        int width;  // 밑면 넓이
        int height; // 높이
        int weight; // 무게

        public Tower(int width, int height, int weight) {
            this.width = width;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Tower o) {
            return this.width - o.width;    // 밑면 넓이를 기준으로 오름차순 정렬
        }
    }

    static int[] dy;    // 원소의 값은 자신이 최대로 쌓은 돌의 높이 값을 담고 있는 배열

    public static void solution(ArrayList<Tower> towers) {
        Collections.sort(towers);   // 밑면 넓이를 기준으로 오름차순 정렬
        int answer = towers.get(0).height;  // 최대 높이
        dy[0] = towers.get(0).height;

        for (int i = 1; i < towers.size(); i++) {
            dy[i] = towers.get(i).height; // 현재 탑의 높이를 최대 높이로 먼저 초기화

            for (int j = i - 1; j >= 0; j--) {  // 앞선 탑들 비교
                // 앞선 탑의 무게가 현재 탑 무게보다 작은 경우 쌓기 가능
                if (towers.get(j).weight < towers.get(i).weight) {
                    // 현재 탑의 높이 + 이전 탑의 최대 높이 값과, 현재 최대 탑의 높이 값을 비교해서 더 큰 값을 저장
                    dy[i] = Math.max(towers.get(i).height + dy[j], dy[i]);
                }
            }
            // 최대 높이와 현재 탑의 최대 높이를 비교해 더 큰 높이를 answer 저장
            answer = Math.max(answer, dy[i]);
        }

        System.out.println(answer);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        dy = new int[n];
        ArrayList<Tower> towers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int width = in.nextInt();
            int height = in.nextInt();
            int weight = in.nextInt();
            towers.add(new Tower(width, height, weight));
        }

        solution(towers);
    }
}
