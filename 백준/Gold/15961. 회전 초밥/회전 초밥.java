import java.io.*;
import java.util.*;

public class Main {
	static int N, d, k, c;
	static int[] sushis;
	static boolean hasCoupon = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// input
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		sushis = new int[N];
		for(int i=0; i<N; i++) sushis[i] = Integer.parseInt(br.readLine());
		
		// solution
		int maxCnt = slide();
		
		// output
		System.out.println(maxCnt);
	}

	static int slide() {
		int maxCnt = Integer.MIN_VALUE;
		Set<Integer> set = new HashSet<>();
		int[] duplicated = new int[d+1];
		
		for(int i=0; i<k; i++) {
			set.add(sushis[i]);
			duplicated[sushis[i]]++;
		}
		maxCnt = maxCnt < set.size() ? set.size() : maxCnt;
		if(!set.contains(c)) maxCnt++;
		
		for(int i=1; i<N; i++) {
			if(duplicated[sushis[i-1]] == 1) set.remove(sushis[i-1]);
			duplicated[sushis[i-1]]--;
			
			set.add(sushis[(i + k - 1) % N]);
			duplicated[sushis[(i + k - 1) % N]]++;
			
			int cnt = set.size();
			if(!set.contains(c)) cnt++;
			maxCnt = maxCnt < cnt ? cnt : maxCnt;
		}
		
		return maxCnt;
	}
}
