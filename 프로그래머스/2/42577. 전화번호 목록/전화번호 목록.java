import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        boolean answer = true;
        
        for(int i=0; i < phone_book.length-1; i++){
           if(phone_book[i+1].startsWith(phone_book[i])){
               answer = false;
               // System.out.println(phone_book[i]);
           }
        }
        
        
        return answer;
    }
}