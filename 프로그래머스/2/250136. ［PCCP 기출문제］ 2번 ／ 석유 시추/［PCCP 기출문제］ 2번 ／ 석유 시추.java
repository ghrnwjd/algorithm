import java.util.*;

class Solution {
    
    static int dx [] = {-1, 1, 0, 0}; 
    static int dy [] = {0, 0, -1, 1};
    static boolean [][] visited;
    static int landX, landY;    
    static int map[][];
    static int oil [];
    
    public int solution(int[][] land) {
        landX = land.length;
        landY = land[0].length;
        visited = new boolean[landX][landY];  
        oil = new int [landY];
        map = land;   
        
        for(int i = 0; i < landY; i++) {     
            for(int j = 0; j < landX; j++) {
                if(map[j][i] == 1 && !visited[j][i]) {                    
                    bfs(j,i);
                }                
            }            
        }       
        return Arrays.stream(oil).max().getAsInt();
    }
    
    
    public void bfs(int x, int y)
    {
        Queue<int []> que = new LinkedList<>();
        que.add(new int [] {x, y});
        visited[x][y] = true;
        int answer = 1;
        
        Set<Integer> oilIdx = new HashSet<>();
        
        while(!que.isEmpty()) {
            int [] temp = que.poll();
            int nX = temp[0];
            int nY = temp[1];
            
            oilIdx.add(nY);
            
            for(int i = 0; i < 4; i++) {
                int tempX = nX + dx[i];
                int tempY = nY + dy[i];
                if(isInside(tempX, tempY) && map[tempX][tempY] == 1 ) {
                    if(!visited[tempX][tempY]) {
                        que.add(new int [] {tempX,tempY});
                        visited[tempX][tempY] = true;
                        answer++;
                    }                    
                }
            }
        }
        
        for(int idx : oilIdx) {
            oil[idx] += answer;
        }
    }
    
    public boolean isInside(int x, int y) {
        return x >=0 && x < landX && y >= 0 && y < landY;
    }
}