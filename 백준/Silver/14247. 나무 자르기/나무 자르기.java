import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Pair> pairs = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            pairs.add(new Pair(0, 0));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pairs.get(i).tree = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pairs.get(i).speed = Integer.parseInt(st.nextToken());
        }

        Queue<Pair> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.speed, o2.speed));
        for (int i = 0; i < N; i++) {
            queue.add(pairs.get(i));
        }

        int index = 0;
        long answer = 0;
        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            answer += ((long) pair.tree + ((long) pair.speed * index));
            index++;
        }
        System.out.println(answer);

    }// end of main

    public static class Pair {
        int tree;
        int speed;

        public Pair(int tree, int speed) {
            this.tree = tree;
            this.speed = speed;
        }

    }

}//end of class
