import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String[] st = new String[n];
		for(int i=0; i<n; i++) {
			st[i] = sc.next();
		}
		
// 배열을 특정 규칙에 의해 정렬하고 싶은 경우 Arrays.sort메서드에
//	Comparator을 구현하면된다.
		Arrays.sort(st, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				//길이가 같은 경우
				if(o1.length() == o2.length()) {
					return o1.compareTo(o2); //사전순 정렬
				}else {
					return o1.length() - o2.length();
				}
			}
		});
		System.out.println(st[0]);
		
		for (int i = 1; i < n; i++) {
			//중복되지 않는 단어만 출력
			if(!st[i].equals(st[i-1])) {
				System.out.println(st[i]);
			}
		}

		
	}

}
