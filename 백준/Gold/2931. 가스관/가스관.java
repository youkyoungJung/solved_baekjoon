import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[R][C];
		for(int r=0; r<R; r++) {
			String input = br.readLine();
			for(int c=0; c<C; c++) {
				map[r][c] = input.charAt(c);
			}
		}
		
		// solution
		int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
		Map<Integer, Character> numToDirection = new HashMap<>();
		String tmp = "34-21|+";
		int[] idx = new int[] {9, 5, 3, 10, 6, 12, 15};
		for(int i = 0; i < 7; i++) {
			numToDirection.put(idx[i], tmp.charAt(i));
		}
		
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(map[r][c] != '.') continue;
				int flag = 0;
				for(int d=0; d<4; d++) {
					int nr = r + directions[d][0];
					int nc = c + directions[d][1];
					if(!(nr>=0 && nr<R && nc>=0 && nc<C) || map[nr][nc] == '.') continue;
					if(nr == r-1) {
						if("|14+".contains(String.valueOf(map[nr][nc]))) {
							flag += 1 << 3;
						}
					} else if(nr == r+1) {
						if("|32+".contains(String.valueOf(map[nr][nc]))) {
							flag += 1 << 2;
						}
					}
					else if(nc == c-1) {
						if("-12+".contains(String.valueOf(map[nr][nc]))) {
							flag += 1 << 0;
						}
					} else {
						if("-34+".contains(String.valueOf(map[nr][nc]))) {
							flag += 1 << 1;
						}
					}
				}
				
				if(numToDirection.containsKey(flag)) {
					sb.append(r+1).append(" ").append(c+1).append(" ").append(numToDirection.get(flag));
				}
			}
		}
		
		System.out.println(sb);
	}

}
