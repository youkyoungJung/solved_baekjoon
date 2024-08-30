import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;

    static ArrayList<ArrayList<Location>> city;
    static StringBuilder sb = new StringBuilder();
    static int[] des;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        city = new ArrayList<>(N+1);
        des = new int[N+1];
        for(int i = 0; i <= N; i++) {
            city.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            city.get(a).add(new Location(b, v));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int destination = Integer.parseInt(st.nextToken());

        dijkstra(start);
//        System.out.println(Arrays.toString(des));
        System.out.println(des[destination]);

    } // end of main

    public static void dijkstra(int start) {

        boolean[] isVisited = new boolean[N+1];
        Arrays.fill(des, Integer.MAX_VALUE);
        des[start]= 0;

        PriorityQueue<Location> pq = new PriorityQueue<>();
        pq.add(new Location(start, 0));

        while(!pq.isEmpty()){
            Location current = pq.poll();

            if(isVisited[current.end]) continue;
            isVisited[current.end] = true;

            for(Location next : city.get(current.end)) {
                if(des[next.end] > des[current.end] + next.value){
                    des[next.end] = des[current.end] + next.value;
                    pq.offer(new Location(next.end, des[next.end]));
                }
            }
        }

    }

    public static class Location implements Comparable<Location> {
        int end;
        int value;

        public Location(int end, int value) {
            this.end = end;
            this.value = value;
        }

        public int compareTo(Location o) {
            return this.value - o.value;
        }

    }


}//end of class
