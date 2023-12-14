import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0;  i< numbers.length; i++){
            arr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(arr, (o1, o2) -> (o2+o1).compareTo(o1+o2));
        // System.out.println(Arrays.toString(arr));
        
        for(String i : arr){
            sb.append(i);
        }
        
        answer = sb.toString();
        if(answer.charAt(0) == '0') 
            return "0";
        return answer;
    }
}