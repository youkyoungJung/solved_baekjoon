import java.util.*;

class Solution {
    boolean[] isVisited;
    int len;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        isVisited = new boolean[n];
        len = n;
        
        
       for(int i=0; i < n; i++){
           if(!isVisited[i]){
               isVisited[i] = true;
               bfs(i, computers);
               answer++;
           }
           
       }
         
        return answer;
    }
    public void bfs(int x, int[][] computers){
        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.offer(x);
        // System.out.println(len);
        while(!queue.isEmpty()){
            int num = queue.poll();
            
            for(int i = 0; i < len; i++){
                if(computers[num][i] == 1 && !isVisited[i]){
                    queue.offer(i);
                    // System.out.println(i);
                    isVisited[i] = true;
                }
            }
                
        }
        
    }//end bfs
}