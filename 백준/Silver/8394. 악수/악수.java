import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// input
		int N = Integer.parseInt(br.readLine());
		
		// solution
		long[] dp = new long[N+1];
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i=3; i<=N; i++) {
			dp[i] = (dp[i-2] + dp[i-1]) % 10;
		}
		
		// output
		System.out.println(dp[N]);
	}
}
