import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

/**
 * 평범한 배낭
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); //물품의 수
		int K = Integer.parseInt(st.nextToken()); //버틸 수 있는 무게
		
		int[] bag = new int[K+1];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int W = Integer.parseInt(st.nextToken()); //무게
			int V = Integer.parseInt(st.nextToken()); //물건 가치
			
			for (int j = K; j >= W; j--) {
				if(bag[j] < V+bag[j-W]) {
					bag[j] = V + bag[j-W];
				}
			}
			
		}
		System.out.println(bag[K]);
		
		
		//배낭에 넣을 수 있는 물건들의 가치합의 최댓값 구하기
		// 배낭이 버틸 수 있는 무게(K = 7)
		// 0  1   2  3   4   5   6   7
		//                       13+bag[7-6] 넣을 수 있음
		//               8 + bag[7-4]
		//           6 + bag[7-3]
		//                   12 + bag[7-5]
		
		//0  1  2  3  4  5  6  7 
	//                      13 13
		//            8  8  13 13
		//         6  8  8  13 14 
					
	}

}
