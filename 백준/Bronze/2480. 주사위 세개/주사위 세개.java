import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[3];
		for(int i = 0; i < 3; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//arr 을 돌면서 i 번째 해당 max 값 구하기
		int max = 0;
		int mi = 0;
		for (int i = 0; i < arr.length; i++) {
			int sum= 0;
			int ni = i;
			for (int j = 0; j < arr.length; j++) {
				if(arr[ni] == arr[j]) {
					sum++;
				}
				if(max < sum) {
					max = Math.max(max, sum);
					mi = ni;
				}
			}
			
		}
		
		int answer = 0;
		if(max == 3) {
			answer = 10000 + ((arr[mi]*1000));
		}else if(max == 2) {
			answer = 1000 + ((arr[mi]*100));
		}else {
			max = 0;
			for (int j = 0; j < arr.length; j++) {
				max = Math.max(max, arr[j]);
			}
			answer = max * 100;
		}
		
		System.out.println(answer);
	}

}
