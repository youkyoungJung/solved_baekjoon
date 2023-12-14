import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            char current = s.charAt(i);
            if(current == '('){
                stack.push(current);
            }
           
            else if(current == ')' && stack.isEmpty()){
                return false;
            }else if(current == ')'){
                stack.pop();
            }
        }
        if(!stack.isEmpty()){
            answer = false;
        }
        return answer;
    }
}