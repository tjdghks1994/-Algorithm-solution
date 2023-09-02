package main.java.wanted.datastructure;

import java.util.Arrays;

public class BubbleSort { // 버블정렬 구현
    // 버블정렬은 이웃한 2개의 값을 비교하면서 자리를 변경하는 알고리즘
    // 이웃한 2개의 값 중 작은것은 앞으로, 큰 것은 뒤로 이동
    // 큰 수가 배열의 마지막부터 차례대로 정렬된다

    // 이미 정렬된 배열의 경우 버블정렬의 최적화를 위한 자리변경체크 변수 선언
    // 안쪽 for문에서 단 한번도 swap이 일어나지 않았다면 이미 배열이 정렬된 상태이므로 종료
    public static void sortByBubble(int[] arr) {
        boolean hasSwapped;

        for (int i = arr.length - 1; i > 0; i--) {
            hasSwapped = false;
            for (int j = 0; j < i; j++) {
                // 앞 index에 위치한 값이 뒤 index 위치한 값보다 큰 경우 자리 바꿈
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+1] = tmp;
                    hasSwapped = true;
                }
            }
            if (!hasSwapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 44, 38, 5, 47, 2};
        sortByBubble(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        sortByBubble(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
