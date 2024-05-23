import java.util.*;

class Solution {
    
    static int dx [] = {-1, 1, 0, 0};
    static int dy [] = {0, 0, -1, 1};
    static int N, M;
    static boolean [][] visited;
    static boolean flag = false;
    
    public int solution(String[] maps) {
        
        N = maps.length;
        M = maps[0].length();
        
        int sX = 0, sY = 0, eX = 0, eY = 0, lX = 0, lY = 0;
        visited = new boolean[N][M];
        
        for(int i = 0; i < maps.length; i++) {
            String temp = maps[i];
            for(int j = 0; j < temp.length(); j++) {
                if(temp.charAt(j) == 'S') 
                {
                    sX = i;
                    sY = j;
                }
                if(temp.charAt(j) == 'E') {
                    eX = i;
                    eY = j;   
                }
                if(temp.charAt(j) == 'L') {
                    lX = i;
                    lY = j;
                }
            }
        }
        
        int answer = 0;
        answer += bfs(sX, sY, lX, lY, maps);
        System.out.println(answer);
        visited = new boolean[N][M];
        answer += bfs(lX, lY, eX, eY, maps);
        System.out.println(answer);
        
        if(flag) {
            answer = -1;
        }
        
        return answer;
    }
    
    int bfs(int startX, int startY, int endX, int endY, String maps[]) {
        Queue<int []> que = new LinkedList();
        que.add(new int [] {startX, startY, 1});
        visited[startX][startY] = true;
        int cost = 0;
        
        while(!que.isEmpty()) {
            int temp [] = que.poll();
            
            for(int i = 0; i < 4; i++) {
                int nX = temp[0] + dx[i];
                int nY = temp[1] + dy[i];
                cost = temp[2];
                
                if(nX == endX && nY == endY) {
                    return cost;
                }
                if(isBoundary(nX, nY) && !visited[nX][nY]) {
                    if(maps[nX].charAt(nY) != 'X') {                        
                        que.add(new int [] {nX, nY, cost+1});
                        visited[nX][nY] = true;
                    }                    
                }
            }         
        }
        
        flag = true;
        return 0;
    }
    
    boolean isBoundary(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}