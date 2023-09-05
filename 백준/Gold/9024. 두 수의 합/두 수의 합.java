import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 정수 몇개
			int K = Integer.parseInt(st.nextToken()); // key

			int[] S = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < S.length; j++) {
				S[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(S); // 정수 정렬
			
			int s = 0; // 첫 포인터
			int e = n - 1; // 끝 포인터
			int min = Integer.MAX_VALUE; // 지금까지 가장 차이가 작은 값

			int cnt = 0;
			while (s < e) {
				int sum = (S[s] + S[e]);
				
				if (Math.abs(sum-K) < Math.abs(min-K)) {
					min = sum;
					cnt = 1;
				}else if(Math.abs(sum-K) == Math.abs(min-K)){
					cnt++;
				}
				
				if(sum > K) {
					e--;
				}else {
					s++;
				}

			} // while 끝

			sb.append(cnt).append("\n");

		} // test_case

		System.out.println(sb.toString());
	}// main

}// class
