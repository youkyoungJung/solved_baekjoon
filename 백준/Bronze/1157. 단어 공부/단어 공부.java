import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[26]; //영문자의 개수는 26개
		String str = sc.next().toUpperCase();
		
		//System.out.println(str.charAt(0)-65);
		for (int i = 0; i < str.length(); i++) {
			arr[str.charAt(i) - 65]++;
		}
		int max = Integer.MIN_VALUE;
		char ch = '?';
		
		for(int i = 0; i < arr.length; i++) {
			if(max < arr[i]) {
				max = arr[i];
				ch = (char)(i+65);
			}
			else if(arr[i] == max) {
				ch = '?';
			}
		}
		System.out.println(ch);
		
	}
}
