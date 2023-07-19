import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] a = new int[9];
	
		a[0] = Integer.parseInt(st.nextToken());
		int max = a[0];
		
		for (int i = 1; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			a[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, a[i]);
		}
		
		System.out.println(max);
		for (int i = 0; i < a.length; i++) {
			if(max == a[i]) {
				System.out.println(i+1);
				break;
			}
		}
	}
}
