import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class tomato{
    int height;
    int row;
    int col;

    public tomato(int height, int row, int col){
        this.height = height;
        this.row = row;
        this.col = col;
    }
}

public class Main {
    static int rowArr[] = {-1, 1, 0, 0, 0, 0};
    static int colArr[] = {0, 0, 1, -1, 0, 0};
    static int heightArr[] = {0, 0, 0, 0, 1, -1};
    static int m, n, h;
    static int tomatos[][][];
    static Queue<tomato> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        tomatos = new int[h][n][m];

        for(int i = 0; i < h; i++){
            for(int j = 0; j < n; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < m; k++){
                	tomatos[i][j][k] = Integer.parseInt(st.nextToken());
                    
                    if(tomatos[i][j][k] == 1) {
                    	queue.add(new tomato(i, j, k));
                    }
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        while (!queue.isEmpty()){
            tomato point = queue.poll();

            int height = point.height;
            int row = point.row;
            int col = point.col;

            for(int i = 0 ; i < 6; i++){
                int temp_height = height + heightArr[i];
                int temp_row = row + rowArr[i];
                int temp_col = col + colArr[i];
                // 6방향으로 토마토가 익을 수 있는지 여부 확인
                if(isOutAndNoneTomato(temp_height, temp_row, temp_col)){
                    // 익은 토마토를 큐에 추가
                    queue.add(new tomato(temp_height, temp_row, temp_col));
                    // 익은 토마토의 값 = 이전에 익은 토마토의 값 + 1
                    tomatos[temp_height][temp_row][temp_col] = tomatos[height][row][col] + 1;
                }
            }
        }
        // 최대 값을 구하기 위한 변수
        int result = Integer.MIN_VALUE;

        for(int i = 0; i < h; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < m; k++){
                    // 하나라도 익지 않은 토마토가 있다면 -1을 반환
                    if(tomatos[i][j][k] == 0) return -1;
                    // 토마토가 익는데 걸리는 시간을 구함
                    result = Math.max(result, tomatos[i][j][k]);
                }
            }
        }
        // 최대 값이 1이라면 원래부터 모두 익어있었다는 것
        if(result == 1) return 0;
        // (최대 값 - 1) --> 걸린 일수
        else return (result - 1);
    }

    private static boolean isOutAndNoneTomato(int height, int row, int col){
        // 주어진 범위 밖인지 검사
        if(height < 0 || height >= h || row < 0 || row >= n || col < 0 || col >= m) {
        	return false;
        }
        // 아직 익지 않은 토마토라면 true 반환
        if(tomatos[height][row][col] == 0) {
        	return true;
        }
        // 이미 익어있거나 빈 자리라면 false 반한
        else return false;
    }
}
//public class Main {
//	static int n,m,h;
//	static int tomatos [][];
//	static boolean visited [][];
//	static Queue<int []> tomato_list = new LinkedList<>();
//	static int dict [][];
//	
//	public static void main(String[] args) throws IOException {
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		n = Integer.parseInt(st.nextToken()); // 가로 칸
//		m = Integer.parseInt(st.nextToken()); // 세로 칸
//		h = Integer.parseInt(st.nextToken()); // 높이 칸
//		
//		dict = new int [][] {{1,0}, {0,1}, {-1,0}, {0,-1}, {m,0}, {-1*m, 0}};
//		tomatos = new int [m*h][n];
//		visited = new boolean [m*h][n];
//		
//		for (int i = 0; i < m*h; i++) {
//			st = new StringTokenizer(br.readLine());
//			for(int j = 0; j < n ; j++) {
//				tomatos[i][j] = Integer.parseInt(st.nextToken());
//				if(tomatos[i][j] == 1) {
//					visited[i][j] = true;
//					tomato_list.add(new int [] {i, j});
//				}
//				if(tomatos[i][j] == -1) {
//					visited[i][j] = true;
//				}
//			}
//		}
//		
//		BFS();
//	}
//	
//	static void BFS() {
//		
// 	 while(!tomato_list.isEmpty()) {
//		
//			int x = tomato_list.peek()[0];
//			int y = tomato_list.poll()[1];
//			
//			for(int i = 0; i < 6; i++) {
//				if(x % n == 0 && i == 2) {
//					continue;
//				}
//				if(x % n == n-1 && i == 0) {
//					continue;
//				}
//				int temp_x = x + dict[i][0];
//				int temp_y = y + dict[i][1];
//				
//				if(isOut(temp_x, temp_y) && !visited[temp_x][temp_y]) {
//					tomato_list.add(new int [] {temp_x, temp_y});
//					tomatos[temp_x][temp_y] = tomatos[x][y] + 1;
//					visited[temp_x][temp_y] = true;
//				}
//			}		
//		}	
// 	 
// 	 	printAnswer();
//		
//	}
//	
//	static void printAnswer() {
//		
//		int ans = Integer.MIN_VALUE;
//		for(int i = 0; i < m*h; i++ ) {
//			for(int j = 0; j <n; j++) {
//				if(tomatos[i][j] == 0) {
//					System.out.println(-1);
//					return;
//				}
//				ans = Math.max(ans, tomatos[i][j]);
//				
//			}
//		}
//		System.out.println(ans - 1);
//	}
//	
//	static boolean isOut(int x, int y) {
//		return x >=0 && x < m*h && y >=0 && y<n;
//	}
//
//}
