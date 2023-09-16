package main.java.wanted.leetCode;

import java.util.Stack;

public class RemoveDuplicateSortedArray2 {
    /**
     * 비내림차순으로 정렬된 정수 배열 nums가 주어지면 각 고유 요소가 최대 두 번까지만 나타나도록 일부 중복을 제자리에서 제거합니다.
     * 요소의 상대적 순서는 동일하게 유지되어야 합니다.
     * 일부 언어에서는 배열 길이를 변경할 수 없으므로 결과를 배열 nums의 첫 번째 부분에 배치해야 합니다.
     * 보다 공식적으로, 중복 항목을 제거한 후 k개 요소가 있는 경우 nums의 처음 k개 요소가 최종 결과를 보유해야 합니다.
     * 처음 k개 요소 뒤에 무엇을 남겨두는지는 중요하지 않습니다.
     * 숫자의 첫 번째 k 슬롯에 최종 결과를 넣은 후 k를 반환합니다.
     * 다른 어레이에 추가 공간을 할당하지 마십시오.
     * O(1) 추가 메모리를 사용하여 입력 배열을 내부에서 수정하여 이를 수행해야 합니다.
     */
    public static int removeDuplicates(int[] nums) {
        // Two Pointer 활용
        // 저장할 위치 포인터, 교환 대상 포인터, 중복 Flag
        // 배열의 첫번째 요소에는 어떤 값이 들어와도 상관 없으므로 반복대상 포함x
        // for(i=1; i<배열길이; i++)
        //      if(nums[i] == nums[i-1])
        //          if(중복 플래그가 이미 true)
        //              교환대상포인터+1 -> i를 의미
        //          else - 중복 플래그가 false
        //              중복 허용
        //              num[저장포인터] = nums[i]
        //              저장포인터+1
        //              교환대상포인터+1 -> i를 의미
        //      else - nums[i] != nums[i-1]
        //          nums[저장포인터] = nums[i]
        //          중복 플래그 = false 변경
        //          저장포인터 +1
        //          교환대상포인터+1 -> i를 의미

        boolean flag = false;
        int savePointer = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1]){
                if(flag){
                    continue;
                }
                flag = true;
                nums[savePointer] = nums[i];
                savePointer++;
            }else{
                nums[savePointer] = nums[i];
                savePointer++;
                flag = false;
            }
        }
        return savePointer;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(removeDuplicates(nums));

        int[] nums2 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(removeDuplicates(nums2));
    }
}
