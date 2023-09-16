package main.java.wanted;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class RemoveDuplicateSortedArray {

    /**
     * 비내림차순으로 정렬된 정수 배열 nums가 주어지면 각 고유 요소가 한 번만 나타나도록 중복 항목을 제자리에서 제거합니다.
     * 요소의 상대적 순서는 동일하게 유지되어야 합니다.
     * 그런 다음 고유 요소를 nums로 반환합니다.
     * nums의 고유 요소 수를 k로 간주하고 승인하려면 다음 작업을 수행해야 합니다.
     * nums의 첫 번째 k 요소가 처음에 nums에 있었던 순서대로 고유한 요소를 포함하도록 배열 nums를 변경합니다.
     * nums의 k 번째 요소 이후에 무엇을 남겨두는지는 중요하지 않습니다.
     * k를 반환합니다.
     */

    public static int removeDuplicates(int[] nums) {
        // Two Pointer 알고리즘을 활용해보자
        // 배열의 첫번째 원소와 두번째 원소를 각 포인터의 시작 위치로 지정한다 ( 같은 방향으로 진행 )
        // 포인터들 요소의 값을 비교하는 반복문 실행
        // if( 각 포인터의 요소 값이 동일한 경우 )
        //      뒷 포인터의 값을 +1 (중복되지 않는 요소를 찾기 위해)
        //      중복 요소 카운트 +1
        // if( 각 포인터의 요소 값이 서로 다른면서 앞 포인터의 위치랑 뒷 포인터의 위치 차이가 1보다 큰 경우 )
        //      앞 포인터가 가리키는 요소의 다음요소와 뒷 포인터가 가리키는 요소 자리 체인지
        //      앞 포인터 +1, 뒷 포인터 +1
        // if( 각 포인터의 요소 값이 서로 다른면서 앞 포인터의 위치랑 뒷 포인터의 위치 차이가 1보다 작거나 같은 경우 )
        //      앞 포인터와 뒷 포인터의 값을 +1
        // 반복문 종료 조건으로는 뒷 포인터의 값이 배열의 길이와 동일해지면 종료

        int frontPointer = 0;
        int nextPointer = 1;
        int duplicateCnt = 0;

        while (nextPointer != nums.length) {
            if (nums[frontPointer] == nums[nextPointer]) {
                nextPointer++;
                duplicateCnt++;
            } else {
                if (nextPointer - frontPointer > 1) {
                    int tmp = nums[nextPointer];
                    nums[nextPointer] = nums[frontPointer + 1];
                    nums[frontPointer + 1] = tmp;
                    frontPointer++;
                    nextPointer++;
                } else {
                    frontPointer++;
                    nextPointer++;
                }
            }

        }

        return nums.length - duplicateCnt;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(removeDuplicates(nums));

        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums2));

    }
}
