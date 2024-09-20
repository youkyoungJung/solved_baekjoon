import java.util.*;

class Location implements Comparable<Location> {
    int x;
    int y;

    public Location(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int compareTo(Location o) {
        int res = Integer.compare(this.x, o.x);
        if (res == 0) {
            res = Integer.compare(this.y, o.y);
        }
        return res;
    }
}

class Solution {

    int answer = 0;
    List<List<Location>> game_puzzle = new ArrayList<>();
    List<List<Location>> table_puzzle = new ArrayList<>();
    int n;
    int m;
    int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    boolean[][] gVisited;
    boolean[][] tVisited;
    int len;

    public int solution(int[][] game_board, int[][] table) {

        n = game_board.length;
        m = game_board[0].length;


        gVisited = new boolean[n][n];
        tVisited = new boolean[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(game_board[i][j] == 1){
                    game_board[i][j] = 0;
                }else{
                    game_board[i][j] = 1;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!gVisited[i][j] && game_board[i][j] == 1){
                    bfs(i, j, game_board, gVisited, game_puzzle);
                }
                if(!tVisited[i][j] && table[i][j] == 1){
                    bfs(i, j, table, tVisited, table_puzzle);
                }

            }
        }
        System.out.println(game_puzzle.size());
        System.out.println(table_puzzle.size());
        // System.out.println(table_puzzle.get(0).get(0).r);
        checkPuzzle();
        return answer;
    }

    public void checkPuzzle(){
        int table_size = table_puzzle.size();
        int game_size = game_puzzle.size();
        
        boolean[] isVisited = new boolean[game_size];

        for(int i = 0; i < table_size; i++){
            for(int j = 0; j < game_size; j++){
                if(isVisited[j] || table_puzzle.get(i).size() != game_puzzle.get(j).size()) 
                    continue;
                if(isRotate(game_puzzle.get(j), table_puzzle.get(i))){
                    isVisited[j] = true;
                    answer += game_puzzle.get(j).size();
                    // System.out.println("chk_puzzle: " + Arrays.toString(isVisited));
                    // System.out.println("answer: " + answer);
                    break;
                }
            }
        }
    }

    public boolean isRotate(List<Location> game, List<Location> table)
    {
        Collections.sort(game);

        //회전
        for(int i = 0; i < 4; i++){
            Collections.sort(table);

            int ny = table.get(0).y;
            int nx = table.get(0).x;

            for(int j = 0; j < table.size(); j++){
                table.get(j).x -= nx;
                table.get(j).y -= ny;
            } //변경 완료

            boolean checked = true;
            for(int j = 0; j < game.size(); j++){
                if(game.get(j).x != table.get(j).x || game.get(j).y != table.get(j).y){
                    checked = false;
                    break;
                }
            }

            if(checked){
                return true;
            }
            else{
                
                for(int j = 0; j < table.size(); j++){
                    int temp = table.get(j).x;
                    table.get(j).x = table.get(j).y;
                    table.get(j).y = -temp;
                }
            }
        }
        return false;

    }
    public void bfs(int x, int y, int[][] board, boolean[][] isVisited, List<List<Location>> puzzles){
        List<Location> sub_puzzles = new ArrayList<>();
        sub_puzzles.add(new Location(0, 0));

        Queue<Location> queue = new ArrayDeque<>();
        queue.offer(new Location(x, y));
        isVisited[x][y] = true;

        while(!queue.isEmpty()){
            Location current  = queue.poll();

            for(int i = 0; i < 4; i++){
                int nx = current.x + dist[i][0];
                int ny = current.y + dist[i][1];

                if(isChecked(nx, ny)){
                    if(!isVisited[nx][ny] && board[nx][ny] == 1){
                        isVisited[nx][ny] = true;
                        queue.offer(new Location(nx, ny));
                        sub_puzzles.add(new Location(nx - x, ny - y));
                    }
                }
            }
        }// end of while
        puzzles.add(sub_puzzles);
    }

    public boolean isChecked(int nr, int nc){
        return nr >= 0 && nr < n && nc >= 0 && nc < m;
    }

}