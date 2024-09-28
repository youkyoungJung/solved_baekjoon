import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(n == 1){
            System.out.println(0);
            return;
        }
        // 점프 점프
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0}); // 재환이 위치는 왼쪽 끝
        visited[0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll(); //재환이 현재 위치

            for(int i = 1; i <= arr[cur[0]]; i++){
                if(!visited[cur[0]+i] && cur[0]+i < n){ //방문x, 범위안

                    if(cur[0]+i == n-1){
                        System.out.println(cur[1]+1);
                        return;
                    }
                    queue.add(new int[]{cur[0]+i, cur[1]+1});
                    visited[cur[0]+i] = true;
                }
            }

        }

        System.out.println(-1);
    }//end of main
}//end of class
