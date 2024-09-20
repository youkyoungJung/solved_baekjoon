import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] result = new int[commands.length];
        
        for(int test = 0; test < commands.length; test++){
            ArrayList<Integer> list = new ArrayList<>();
            int start = commands[test][0];
            int end = commands[test][1];
            int k = commands[test][2];
            
            for(int i = start; i <= end; i++){
                list.add(array[i-1]);
            }
            Collections.sort(list);
            result[test] = list.get(k-1);
        }
        
        // int[] result = {0};
        return result;
    }
}