package main.java.wanted;
public class ValidPalindrome {

    /**
     * 모든 대문자를 소문자로 변환하고 영숫자가 아닌 문자를 모두 제거한 후 앞뒤로 동일하게 읽는 경우 구문은 회문입니다.
     * 문자에는 문자와 숫자가 포함됩니다.
     * 문자열 s가 주어지면 회문이면 true 를 반환하고, 그렇지 않으면 false 를 반환합니다.
     *
     * 예시 1
     * 입력: s = "A man, a plan, a canal: Panama"
     * 출력: true
     * 설명: "amanaplanacanalpanama"는 회문입니다.
     *
     * 예시 2
     * 입력: s = "race a car"
     * 출력: false
     * 설명: "raceacar"는 회문이 아닙니다.
     *
     * 예시 3
     * 입력: s = " "
     * 출력: true
     * 설명: s는 영숫자가 아닌 문자를 제거한 후의 빈 문자열 ""입니다.
     * 빈 문자열은 앞뒤로 동일하게 읽으므로 회문입니다.
     */

    public static boolean isPalindrome(String s) {
        // 문자열을 먼저 소문자로 변환
        // 위의 작업을 진행하고나서 문자열의 길이가 0인 경우에는 빈 문자열을 의미하므로 바로 true 반환 후 함수 종료 처리
        // 위의 작업을 진행하고나서 문자열의 길이가 1인 경우에는 회문 조건에 포함되므로 true 반환 후 함수 종료 처리

        // 해당 문자열이 회문인지 체크하기 위한 변수 선언 - isPalindrome = true
        // leftPointer = 0, rightPointer = 문자열 길이-1;
        // 문자열에 영문이나 숫자가 한번도 존재하지 않는 문자열인지 체크하기 위한 변수 선언 - isAlphanumeric = false
        // index에 해당하는 문자가 영문,숫자인지 체크하기 위해 아스키 코드 값 활용
        // 문자의 아스키 코드 값이 48~57이면 숫자, 97~122이면 영어소문자 이다

        // for(왼쪽 포인터가 오른쪽 포인터보다 값이 작거나 같을 때 까지만 실행) - 왼쪽 포인터랑 오른쪽 포인터가 교차하는 경우 종료를 위해
        //      int leftCharAscii = 문자열의 왼쪽 포인터가 가리키는 문자의 아스키 코드 값
        //      int rightCharAscii = 문자열의 오른쪽 포인터가 가리키는 문자의 아스키 코드 값
        //         왼쪽 포인터가 가리키는 문자가 영문소문자,숫자가 아닌경우 왼쪽 포인터를 1증가 (비교할 필요가 없는 문자이므로)
        //      if(! (leftCharAscii >= 48 && leftCharAscii <= 57) || (leftCharAscii >= 97 && leftCharAscii <= 122) )
        //          leftPointer++
        //          다음 반복문 진행
        //         오른쪽 포인터가 가리키는 문자가 영문소문자,숫자가 아닌경우 오른쪽 포인터를 1감소 (비교할 필요가 없는 문자이므로)
        //      if(! (rightCharAscii >= 48 && rightCharAscii <= 57) || (rightCharAscii >= 97 && rightCharAscii <= 122) )
        //          rightPointer--
        //          다음 반복문 진행

        //      위 조건문들이 실행되지 않은 경우에 isAlphanumeric = true,
        //      왼쪽포인터와 오른쪽포인터가 가리키는 문자를 비교
        //      두 포인터가 가리키는 문자열이 일치하지 않는경우, 회문이 아니므로 바로 종료
        //      if (leftCharAscii != rightCharAscii)
        //          문자열 회문 체크 변수 = false
        //          break

        //      두 포인터가 가리키는 문자열이 일치하는 경우, 다음 확인을 위한 포인터값 증가 및 감소 처리
        //      leftPointer++, rightPointer--

        //      반복문이 종료되었는데 isAlphanumeric = false 인 경우에는
        //      모두 제거되어야할 문자만 있었음을 의미하므로 회문이라 판단하고 문자열 회문 체크 변수 = true

        s = s.toLowerCase();

        if (s.length() == 0 || s.length() == 1) {
            return true;
        }

        int leftPointer = 0;
        int rightPointer = s.length() - 1;
        boolean isAlphanumeric = false;
        boolean isPalindrome = true;

        for (int i=leftPointer; leftPointer <= rightPointer; i++) {
            int leftCharAscii = s.charAt(leftPointer);
            int rightCharAscii = s.charAt(rightPointer);

            if (! ((leftCharAscii >= 48 && leftCharAscii <= 57) || (leftCharAscii >= 97 && leftCharAscii <= 122))) {
                leftPointer++;
                continue;
            }
            if (! ((rightCharAscii >= 48 && rightCharAscii <= 57) || (rightCharAscii >= 97 && rightCharAscii <= 122))) {
                rightPointer--;
                continue;
            }

            isAlphanumeric = true;

            if (leftCharAscii != rightCharAscii) {
                isPalindrome = false;
                break;
            }

            leftPointer++;
            rightPointer--;
        }

        if (!isAlphanumeric) {
            isPalindrome = true;
        }

        return isPalindrome;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        String s3 = " ";
        String s4 = "a.";
        String s5 = ".,";

        System.out.println(isPalindrome(s));
        System.out.println(isPalindrome(s2));
        System.out.println(isPalindrome(s3));
        System.out.println(isPalindrome(s4));
        System.out.println(isPalindrome(s5));

    }
}
