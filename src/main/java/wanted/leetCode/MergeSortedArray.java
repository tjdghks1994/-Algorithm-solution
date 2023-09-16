package main.java.wanted.leetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSortedArray {

    /**
     * 감소하지 않는 순서로 정렬된 두 개의 정수 배열 nums1 및 nums2와 각각 nums1 및 nums2의 요소 수를 나타내는 두 개의 정수 m 및 n이 제공됩니다.
     * nums1과 nums2를 감소하지 않는 순서로 정렬된 단일 배열로 병합합니다.
     * 최종 정렬된 배열은 함수에 의해 반환되지 않고 대신 배열 nums1 내에 저장되어야 합니다.
     * 이를 수용하기 위해 nums1의 길이는 m + n 입니다.
     * 여기서 nums1 배열의 m개 요소는 병합해야 하는 요소를 나타내고 마지막 n개 요소는 0으로 설정되어 무시되어야 합니다.
     * nums2의 길이는 n 입니다.
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // nums1의 배열 요소가 0개인 case는 nums2 요소의 값을 그대로 반환
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
        }

        // nums1과 nums2 배열을 병합
        // 병합을 하는 과정에서 각 배열의 맨 마지막 요소부터 서로 비교하여
        // 큰 숫자를 배열의 끝 순서부터 저장
        for (int i = m - 1, j = n - 1; j >= 0; i--, j--) {
            // nums1 배열의 요소가 전부 이동되고
            // nums2 배열의 요소를 남은 위치에 저장해야하는 경우
            if (i <= -1) {
                nums1[j] = nums2[j];
                continue;
            }

            // nums1 배열의 요소가 큰 경우
            if (nums1[i] > nums2[j]) {
                // 현재 비교하고 있는 각 배열요소의 index의 합 + 1 위치에 nums1 배열 요소의 값을 저장
                nums1[i + j + 1] = nums1[i];
                j = j + 1;  // nums2 배열의 요소는 같은 요소로 비교하기 위해 j 변수 값을 유지하도록 설정
            } else {    // 그 외의 경우 ( 서로 값이 동일하거나 nums2 배열의 요소가 큰 경우)
                // 현재 비교하고 있는 각 배열요소의 index의 합 + 1 위치에 nums2 배열 요소의 값을 저장
                nums1[i + j + 1] = nums2[j];
                i = i + 1;  // nums1 배열의 요소는 같은 요소로 비교하기 위해 i 변수 값을 유지하도록 설정
            }
        }

    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int nums1l = 3;
        int[] nums2 = {2, 5, 6};
        int nums2l = 3;

        merge(nums1, nums1l, nums2, nums2l);
        System.out.println(Arrays.toString(nums1));

        int[] nums3 = {1};
        int nums3l = 1;
        int[] nums4 = {};
        int nums4l = 0;
        merge(nums3, nums3l, nums4, nums4l);
        System.out.println(Arrays.toString(nums3));

        int[] nums5 = {0};
        int nums5l = 0;
        int[] nums6 = {1};
        int nums6l = 1;
        merge(nums5, nums5l, nums6, nums6l);
        System.out.println(Arrays.toString(nums5));

        int[] nums7 = {2,0};
        int nums7l = 1;
        int[] nums8 = {1};
        int nums8l = 1;
        merge(nums7, nums7l, nums8, nums8l);
        System.out.println(Arrays.toString(nums7));
    }
}
