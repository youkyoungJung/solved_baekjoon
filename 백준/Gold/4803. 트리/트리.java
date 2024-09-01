// 자바 코드 예시
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static boolean hasCycle;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int idx = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) break;

            //초기화
            graph = new ArrayList<>(n+1);
            for(int i = 0; i <= n; i++){
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            int count = 0;
            visited = new boolean[n+1];
            for(int i = 1; i <= n; i++){
                if(!visited[i]){
                    hasCycle = false;
                    dfs(i, 0);
                    if(!hasCycle){
                        count++;
                    }
                }
            }

            sb.append("Case ").append(idx).append(": ");
            if (count == 0) sb.append("No trees.").append("\n");
            else if (count == 1) sb.append("There is one tree.").append("\n");
            else sb.append("A forest of " + count + " trees.").append("\n");

            idx++;
        }

        System.out.println(sb);
    }// end of main

    static void dfs(int node, int parent) {
        visited[node] = true;
        for (int adj : graph.get(node)) {
            if (!visited[adj]) {
                dfs(adj, node);
            } else if (adj != parent) {
                hasCycle = true;
            }
        }
    }
} // end of class
