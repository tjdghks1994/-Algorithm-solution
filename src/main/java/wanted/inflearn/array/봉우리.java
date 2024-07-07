package main.java.wanted.inflearn.array;

import java.util.Scanner;

public class 봉우리 {
    /**
     * 문제 : 지도 정보가 N*N 격자판에 주어집니다. 각 격자에는 그 지역의 높이가 쓰여있습니다.
     * 각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다. 봉우리 지역이 몇 개 있는지 알아내는 프로그램을 작성하세요.
     * 격자의 가장자리는 0으로 초기화 되었다고 가정한다.
     * <p>
     * 입력 : 첫 줄에 자연수 N이 주어진다 (2<=N<=50)
     * 두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
     * <p>
     * 출력 : 봉우리의 개수를 출력하세요.
     * <p>
     * 예시 : 입력 - 5                  출력 - 10
     *            5 3 7 2 3
     *            3 7 1 6 1
     *            7 2 5 3 4
     *            4 3 6 4 1
     *            8 7 3 5 2
     */

    public static void solution(int[][] tdArr) {
        int peakCnt = 0;    // 봉우리 수
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        for (int i = 1; i < tdArr.length - 1; i++) {
            for (int j = 1; j < tdArr.length - 1; j++) {
//                if (tdArr[i][j] > tdArr[i-1][j] && // 상
//                    tdArr[i][j] > tdArr[i+1][j] && // 하
//                    tdArr[i][j] > tdArr[i][j-1] && // 좌
//                    tdArr[i][j] > tdArr[i][j+1] // 우
//                ) {
//                    peakCnt++;
//                }
                boolean isPeak = true;
                for (int k = 0; k < 4; k++) {
                    int nx = i+dx[k];
                    int ny = j+dy[k];
                    // 반복문을 통해 상 하 좌 우 값과 비교
                    if (nx >= 0 && nx < tdArr.length &&
                        ny >= 0 && ny < tdArr.length &&
                        tdArr[nx][ny] >= tdArr[i][j]) {

                        isPeak = false;
                    }
                }

                if(isPeak) peakCnt++;
            }
        }

        System.out.println(peakCnt);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] tdArr = new int[n + 2][n + 2];

        for (int i = 0; i < tdArr.length; i++) {

            for (int j = 0; j < tdArr.length; j++) {
                if (i == 0 || i == (tdArr.length - 1) || j == 0 || j == (tdArr.length - 1)) {
                    tdArr[i][j] = 0;
                } else {
                    tdArr[i][j] = in.nextInt();
                }
            }
        }

        solution(tdArr);
    }
}
