import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int answer = 0;
        ArrayList<Integer> tall = new ArrayList<>(N);
        ArrayList<Integer> diffTall = new ArrayList<>(N-1);

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int current = Integer.parseInt(st.nextToken());
            tall.add(current);

            if(i > 0){
                diffTall.add(current - tall.get(i-1));
            }
        }

        Collections.sort(diffTall);

        for(int i = 0; i < N-K; i++){
            answer += diffTall.get(i);
        }
        System.out.println(answer);

    }// end of main

}//end of class
