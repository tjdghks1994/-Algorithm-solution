package main.java.wanted;

import java.util.Arrays;

public class MajorityElement {
    /**
     * 크기가 n인 배열의 숫자가 주어지면 다수 요소를 반환합니다.
     * 다수 요소는 ⌊n / 2⌋ 이상 나타나는 요소입니다.
     * 다수 요소는 배열에 항상 존재한다고 가정할 수 있습니다.
     *
     * Example 1:
     * Input: nums = [3,2,3]
     * Output: 3
     *
     * Example 2:
     * Input: nums = [2,2,1,1,1,2,2]
     * Output: 2
     */

    public static int majorityElement(int[] nums) {
        // 우선 배열의 주어진 요소들을 정렬한다 (오름차순)
        // 요소 포인터, 비교대상 포인터, 다수 요소, 다수 요소 갯수
        // for(int i=0; i<배열크기; i++)
        //      if( 비교대상포인터 요소와 요소포인터 요소 값이 다름 )
        //          비교대상포인터 - 요소포인터의 값은 = 요소의 갯수를 의미
        //          if(요소의 갯수가 n/2 이상의 값)
        //              다수 요소 = nums[요소 포인터]
        //              다수 요소 갯수 = 비교대상포인터 - 요소포인터
        //          요소 값이 다르면 요소 포인터의 위치를 비교대상포인로 변경
        //      if(비교대상포인터 위치가 배열의 마지막 위치면서 비교대상포인터 요소와 요소포인터 요소 값이 같음)
        //          비교대상포인터-요소포인터+1의 값이 현재 다수 요수 갯수보다 큰지 판단하고 다수 요수를 선정

        Arrays.sort(nums);

        int indexPointer = 0;
        int majorNumber = 0;
        int majorNumberCnt = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[indexPointer]) {
                if (i - indexPointer >= nums.length / 2) {
                    majorNumber = nums[indexPointer];
                    majorNumberCnt = i - indexPointer;
                }
                indexPointer = i;
            }

            if (i == nums.length - 1 && nums[i] == nums[indexPointer]) {
                majorNumber = i - indexPointer + 1 > majorNumberCnt ? nums[indexPointer] : majorNumber;
            }
        }

        return majorNumber;
    }

    public static void main(String[] args) {
        int[] nums = {6, 5, 5};
        System.out.println(majorityElement(nums));

        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums2));

        int[] nums3 = {1};
        System.out.println(majorityElement(nums3));

        int[] nums4 = {2, 2};
        System.out.println(majorityElement(nums4));

    }
}
