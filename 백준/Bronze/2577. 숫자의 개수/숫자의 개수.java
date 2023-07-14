import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int multi = a*b*c;
		String s = Integer.toString(multi);
		
		int[] checked = new int[10];
		
		for(int i=0; i < s.length(); i++) {
			for(int j = 0; j < 10; j++) {
				if(j == s.charAt(i)-'0') {
					checked[s.charAt(i)-'0']++;
				}
			}
			
		}
		for(int i=0; i<10; i++) {
			System.out.println(checked[i]);
		}
	}

}
