import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int arr[][] = new int[9][9];
		
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = arr[0][0];
		int ni = 0;
		int nj = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if(max < arr[i][j]) {
					max = Math.max(max, arr[i][j]);
					ni = i;
					nj = j;
				}
			}
		}
		System.out.println(max);
		System.out.printf("%d %d", ni+1, nj+1);
	}

}
