import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][3];
        int[][] dp = new int[N][3];
        int[][] dp2 = new int[N][3];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (i == 0) {
                    dp[i][j] = arr[i][j];
                    dp2[i][j] = arr[i][j];
                }
            }
        }

        for(int i = 1; i < N; i++){
            for (int j = 0; j < 3; j++){
                dp[i][j] =  arr[i][j] + Math.max(j <= 1 ? dp[i - 1][0] : Integer.MIN_VALUE,
                        Math.max(dp[i - 1][1], j >= 1 ? dp[i - 1][2] : Integer.MIN_VALUE));
                dp2[i][j] = arr[i][j] + Math.min(j <= 1 ? dp2[i - 1][0] : Integer.MAX_VALUE,
                        Math.min(dp2[i - 1][1], j >= 1 ? dp2[i - 1][2] : Integer.MAX_VALUE));
            }
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++){
            max = Math.max(max, dp[N-1][i]);
            min = Math.min(min, dp2[N-1][i]);
        }

        System.out.println(max + " " + min);

    }   // end of main

} // end of class
