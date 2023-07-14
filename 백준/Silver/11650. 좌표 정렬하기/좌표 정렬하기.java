import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

//좌표 정렬하기
public class Main {

	public static void main(String[] args) throws IOException {
		//Array.sort의 Comparable 이용하기
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][2];
		
		//입력받기
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				//x좌표가 증가하는 순으로 ,x좌표가 같으면 y좌표가 증가하는 순서로
				//정렬
				if(o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				else {
					return o1[0] - o2[0];
				}
				
			}
		});
		
		for(int i=0; i<n; i++) {
			System.out.println(arr[i][0] + " "+ arr[i][1]);
		}
	}

}
