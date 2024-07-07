package main.java.wanted.inflearn.tpsw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 공통원소구하기 {
    public static void solution(int[] arr1, int[] arr2) {
        ArrayList<Integer> result = new ArrayList<>();
        // arr1, arr2 정렬
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int lp = 0;
        int rp = 0;

        while (lp < arr1.length && rp < arr2.length) {
            if (arr1[lp] == arr2[rp]) {
                result.add(arr1[lp]);
                lp++;
                rp++;
            } else if (arr1[lp] > arr2[rp]) {
                rp++;
            } else {
                lp++;
            }
        }

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cnt1 = in.nextInt();
        int[] arr1 = new int[cnt1];
        for (int i = 0; i < cnt1; i++) {
            arr1[i] = in.nextInt();
        }
        int cnt2 = in.nextInt();
        int[] arr2 = new int[cnt2];
        for (int i = 0; i < cnt2; i++) {
            arr2[i] = in.nextInt();
        }

        solution(arr1, arr2);
    }
}
