package main.java.wanted.inflearn.sortsearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class LRU {
    /**
     * 문제 : 캐시메모리는 CPU와 주기억장치(DRAM) 사이의 고속의 임시 메모리로서 CPU가 처리할 작업을 저장해 놓았다가
     *       필요할 때 바로 사용해서 처리속도를 높이는 장치이다.
     *       워낙 비싸고 용량이 작아 효율적으로 사용해야 한다.
     *       철수의 컴퓨터는 캐시메모리 사용 규칙이 LRU 알고리즘을 따른다.
     *       LRU 알고리즘은 Least Recently Used의 약자로 직역하자면 가장 최근에 사용되지 않은 것 정도의 의미를 가지고 있습니다.
     *       캐시에서 작업을 제거할 때 가장 오랫동안 사용하지 않은 것을 제거하겠다는 알고리즘입니다.
     *
     *       만약 캐시의 사이즈가 5이고 작업이 2 3 1 6 7 순으로 저장되어 있다면
     *       (맨 앞이 가장 최근에 쓰인 작업이고, 맨 뒤는 가장 오랫동안 쓰이지 않은 작업이다.)
     *
     *       1) Cache Miss : 해야할 작업이 캐시에 없는 상태로 위 상태에서 만약 새로운 작업인 5번 작업을 CPU가 사용한다면
     *                       Cache miss 가 되고 모든 작업이 뒤로 밀리고,  5번 작업은 캐시의 맨 앞에 위치한다.
     *                       5 2 3 1 6 (7번 작업은 캐시에서 삭제)
     *       2) Cache Hit : 해야할 작업이 캐시에 있는 상태로 위 상태에서 만약 3번 작업을 CPU가 사용한다면 Cache Hit 가 되고,
     *                      3번 앞에 있는 5,2번 작업은 한 칸 뒤로 밀리고, 3번이 맨 앞으로 위치하게 된다.
     *                      3 5 2 1 6
     *
     *      캐시의 크기가 주어지고, 캐시가 비어있는 상태에서 N개의 작업을 CPU가 차례로 처리한다면, N개의 작업을 처리한 후
     *      캐시메모리의 상태를 가장 최근 사용된 작업부터 차례대로 출력하는 프로그램을 작성하세요.
     *
     * 입력 : 첫 번째 줄에 캐시의 크기인 S(3<=S<=10)와 작업의 개수 N(5<=N<=1,000)이 입력된다
     *       두 번째 줄에 N개의 작업번호가 처리순으로 주어진다. 작업번호는 1~100이다.
     *
     * 출력 : 마지막 작업 후 캐시메모리의 상태를 가장 최근 사용된 작업부터 차례로 출력합니다.
     *
     * 예시 : 입력 - 5 9                    출력 - 7 5 3 2 6
     *            1 2 3 2 6 2 3 5 7
     */

    public static void solution(int s, int[] job) {
        Stack<Integer> lru = new Stack<>();

        for (int i = 0; i < job.length; i++) {
            // 현재의 job 이 캐시메모리에 존재하는지 확인
            // 존재하면 Cache Hit
            if (lru.contains(job[i])) {
                // Wrapper 클래스로 변환해주지 않으면 remove 메서드가 스택의 index 번호로 동작하게 된다 (의도치 않은 동작)
                // 현재 job 번호와 동일한 번호를 제거해주기 위해서는 Wrapper 클래스로 변환함으로써
                // remove(Object o) 메서드가 동작하도록 해야한다.
                // 만약 Wrapper 클래스로 변환하지 않고 primitive type 인 int 형으로 인자를 넘기면
                // remove(int i) 메서드가 동작하면서 스택의 index 번호로 동작한다.
                lru.remove(new Integer(job[i])); // 스택에서 해당 job 을 제거
                lru.push(job[i]);   // 스택의 최상단에 추가
            } else {
                // Cache Miss
                // 현재 스택의 사이즈가 캐시 메모리의 크기보다 작은지 판단
                // 작으면 스택에 추가
                if (lru.size() < s) {
                    lru.push(job[i]);
                } else {
                    // 스택이 가득차있으므로
                    // 스택 맨마지막 원소는 삭제하고
                    // 현재 job은 스택의 최상단에 추가
                    lru.remove(lru.get(0));
                    lru.push(job[i]);
                }
            }

            System.out.println(lru);
        }

        while (!lru.isEmpty()) {
            System.out.print(lru.pop() + " ");
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sn = br.readLine();
        String[] snArr = sn.split(" ");
        int s = Integer.valueOf(snArr[0]);
        int n = Integer.valueOf(snArr[1]);

        String job = br.readLine();
        String[] jobs = job.split(" ");
        int[] jobArr = new int[jobs.length];
        for (int i = 0; i < jobs.length; i++) {
            jobArr[i] = Integer.valueOf(jobs[i]);
        }

        solution(s, jobArr);
    }

}
