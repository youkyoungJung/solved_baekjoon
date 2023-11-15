import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static int n;
	private static int m;
	private static int[] numbers;
	static StringBuilder sb = new StringBuilder();
	private static int[] arr;
	private static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		numbers = new int[m]; //담을 배열
		isSelected = new boolean[n];
		per(0, 0);
		System.out.println(sb.toString());
	}

	private static void per(int start, int cnt) {
		//기저 조건
		if(cnt == m) {
			for (int i : numbers) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i < n; i++) {
			if(!isSelected[i]) {
				numbers[cnt] = arr[i]; 
				isSelected[i] = true;
				per(i+1, cnt+1);
				isSelected[i] = false;
				
			}
		}
		
	}

}
