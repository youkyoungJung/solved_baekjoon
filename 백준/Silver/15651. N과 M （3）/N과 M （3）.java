import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int n;
	private static int m;
	private static int[] numbers;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		numbers = new int[m];
		per(0);
		System.out.println(sb.toString());
		
	}//end main
	
	public static void per(int depth) {
		//기저조건
		if(depth == m) {
			for (int i = 0; i < m; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			numbers[depth] = i;
			per(depth+1);
		}
		
	}

}//end class
