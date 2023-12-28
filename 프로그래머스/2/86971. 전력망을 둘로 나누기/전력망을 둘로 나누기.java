import java.util.*;

class Solution {
    int[][] graph;
    boolean[] isVisited;
    int answer = 10001;
    
    public int solution(int n, int[][] wires) {
        
        graph = new int[n+1][n+1]; //graph
        
        for(int i = 0; i < wires.length; i++){//wires
            int s = wires[i][0];
            int e = wires[i][1];
            
            graph[s][e] = graph[e][s] = 1; //양방향 그래프
        }
        
        for(int i = 0; i < wires.length; i++){ //1 부터 n 까지 하나씩 지우기
            isVisited = new boolean[n+1];
            int s = wires[i][0];
            int e = wires[i][1];
            
            graph[s][e] = graph[e][s] = 0; //그래프 끊기
            
            int cnt = dfs(s, n);
            answer = Math.min(answer, Math.abs(cnt-(n-cnt)));
            
            graph[s][e] = graph[e][s] = 1; //그래프 다시 추가
            
        }
        
        return answer;
        
    }// end of main
    
    public int dfs(int node, int n){ //node 들어왔을 때
        isVisited[node] = true;
        int cnt = 1;
        
        for(int i = 1; i <= n; i++){
           if(!isVisited[i] && graph[node][i] == 1){
               cnt += dfs(i, n);
           }
        }
        return cnt;
        
    }
    
    
}//end of class