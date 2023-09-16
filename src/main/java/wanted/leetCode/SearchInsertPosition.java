package main.java.wanted.leetCode;

public class SearchInsertPosition {
    /**
     * 고유한 정수의 정렬된 배열과 대상 값이 주어지고 대상이 발견되면 인덱스를 반환합니다.
     * 그렇지 않은 경우 순서대로 삽입되었을 경우의 인덱스를 반환합니다.
     * O(log n) 런타임 복잡도를 갖는 알고리즘을 작성해야 합니다.
     *
     * Example 1
     * Input: nums = [1,3,5,6], target = 5
     * Output: 2
     *
     * Example 2
     * Input: nums = [1,3,5,6], target = 2
     * Output: 1
     *
     * Example 3
     * Input: nums = [1,3,5,6], target = 7
     * Output: 4
     */

    public static int searchInsert(int[] nums, int target) {
        // binary search 알고리즘
        // 입력이 정렬된 배열이므로 따로 정렬할 필요는 없다
        // 처음 Index를 가리키는 변수 선언, 마지막 Index를 가리키는 변수 선언
        // while(처음 Index <= 마지막 Index)
        // 중간 Index를 가리키는 변수 선언 - 중간 index는 (처음 Index+마지막 Index) / 2 의 값을 가진다
        // if(중간 index의 요소 값이 target과 값이 같으면)
        //      해당 index를 반환하고
        // if(중간 index의 요소 값이 target 보다 작다면)
        //      중간 index+1부터 마지막 index 위치에 존재하는지 확인해야 하므로, 처음 Index 변수의 값을 변경 시킨 후, 반복문을 다시 진행하도록 한다
        // if( 중간 index의 요소 값이 target 보다 크다면)
        //      첫번째 index부터 중간 index-1 위치에 존재하는지 확인해야 하므로, 마지막 Index 변수의 값을 변경 시킨 후, 반복문을 다시 진행하도록 한다
        // 즉, 처음 Index와 마지막 Index 값을 계속 변경시키면서 배열의 찾는 범위를 반으로 계속 줄여나가면 된다

        // 반복문이 종료되면 변경된 firstIndex 값을 반환하도록 한다

        int firstSearchIndex = 0;
        int lastSearchIndex = nums.length - 1;

        while (firstSearchIndex <= lastSearchIndex) {
            int middleSearchIndex = (firstSearchIndex + lastSearchIndex) / 2;

            if (nums[middleSearchIndex] == target) {
                return middleSearchIndex;
            }
            if (nums[middleSearchIndex] > target) {
                lastSearchIndex = middleSearchIndex - 1;
            }
            if (nums[middleSearchIndex] < target) {
                firstSearchIndex = middleSearchIndex + 1;
            }
        }

        return firstSearchIndex;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        int target2 = 2;
        int target3 = 7;
        int[] nums2 = {3, 5, 7, 9, 10};
        int target4 = 8;

        System.out.println(searchInsert(nums, target));
        System.out.println(searchInsert(nums, target2));
        System.out.println(searchInsert(nums, target3));
        System.out.println(searchInsert(nums2, target4));
    }
}
