package main.java.wanted.inflearn.recursivetreegraph;

import java.util.Scanner;

public class 바둑이승차 {
    /**
     * 문제 : 철수는 그의 바둑이들을 데리고 시장에 가려고 한다. 그런데 그의 트럭은 C 킬로그램 넘게 태울수가 없다.
     *       철수는 C를 넘지 않으면서 그의 바둑이들을 가장 무겁게 태우고 싶다.
     *       N 마리의 바둑이와 각 바둑이의 무게 W 가 주어지면, 철수가 트럭에 태울 수 있는 가장 무거운 무게를 구하는 프로그램을 작성하세요.
     * <p>
     * 입력 : 첫 번째 줄에 자연수 C(1<=C<=100,000,000)와 N(1<=N<=30)이 주어집니다.
     *       둘째 줄부터 N 마리 바둑이의 무게가 주어집니다.
     * <p>
     * 출력 : 첫 번째 줄에 가장 무거운 무게를 출력합니다.
     * <p>
     * 예제 : 입력 - 259 5          출력 - 242
     *              81
     *              58
     *              42
     *              33
     *              61
     */
    static int c;
    static int[] arr;
    static int answer = 0;

    public static void solution(int level, int sum) {
        // sum 값이 c를 초과하는 순간 종료
        if(sum > c) {return;}
        // 리프 노드까지 방문이 완료되었을 때
        // sum 값을 반환
        if (level == arr.length) {
            answer = Math.max(sum, answer);
        } else {
            solution(level+1, sum+arr[level]);  // 현재 레벨의 값을 sum에 추가
            solution(level+1, sum); // 현재 레벨의 값을 sum에서 제외
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        c = in.nextInt();
        int n = in.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        solution(0, 0);

        System.out.println(answer);
    }
}
