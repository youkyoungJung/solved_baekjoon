class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] matrix = new int[n+1][n+1]; //순위 체크할 배열
        
        for(int i=0; i < results.length; i++){
            matrix[results[i][0]][results[i][1]] = 1; // 이김표시
        }
        
        for(int k = 1; k < n+1; k++){
            for(int i = 1; i < n+1; i++){
                for(int j = 1; j < n+1; j++){
                    if(matrix[i][k] == 1 && matrix[k][j] == 1){
                        matrix[i][j] = 1; //순위 연결 표시
                    }
                }
            }
        }
        
        //최종 matrix 바탕으로 순위 구하기
        for(int i = 1; i < n+1; i++){
            int count = 0;
            for(int j = 1; j < n+1; j++){
                if(matrix[i][j] == 1 || matrix[j][i] == 1){
                    count++;
                }
            }
            if(count == n-1){
                answer++;
            }
        }
      
        return answer;
    }
}