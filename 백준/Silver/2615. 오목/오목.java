import java.io.*;
import java.util.*;

public class Main {

    static int[][] board = new int[20][20];
    static int[][] directions = {{0, 1}, {1, 0}, {1, 1}, {-1, 1}}; // 가로, 세로, 대각선(우하향, 좌하향)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 바둑판 입력
        for (int i = 1; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 20; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 결과 탐색
        for (int i = 1; i < 20; i++) {
            for (int j = 1; j < 20; j++) {
                if (board[i][j] != 0) {
                    int winner = board[i][j];

                    for (int d = 0; d < 4; d++) {
                        int cnt = countStones(i, j, winner, directions[d]);
                        if (cnt == 5) {
                            // 앞쪽에 더 이어진 바둑알이 없는지 확인
                            int prevR = i - directions[d][0];
                            int prevC = j - directions[d][1];
                            if (isValid(prevR, prevC) && board[prevR][prevC] == winner) {
                                continue;
                            }

                            // 승리한 경우 출력
                            System.out.println(winner);
                            System.out.println(i + " " + j);
                            return;
                        }
                    }
                }
            }
        }

        System.out.println(0);
    }

    static int countStones(int r, int c, int color, int[] dir) {
        int cnt = 1;
        int nr = r + dir[0];
        int nc = c + dir[1];

        while (isValid(nr, nc) && board[nr][nc] == color) {
            cnt++;
            nr += dir[0];
            nc += dir[1];
        }

        return cnt;
    }

    static boolean isValid(int r, int c) {
        return r >= 1 && r <= 19 && c >= 1 && c <= 19;
    }
}
