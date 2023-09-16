package main.java.wanted.datastructure;

import java.util.Arrays;

public class MergeSort { // 병합 정렬
    // 병합 정렬은 분할 정복(Divide and Conquer)과 재귀(Recursion) 알고리즘을 사용한 정렬 방법이다
    // 배열을 더 작은 배열로 분할할 후에, 각 부분 배열을 정렬하고 병합하는 과정을 재귀적으로 반복한다
    public static void sortByMerge(int[] arr, int start, int end) {
        if (start < end) {
            // 분할을 위한 mid 위치 선정
            int mid = (start + end) / 2;
            // 왼쪽 배열 분할 - 재귀호출
            sortByMerge(arr, start, mid);
            // 오른쪽 배열 분할 - 재귀호출
            sortByMerge(arr, mid+1, end);
            // 병합
            merge(arr,start, mid, end);
        }
    }
    // 왼쪽 배열과 오른쪽 배열을 병합하는데, 병합할 때는 왼쪽 배열과 오른쪽 배열의 값을 비교해가면서 정렬처리
    public static void merge(int[] arr, int start, int mid, int end) {
        // 왼쪽 배열
        int[] leftArray = Arrays.copyOfRange(arr, start, mid+1);    // to index는 포함하지않으므로 포함하도록 하기위해 값 1증가
        // 오른쪽 배열
        int[] rightArray = Arrays.copyOfRange(arr, mid + 1, end+1); // to index는 포함하지않으므로 포함하도록 하기위해 값 1증가

        int i=0;    // 왼쪽 배열 포인터
        int j=0;    // 오른쪽 배열 포인터
        int k=start;    // 병합할 배열 포인터

        while (i <= leftArray.length-1 && j <= rightArray.length-1) {
            // 왼쪽과 오른쪽 배열을 비교하는데 왼쪽배열의 값이 큰 경우
            if (leftArray[i] >= rightArray[j]) {
                // 기존배열의 k번째 위치에 오른쪽배열 j번째 위치 값을 대입
                // k,j 값을 증가
                arr[k++] = rightArray[j++];
            } else {    // 왼쪽 배열의 값이 작은 경우
                arr[k++] = leftArray[i++];
            }
        }
        // 위 반복문이 종료되었는데 왼쪽 배열의 요소를 다 복사하지 않은 경우 복사 처리
        while (i <= leftArray.length - 1) {
            arr[k++] = leftArray[i++];
        }
        // 오른쪽 배열의 요소를 다 복사하지 않은 경우 복사 처리
        while (j <= rightArray.length - 1) {
            arr[k++] = rightArray[j++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 20, 55, 43};
        sortByMerge(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {30, 20, 10, 40, 2};
        sortByMerge(arr2, 0, arr2.length - 1);
        System.out.println(Arrays.toString(arr2));

    }
}
