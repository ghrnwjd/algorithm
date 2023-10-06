class Solution {
    static int dx [] = {0, 1, 0, -1};
    static int dy [] = {1, 0, -1, 0};
    static int size;
    public int[][] solution(int n) {
        
         int[][] answer = new int [n][n];
        boolean visited [][] = new boolean [n][n];
        size = n;

        int num = 1;
        int rotation = 0;
        int x = 0;
        int y = 0;
        answer[0][0] = 1;
        visited[0][0] = true;
        while(true) {
              if(num >= n*n) {
                    break;
              }
              if(isBoundary(x + dx[rotation], y + dy[rotation]) && !visited[x + dx[rotation]][y + dy[rotation]]) {
                    x = x + dx[rotation];
                    y = y + dy[rotation];
                    num = num + 1;
                    answer[x][y] = num;
                    visited[x][y] = true;
              }
              else {
                    rotation = (rotation + 1) % 4;
              }
        }
        return answer;
    }
    
    public boolean isBoundary(int x, int y) {
        return x>=0 && x < size && y>= 0 && y < size;
    }
}