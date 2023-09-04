import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 벼락치기
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); //단원 개수
		int T = Integer.parseInt(st.nextToken()); //시험까지 공부 할 수 있는 총 시간
		
		//시간으로 접근하기 0, 1, 2, .. T 시간
		int[] times = new int[T+1];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int K = Integer.parseInt(st.nextToken()); //각 단원 별 예상 공부 시간
			int S = Integer.parseInt(st.nextToken()); // 그 단원 문제의 배점
			
			
			for (int j = T; j >= K; j--) {
				
				if(times[j] < S + times[j-K]) {
					times[j] = S + times[j-K];
				}
			}
			
		
		} //for 끝
		System.out.println(times[T]);

	}

}
