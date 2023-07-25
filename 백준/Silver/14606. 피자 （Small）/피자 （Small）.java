import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] dp = new int[11];
		int n = sc.nextInt();
		
		dp[1] = 0;
		
		for (int i = 2; i < n+1; i++) {
			dp[i] = (i/2)*(i-(i/2)) + dp[(i/2)]+dp[i-(i/2)];
		}
	
		System.out.println(dp[n]);
	}

}
