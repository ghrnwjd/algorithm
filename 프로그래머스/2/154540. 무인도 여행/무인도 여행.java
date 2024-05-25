import java.util.*;

class Solution {
    static int map [][];
    static boolean visited[][];
    static int N, M;
    static int dx [] = {-1, 1, 0 ,0};
    static int dy [] = {0, 0, -1, 1};
    public int[] solution(String[] maps) {
        
        N = maps.length;
        M = maps[0].length();
        
        map = new int [N][M];
        visited = new boolean[N][M];
        
        for(int i = 0; i < N; i++) {
            String temp = maps[i];
            for(int j = 0; j < M; j++) {
                if(temp.charAt(j) == 'X') {
                    map[i][j] = -1;
                }
                else {
                    map[i][j] = temp.charAt(j) - '0';
                }
            }
        }
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] != -1 && !visited[i][j]) {
                    answer.add(bfs(i, j));
                }
            }
        }
        if(answer.size() == 0) {
            answer.add(-1);
        }
        int [] ans = answer.stream().mapToInt(Integer::valueOf).toArray();
        Arrays.sort(ans);
        return ans;
    }
    
    int bfs(int x, int y) {
        
        int answer = map[x][y];
        
        Queue<int []> que = new LinkedList<>();
        que.add(new int [] {x, y});
        visited[x][y] = true;
        
        while(!que.isEmpty()) 
        {
            int [] temp = que.poll();          
            
            for(int i = 0; i < 4; i++) {
                int nX = temp[0] + dx[i];
                int nY = temp[1] + dy[i];
                
                if(isInsideBoundary(nX, nY) && !visited[nX][nY]) {
                    if(map[nX][nY] != -1) {
                        que.add(new int [] {nX, nY});
                        answer += map[nX][nY];
                        visited[nX][nY] = true;
                    }                    
                }
            }
        }
        return answer;
    }
    
    boolean isInsideBoundary(int x, int y) {
        return x >= 0 && x < N && y >=0 && y < M;
    }
}