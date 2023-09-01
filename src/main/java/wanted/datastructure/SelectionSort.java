package main.java.wanted.datastructure;

public class SelectionSort {    // 선택 정렬 구현

    // for(i=0; i<배열크기; i++)
    //  최소값의 배열 위치를 임시로 저장할 변수 선언
    //  for(j=i+1; j<배열크기; j++)
    //      if(arr[최소값 배열 위치] < 배열[j] 값)
    //          최소값 배열 위치 = j;
    //  현재 i의 위치에 있는 값과 최소값 배열 위치에 있는 값을 swap
    //  임시 변수 = arr[i];
    //  arr[i] = arr[최소값 배열 위치];
    //  arr[최소값 배열 위치] = 임시 변수;
    public static void sortBySelection(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minNumIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[minNumIndex] > arr[j]) {
                    minNumIndex = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[minNumIndex];
            arr[minNumIndex] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};

        sortBySelection(arr);

        for (int e : arr) {
            System.out.print(e + ", ");
        }
    }
}
