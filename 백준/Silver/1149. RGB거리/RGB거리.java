import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// input
		int N = Integer.parseInt(br.readLine());
		int[][] colors = new int[N][3];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				colors[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// solution
		int[][] dp = new int[N][3];
		for(int i=0; i<3; i++) dp[0][i] = colors[0][i];
		for(int i=1; i<N; i++) {
			dp[i][0] = Math.min(dp[i-1][1] + colors[i][0], dp[i-1][2] + colors[i][0]);
			dp[i][1] = Math.min(dp[i-1][0] + colors[i][1], dp[i-1][2] + colors[i][1]);
			dp[i][2] = Math.min(dp[i-1][0] + colors[i][2], dp[i-1][1] + colors[i][2]);
		}
		
		// output
		System.out.println(Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2])));
	}

}
