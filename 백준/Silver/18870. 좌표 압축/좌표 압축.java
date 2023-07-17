import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 정렬
 * @author SSAFY
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		int[] s_arr = new int[n];
		//rank를 매길 HashMap 
		HashMap<Integer, Integer> rankingMap = new HashMap<Integer,Integer>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = s_arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//정렬
		Arrays.sort(s_arr);
		/*for (int i : s_arr) {
			System.out.println(i);
		}*/
		
		//정렬된 배열을 순회하면서 map에 넣어주기
		int rank = 0;
		for (int i : s_arr) {
			//만약 앞 원소가 이미 순위가 매개졌다면 중복x, 
			if(!rankingMap.containsKey(i)) {
				rankingMap.put(i, rank);
				rank++;
			}
		}
		
		//원본 배열을 차례대로 순회하면서 해당 원소에 대한  rank를 갖고온다.
		//StringBuilder : 변경 가능한 문자열을 만들어줌. - String을 합치는 작업 시 하나의 대안
		StringBuilder sb = new StringBuilder();
		for(int key : arr) {
			int ranking = rankingMap.get(key);
			sb.append(ranking).append(' ');
		}
		System.out.println(sb);
		
	}

}
