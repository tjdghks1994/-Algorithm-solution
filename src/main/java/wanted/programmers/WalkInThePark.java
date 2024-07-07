package main.java.wanted.programmers;

import java.util.Arrays;

public class WalkInThePark {

    public static int[] solution(String[] park, String[] routes) {
        String[][] parkArr = new String[park.length][park[0].length()];
        int startI = Integer.MIN_VALUE;
        int startJ = Integer.MIN_VALUE;
        int[] result = new int[2];

        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                String parkStr = park[i].substring(j, j + 1);
                parkArr[i][j] = parkStr;
                if (parkStr.equals("S")) {
                    startI = i;
                    startJ = j;
                }
            }
        }

        for (int k = 0; k < routes.length; k++) {
            String[] splitRoutes = routes[k].split(" ");
            String direction = splitRoutes[0];
            int distance = Integer.valueOf(splitRoutes[1]);
            boolean check = true;
            int move = Integer.MIN_VALUE;

            switch (direction) {
                case "E" :
                    move = startJ+1;
                    // 명령어를 실행하는데 문제가 없는지 확인
                    for (int q = 0; q < distance; q++) {
                        if (move > parkArr[startI].length-1 || parkArr[startI][move].equals("X")) {
                            check = false;
                            break;
                        }
                        move++;
                    }

                    if (check) {
                        startJ += distance;
                    }

                    break;
                case "S":
                    move = startI+1;
                    // 명령어를 실행하는데 문제가 없는지 확인
                    for (int q = 0; q < distance; q++) {
                        if (move > parkArr[startJ].length-1 || parkArr[move][startJ].equals("X") ) {
                            check = false;
                            break;
                        }
                        move++;
                    }

                    if (check) {
                        startI += distance;
                    }

                    break;
                case "W":
                    move = startJ-1;
                    // 명령어를 실행하는데 문제가 없는지 확인
                    for (int q = 0; q < distance; q++) {
                        if (move < 0 || parkArr[startI][move].equals("X")) {
                            check = false;
                            break;
                        }
                        move--;
                    }

                    if (check) {
                        startJ -= distance;
                    }

                    break;
                case "N":
                    move = startI-1;
                    // 명령어를 실행하는데 문제가 없는지 확인
                    for (int q = 0; q < distance; q++) {
                        if (move < 0 || parkArr[move][startJ].equals("X")) {
                            check = false;
                            break;
                        }
                        move--;
                    }

                    if (check) {
                        startI -= distance;
                    }

                    break;
            }
        }

        result[0] = startI;
        result[1] = startJ;

        return result;
    }

    public static void main(String[] args) {
        String[] park = {"SOO", "OOO", "OOO"};
        String[] routes = {"E 2", "S 2", "W 1"};
        System.out.println(Arrays.toString(solution(park, routes)));

        String[] park2 = {"SOO", "OXX", "OOO"};
        String[] routes2 = {"E 2", "S 2", "W 1"};
        System.out.println(Arrays.toString(solution(park2, routes2)));

        String[] park3 = {"OSO","OOO","OXO","OOO"};
        String[] routes3 = {"E 2", "S 3", "W 1"};
        System.out.println(Arrays.toString(solution(park3, routes3)));
    }
}
