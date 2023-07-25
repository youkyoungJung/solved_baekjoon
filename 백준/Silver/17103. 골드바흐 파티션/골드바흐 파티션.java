
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

//문자열
public class Main {
	static List<Integer> hset = new ArrayList<>();
	static boolean[] checked = new boolean[1000001];
 
	static int primeNumber(int n) {
		
		int answer = 0;

		for (int i : hset) {
			if (i>n/2) {
				break;
			}
			if(!(checked[n - i])) {
				answer++;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(); // test_case 수
		
		// 소수 구하기
		// 소수구하기
		for (int i = 2; i * i <= 1000000; i++) {
			for (int j = i * 2; j <= 1000000; j += i) {
				if (j % i == 0) {
					checked[j] = true;
				}
			}
		}

		for (int i = 2; i < checked.length; i++) {
			if(!checked[i]) {
				hset.add(i);
			}
		}
//		System.out.println(hset);		
		for(int i = 0; i < t; i++) {
			int n = sc.nextInt(); // 주어진 값
			System.out.println(primeNumber(n));
		}
	}

}
