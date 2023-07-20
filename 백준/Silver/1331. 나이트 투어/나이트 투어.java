import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static String str[];
	static boolean[][] arr; // visited
	static boolean flag;
	static int[][] dict = { { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 }, { -2, 1 }, { -1, 2 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		str = new String[37];
		arr = new boolean[6][6]; // visited
		flag = true;

		// 입력 받기, 현재, 다음
		for (int i = 0; i < 36; i++) {
			st = new StringTokenizer(br.readLine());
			str[i] = st.nextToken();
		}
		// 마지막 - 첫번째 인덱스 설정
		str[36] = str[0];

		int index = 0;
		while (index < 36) {
			String current = str[index];
			String next = str[index + 1];

			int current_x = current.charAt(0) - 'A';
			int current_y = current.charAt(1) - '0' - 1;

			// 현재 위치 true
			arr[current_y][current_x] = true;

			int next_x = next.charAt(0) - 'A';
			int next_y = next.charAt(1) - '0' - 1;

			// current 위치에서 8가지 방향으로 돌때 next 위치를 만나면 flag를 true
			boolean isTrue = false;
			for (int d = 0; d < 8; d++) {
				// current 에서 다음 위치가 될 수 있는 것
				int arrive_x = current_x + dict[d][0];
				int arrive_y = current_y + dict[d][1];

				if(!(arrive_x >= 0 && arrive_x < 6 && arrive_y >= 0 && arrive_y <6))
					continue;
				
				if (next_x == arrive_x && next_y == arrive_y) {
					isTrue = true;
					break;
				}
			}
			if (!isTrue) {
				flag = false;
				System.out.println("Invalid");
				return;
			}
			if (arr[next_y][next_x]) {
				if (index != 35) {
					flag = false;
					System.out.println("Invalid");
					return;
				}
			}
			index++;
		}
		if (flag) {
			System.out.println("Valid");
		}
	}

}