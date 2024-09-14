import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] rgb = new int[3][n+1];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			rgb[0][i] = Integer.parseInt(st.nextToken());
			rgb[1][i] = Integer.parseInt(st.nextToken());
			rgb[2][i] = Integer.parseInt(st.nextToken());
		} //입력 끝
		
		int[][] dp = new int[3][n];
		
	    //dp 0행 채우기. rgb[i][0]값. - 초기화
		for(int i = 0; i < 3; i++) {
			dp[i][0] = rgb[i][0];
		}
		
		int index = 0;
		int min = Integer.MAX_VALUE;
		for (int j = 1; j < n; j++) { //집 개수
			
			dp[0][j] = rgb[0][j] + Math.min(dp[1][j-1], dp[2][j-1]);
			dp[1][j] = rgb[1][j] + Math.min(dp[0][j-1], dp[2][j-1]);
			dp[2][j] = rgb[2][j] + Math.min(dp[0][j-1], dp[1][j-1]);
			
		}
			
		System.out.println(Math.min(dp[0][n-1], Math.min(dp[1][n-1], dp[2][n-1])));
					
	}

}
