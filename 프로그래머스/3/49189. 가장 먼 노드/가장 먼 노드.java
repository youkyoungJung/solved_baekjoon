import java.util.*;

class Solution {
    
    public int solution(int n, int[][] edge) {//노드의 개수, 간선의 정보
        List<Integer>[] graph = new ArrayList[n+1];
        for(int i=0; i < n+1; i++){
            graph[i] = new ArrayList<Integer>();
        }//그래프 초기화

        for(int i = 0; i < edge.length; i++){
            graph[edge[i][0]].add(edge[i][1]);
            graph[edge[i][1]].add(edge[i][0]);
        }
        
        int[] res = new int[n+1];
        boolean[] isVisited = new boolean[n+1];
        
        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(new int[]{1, 0}); //정점, cnt
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int num = current[0];
            int cnt = current[1];
            
            if(isVisited[num]){
                continue;
            } //방문된 코드면 continue
            
            res[num] = cnt;
            isVisited[num] = true; //방문체크
            for(int i = 0; i < graph[num].size(); i++){
                int next = graph[num].get(i);
                queue.offer(new int[]{next, cnt+1});
            }
        }
        
        
        int max = -1;
        int answer = 0;
        System.out.println(Arrays.toString(res));
        
        for(int i = 1; i < n+1; i++){
            if(max < res[i]){
                max = res[i];
                answer = 0;
            }
            if(res[i] == max){
                answer++;
            }
        }
        
        return answer;
    }
}