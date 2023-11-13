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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		numbers = new int[m];
		per(1, 0);
		System.out.println(sb.toString());
	}

	public static void per(int start, int depth) {

		// 기저조건
		if (depth == m) {
//			System.out.println(Arrays.toString(numbers));
			answer(numbers);
			return;
		}

		for (int i = start; i <= n; i++) {
			numbers[depth] = i;
			per(i, depth + 1);

		}
	}// end per
	
	public static void answer(int[] numbers) {
		for (int i : numbers) {
			sb.append(i).append(" ");
		}
		sb.append("\n");
	}

}
