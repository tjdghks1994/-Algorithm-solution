package main.java.wanted.inflearn;

import java.util.Scanner;

public class 임시반장정하기 {
    /**
     * 문제 : 김갑동 선생님은 올해 6학년 1반 담임을 맡게 되었다.
     *       김갑동 선생님은 우선 임시로 반장을 정하고, 학생들이 서로 친숙해진 후에 정식으로 선거를 통해 반장을 선출하려고 한다.
     *       그는 자기반 학생 중에서 1학년부터 5학년까지 지내오면서 한번이라도 같은 반이었던 사람이 가장 많은 학생을 임시 반장으로 정하려 한다.
     *       그래서 김갑동 선생님은 각 학생들이 1학년부터 5학년까지 몇 반에 속했었는지를 나타내는 표를 만들었다.
     *       해당 표를 통해서 각 학생들이 1학년부터 5학년까지 속했던 반이 주어질 때, 임시 반장을 정하는 프로그램을 작성하시오.
     * <p>
     * 입력 : 첫째 줄에는 반의 학생 수를 나타내는 정수가 주어진다. 학생 수는 3 이상 1000 이하이다.
     *       둘째 줄부터는 1번 학생부터 차례대로 각 줄마다 1학년부터 5학년까지 몇 반에 속했었는지를 나타내는 5개의 정수가 빈칸 하나를 사이에 두고 주어진다.
     *       주어지는 정수는 모두 1 이상 9 이하의 정수이다.
     * <p>
     * 출력 : 첫 줄에 임시 반장으로 정해진 학생의 번호를 출력한다.
     *       단, 임시 반장이 될 수 있는 학생이 여러 명인 경우에는 그 중 가장 작은 번호만 출력한다.
     * <p>
     * 예시 : 입력 - 5               출력 - 4
     *            2 3 1 7 3
     *            4 1 9 6 8
     *            5 5 2 4 4
     *            6 5 2 6 7
     *            8 4 2 2 2
     */

    public static void solution(int[][] tdArr) {
        int tmpCaptainNumber = 0;       // 임시반장 학생 번호
        int maxCnt = Integer.MIN_VALUE; // 최대 같은 반이였던 학생 수

        for (int i = 0; i < tdArr.length; i++) {    // 기준 index
            int cnt=0;  // 같은 반이였던 학생 수
            for (int j = 0; j < tdArr.length; j++) {    // 비교 대상 학생 index
                for (int k = 0; k < 5; k++) {   // 학년
                    // 기준 학생과 비교 대상 학생이 현재 학년에 같은 반이였는지 확인
                    if (tdArr[i][k] == tdArr[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            // 최대 같은 반이였던 학생 수보다 현재 cnt 가 크면 변경 처리
            if (cnt > maxCnt) {
                maxCnt = cnt;
                tmpCaptainNumber = i;
            }

        }
        // index 는 0부터 시작하므로 +1 한 값으로 임시반장 학생 번호 출력
        System.out.println(tmpCaptainNumber + 1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cnt = in.nextInt();
        int[][] tdArr = new int[cnt][5];

        for (int i = 0; i < tdArr.length; i++) {
            for (int j = 0; j < 5; j++) {
                tdArr[i][j] = in.nextInt();
            }
        }

        solution(tdArr);
    }
}
