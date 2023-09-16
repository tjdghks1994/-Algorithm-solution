package main.java.wanted;

import java.util.Arrays;

public class RemoveElement {
    /**
     * 정수 배열 nums와 정수 val이 주어졌을 때, nums에서 val이 포함된 모든 항목을 제자리에서 제거합니다.
     * 요소의 순서는 변경될 수 있습니다. 그런 다음 nums에서 val과 같지 않은 요소의 수를 반환합니다.
     * nums에서 val과 같지 않은 요소의 개수가 k라고 가정할 때, 이를 허용하려면 다음과 같은 작업을 수행해야 합니다:
     * nums의 처음 k 요소에 val과 같지 않은 요소가 포함되도록 배열 nums를 변경합니다.
     * nums의 나머지 요소는 무엇을 남겨두든지 중요하지 않습니다.
     * k를 반환합니다.
     */

    public static int removeElement(int[] nums, int val) {
        // Two Pointer 알고리즘을 활용해보자
        // 배열의 첫번째 원소와 배열의 마지막 원소를 2개의 포인터로 두고
        // if (배열 첫번째 원소부터 val와 비교하여 동일한 값이라면)
        //      삭제 처리를 위해 서로의 값을 체인지 한다
        //      삭제 처리한 경우 삭제될 값이 배열의 뒤로 이동된 것이므로
        //      뒤에 있던 포인터를 한 칸 앞으로 변경한다
        // if (배열 첫번째 원소부터 val와 비교하여 동일한 값이 아니라면)
        //      다음 원소의 값을 val와 비교하기 위해
        //      앞쪽 포인터를 한 칸 뒤로 변경한다
        // 종료가 되기위한 조건은 앞 포인터가 뒤 포인터의 값보다 큰 경우 종료한다

        int removeCnt = 0;  // 삭제 요소 갯수
        int frontPointer = 0;   // 배열의 첫번째 요소 포인터
        int lastPointer = nums.length - 1;  // 배열의 마지막 요소 포인터

        while (frontPointer <= lastPointer) {

            if (nums[frontPointer] == val) {
                int tmp = nums[frontPointer];
                nums[frontPointer] = nums[lastPointer];
                nums[lastPointer] = tmp;
                lastPointer--;
                removeCnt++;
            } else {
                frontPointer++;
            }

        }
        // val과 같지 않은 요소 (삭제되지 않은 요수 개수 반환)
        return nums.length-removeCnt;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        System.out.println(removeElement(nums, val));

        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int val2 = 2;
        System.out.println(removeElement(nums2, val2));
    }
}
