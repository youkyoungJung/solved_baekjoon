import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int king = Integer.parseInt(st.nextToken());
		int queen = Integer.parseInt(st.nextToken());
		int look = Integer.parseInt(st.nextToken());
		int bee = Integer.parseInt(st.nextToken());
		int night = Integer.parseInt(st.nextToken());
		int phone = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[6];
		arr[0] = (king - 1) * (-1);
		arr[1] = (queen - 1) * (-1);
		arr[2] = (look - 2) * (-1);
		arr[3] = (bee - 2) * (-1);
		arr[4] = (night - 2) * (-1);
		arr[5] = (phone - 8) * (-1);
		
		for (int i : arr) {
			System.out.printf("%d ", i);
		}
	}
}
