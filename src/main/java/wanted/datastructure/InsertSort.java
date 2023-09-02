package main.java.wanted.datastructure;

import java.util.Arrays;

public class InsertSort { // 삽입 정렬

    // 삽입 정렬(Insertion Sort)는 “이미 정렬된” 크기가 1인 배열에 하나씩 원소를 “삽입”하여
    // 정렬된 크기가 n인 배열을 만드는 알고리즘
    // 삽입할 대상을 가리키는 index의 값과 삽입할 대상 전까지의 배열 요소들(비교대상)을 비교하여
    // 삽입할 원소의 값이 비교대상보다 커지면 비교대상의 다음 index 위치에 원소를 삽입한다
    public static void sortByInsert(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int pointer = i - 1;    // 비교대상 index
            int currentValue = arr[i];  // 삽입할 원소 값
            // 비교대상 index가 배열범위이면서 비교대상 index의 위치한 값이 삽입할 원소 값보다 큰 경우에만 반복
            while (pointer >= 0 && arr[pointer] > currentValue) {
                arr[pointer + 1] = arr[pointer];    // 비교대상이 값이 더크므로 뒤로 한칸 이동
                pointer--;  // 다음 비교를 위해 비교대상 index를 감소
            }
            // 반복문이 종료되었다는건 비교대상 index에 위치한 값보다 삽입할 원소 값이 크다는 의미
            // 비교대상 index +1 위치에 원소를 삽입한다
            arr[pointer + 1] = currentValue;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 38, 44, 47, 15, 36, 26};
        sortByInsert(arr);
        System.out.println(Arrays.toString(arr));

    }
}
