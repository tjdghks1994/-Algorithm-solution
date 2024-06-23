package main.java.wanted.inflearn.sortsearch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 좌표정렬 {
    /**
     * 문제 : N개의 평면상의 좌표(x,y)가 주어지면 모든 좌표를 오름차순으로 정렬하는 프로그램을 작성하세요.
     *       정렬기준은 먼저 x값의 의해서 정렬하고, x값이 같을 경우 y값에 의해 정렬합니다.
     *
     * 입력 : 첫째 줄에 좌표의 개수인 N(3<=N<=100,000)이 주어집니다.
     *       두 번째 줄부터 N개의 좌표가 x,y 순으로 주어집니다. x,y값은 양수만 입력됩니다.
     *
     * 출력 : N개의 좌표를 정렬하여 출력하세요.
     *
     * 예시 : 입력 - 5          출력 - 1 2
     *            2 7              1 3
     *            1 3              2 5
     *            1 2              2 7
     *            2 5              3 6
     *            3 6
     */
    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class PointComparator implements Comparator {
        
        @Override
        public int compare(Object o1, Object o2) {
            if (o1 instanceof Point && o2 instanceof Point) {
                Point p1 = (Point) o1;
                Point p2 = (Point) o2;
                // 오름차순 정렬
                // x 좌표가 작은 경우 왼쪽
                if (p1.x < p2.x) {
                    return -1;
                } else if (p1.x == p2.x) {  // x 좌표가 같은 경우 y 좌표 값 비교
                    // y 좌표가 작은 경우 왼쪽
                    if (p1.y < p2.y) {
                        return -1;
                    } else if (p1.y == p2.y) {  // y 좌표가 같은 경우 동등
                        return 0;
                    } else {    // y 좌표가 큰 경우 오른쪽
                        return 1;
                    }
                } else {    // x 좌표가 큰 경우 오른쪽
                    return 1;
                }
            } else {
                throw new RuntimeException("비교 불가 대상");
            }
        }
    }


    public static void solution(Point[] arr) {
        Arrays.sort(arr, new PointComparator());

        for (Point p : arr) {
            System.out.println(p.x + " " + p.y);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Point[] arr = new Point[n];

        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();

            arr[i] = new Point(x, y);
        }

        solution(arr);
    }
}
