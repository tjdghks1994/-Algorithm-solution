package main.java.wanted.leetCode;

public class MinimumSizeSubarraySum {

    /**
     * 양의 정수 배열 nums와 양의 정수 target이 주어지면, a의 최소 길이를 반환합니다.
     * 하위 배열(a) 그 합계가 목표보다 크거나 같습니다.
     * 해당 하위 배열이 없으면 대신 0을 반환합니다.
     * <p>
     * 예시 1
     * Input: target = 7, nums = [2,3,1,2,4,3]
     * Output: 2
     * 설명 : 하위 배열 [4,3]은 문제 제약 조건 하에서 최소 길이를 갖습니다.
     * <p>
     * 예시 2
     * Input: target = 4, nums = [1,4,4]
     * Output: 1
     * <p>
     * 예시 3
     * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
     * Output: 0
     */

    public static int minSubArrayLen(int target, int[] nums) {
        // 하위 배열의 합이 양의 정수의 합보다 크거나 같은 하위 배열을 찾는 것이 목표
        // 하위 배열의 길이는 고정이 아닌 형태
        // 즉 Sliding Window 를 윈도우크기가 고정이 아닌 가변인 형태로 문제해결을 접근해야 한다
        // 첫번째 index부터 윈도우크기를 1부터~배열의 크기까지 늘리면서 하위 배열의 합을 구한다
        // 첫번째 index를 담은 변수 - startIndex 선언
        // 윈도우 크기를 담은 변수 - windowSize 선언
        // 배열의 합을 담은 변수 - arrSum 선언 -> 최초의 값은 첫번째 index 요소의 값으로
        // 최소 배열의 길이를 담은 변수 - minArrLength 선언 초기값은 정수의 최대값으로 선언

        // while(startIndex <= 배열크기 && 윈도우크기 <= 배열크기) - 반복문 진행
        //	 현재 배열의 합이 target보다 작은지 비교하고 작다면 윈도우크기를 증가시키고 증가된 범위 값을 arrSum에 더하고 다음 반복문 진행
        //   만약 windowSize - 1 + startIndex 값이 배열의 길이와 크거나 같은 경우라면 더이상 진행될 수 없으므로 반복문 종료 처리
        //   위의 분기처리에 해당되는 경우가 없다면, 현재 하위배열의 합이 target보다 크거나 같은것을 의미
        //   이전 minArrLength 값보다 현재 windowSize의 값이 작은지 비교를 통해 minArrLength 값 저장
        //   현재 startIndex 이후의 값으로 시작하는 하위배열들 중에서도 확인을 위해 현재 startIndex의 요소 값을 배열의 합에서 제거
        //   startIndex는 1증가시키고, windowSize는 1감소

        // while 반복문이 종료되었는데도 minArrLength의 값이 초기에 선언한 정수의 최대값 그대로라면 0을 반환

        int minArrLength = Integer.MAX_VALUE;
        int startIndex = 0;
        int windowSize = 1;
        int arrSum = nums[0];   // 최초 배열의 합은 첫번째 index 요소의 값으로

        while (startIndex <= nums.length && windowSize <= nums.length) {

            if (arrSum < target) {
                windowSize++;
                if (windowSize - 1 + startIndex >= nums.length) {
                    break;
                }
                arrSum += nums[windowSize - 1 + startIndex];
                continue;
            }

            minArrLength = minArrLength > windowSize ? windowSize : minArrLength;
            arrSum -= nums[startIndex]; // 윈도우 이동처리를 위해 기존 합계에서 제외
            startIndex++;
            windowSize--;
        }

        if(minArrLength == Integer.MAX_VALUE) return 0;

        return minArrLength;
    }


    public static void main(String[] args) {
        int nums[] = {1, 1, 1, 1, 1, 1, 1, 1};
        int target = 11;
        System.out.println(minSubArrayLen(target, nums));

        int nums2[] = {2, 3, 1, 2, 4, 3};
        int target2 = 7;
        System.out.println(minSubArrayLen(target2, nums2));

        int nums3[] = {1, 2, 3, 4, 5};
        int target3 = 11;
        System.out.println(minSubArrayLen(target3, nums3));

        int nums4[] = {5, 1, 3, 5, 10, 7, 4, 9, 2, 8};
        int target4 = 15;
        System.out.println(minSubArrayLen(target4, nums4));
    }
}
