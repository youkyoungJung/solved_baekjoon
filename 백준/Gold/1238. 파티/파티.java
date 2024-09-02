import jdk.dynalink.NoSuchDynamicMethodException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int X;
    static ArrayList<ArrayList<Node>> city;
    static ArrayList<ArrayList<Node>> city2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        //초기화
        city = new ArrayList<>(N+1);
        city2 = new ArrayList<>(N+1);
        for(int i = 0; i <= N; i++) {
            city.add(new ArrayList<>());
            city2.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            city.get(s).add(new Node(e, t));
            city2.get(e).add(new Node(s, t));
        }

        int[] des1 = new int[N+1];
        dijkstra(des1, city, X);

        int[] des2 = new int[N+1];
        dijkstra(des2, city2, X);

        System.out.println(goAnswer(des1, des2));

    }// end of main

    static void dijkstra(int[] des, ArrayList<ArrayList<Node>> city, int x){
        boolean[] visited = new boolean[N+1];

        Arrays.fill(des, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(x, 0));
        des[x] = 0;
        while(!pq.isEmpty()){
            Node node = pq.poll();

            if(visited[node.end]){
                continue;
            }
            visited[node.end] = true;

            for(Node next : city.get(node.end)){
                if(des[next.end] > des[node.end] + next.value){
                    des[next.end] = des[node.end] + next.value;
                    pq.offer(new Node(next.end, des[next.end]));
                }
            }
        }
//        System.out.println(Arrays.toString(des));
    }

    static int goAnswer(int[] des1, int[] des2){
        int answer = Integer.MIN_VALUE;
        for(int i = 1; i <= N; i++){
            answer = Math.max(answer, des1[i] + des2[i]);
        }
        return answer;
    }

    static class Node implements Comparable<Node>{
        int end;
        int value;

        public Node(int end, int value){
            this.end = end;
            this.value = value;
        }

        public int compareTo(Node n){
            return Integer.compare(this.value, n.value);
        }
    }

} // end of class
