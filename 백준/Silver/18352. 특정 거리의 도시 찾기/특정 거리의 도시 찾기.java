import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int K;
    static int X;
    static ArrayList<ArrayList<Integer>> city;
    static ArrayList<Integer> answer = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        city = new ArrayList<>(N+1);

        for(int i = 0; i <= N; i++) {
            city.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            city.get(a).add(b);
        }

        dijkstra();

        System.out.println(sb.length() == 0 ? -1 : sb.toString());

    } // end of main

    public static void dijkstra() {
        boolean[] isVisited = new boolean[N+1];
        int[] distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[X] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[]{X, 0});

        while(!pq.isEmpty()) {
            int[] current = pq.poll();

            if(isVisited[current[0]]) {
                continue;
            }

            isVisited[current[0]] = true;

            for(int next : city.get(current[0])) {
                if(distance[next] > distance[current[0]] + 1) {
                    distance[next] = distance[current[0]] + 1;
                    pq.offer(new int[]{next, distance[next]});
                }
            }
        }
        check(distance);
//        System.out.println(Arrays.toString(distance));
    }

    public static void check(int[] distance) {
        for(int i = 1; i <= N; i++) {
            if(distance[i] == K) {
                sb.append(i).append("\n");
            }
        }
    }

}//end of class
