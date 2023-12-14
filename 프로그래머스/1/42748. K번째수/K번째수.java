import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int[] command : commands) {
            int start = command[0] - 1;
            int end = command[1];
            int target = command[2] - 1;

            int[] res = Arrays.copyOfRange(array, start, end);
            Arrays.sort(res);
            answer.add(res[target]);
            // System.out.println(answer);
        }
        int[] result = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++){
            result[i] = answer.get(i);
        }
        return result;
    }
}