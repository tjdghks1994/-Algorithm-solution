package main.java.wanted;

import java.util.Arrays;

public class RotateArray {

    /**
     * 정수 배열 nums가 주어지면 배열을 k 단계만큼 오른쪽으로 회전합니다.
     * 여기서 k는 음수가 아닙니다.
     *
     * 예시 1
     * 입력: 숫자 = [1,2,3,4,5,6,7], k = 3
     * 출력: [5,6,7,1,2,3,4]
     * 설명:
     * 오른쪽으로 1단계 회전: [7,1,2,3,4,5,6]
     * 오른쪽으로 2단계 회전: [6,7,1,2,3,4,5]
     * 오른쪽으로 3단계 회전: [5,6,7,1,2,3,4]
     *
     * 예시 2
     * 입력: 숫자 = [-1,-100,3,99], k = 2
     * 출력: [3,99,-1,-100]
     * 설명:
     * 오른쪽으로 1단계 회전: [99,-1,-100,3]
     * 오른쪽으로 2단계 회전: [3,99,-1,-100]
     */

    public static void rotate(int[] nums, int k) {
        // 요소가 오른쪽으로 이동될 때 해당 요소들의 규칙을 찾아본다
        // k의 값이 배열의 길이를 초과하는 경우가 있을 수 있으므로 k의 값을 배열길이와 나머지 연산을 한다
        // (k의 값이 배열의 길이 이상인 경우 모든 요소가 k/배열길이 만큼 원래 자기자신의 위치를 회전한 것이므로)
        // index 의 값을 index+k 위치로 이동시킨다
        // 만약 index+k 값이 배열의 마지막 index 를 넘는 값이라면
        // index 의 값을 (index+k) % 배열길이 위치로 이동시킨다

        k = k % nums.length;
        int[] saveArray = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i + k > nums.length - 1) {
                saveArray[(i + k) % nums.length] = nums[i];
            } else {
                saveArray[i + k] = nums[i];
            }
        }

        System.arraycopy( saveArray, 0, nums, 0, saveArray.length );
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 3;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));

        int[] nums2 = {-1, -100, 3, 99};
        int k2 = 3;
        rotate(nums2, k2);
        System.out.println(Arrays.toString(nums2));

    }
}
