import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int target;
    static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            res = 0;
            target = Integer.parseInt(br.readLine());

            go(0, 0);
            sb.append(res).append("\n");
        }
        System.out.println(sb.toString());
    }   // end of main

    public static void go(int cnt, int sum){
        // 기저 조건
        if(sum == target){
            res++;
            return;
        }

        if(cnt >= target){
            return;
        }

        for(int i = 1; i <= 3; i++){
            sum += i;
            go(cnt + 1, sum);
            sum -= i;
        }

    }

} // end of class
