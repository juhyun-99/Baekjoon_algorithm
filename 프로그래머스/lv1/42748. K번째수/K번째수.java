import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++){
            int size = commands[i][1] - commands[i][0] + 1;
            int[] tmp = new int[size];
            for(int j = 0; j < size; j++){
                tmp[j] = array[commands[i][0] - 1 + j];
            }
            Arrays.sort(tmp);
            System.out.println(Arrays.toString(tmp));
            
            answer[i] = tmp[commands[i][2] - 1];
        }
        return answer;
    }
}