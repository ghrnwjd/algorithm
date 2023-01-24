import java.util.*;
import java.io.*;

public class Main {
    // 왼쪽 대각선부터 시계방향으로
    static int dict [][] = {{-1,-1}, {-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}};

    static int board [][];
    static boolean visit[][];
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int [n][m];
        visit = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 1 && !visit[i][j]) {
                    findCharacter(i,j);
                    ans += 1;
                }
            }
        }

        System.out.println(ans);
    }

    public static void findCharacter(int x, int y) {
        visit[x][y] = true;

        for(int i = 0; i < 8; i++) {
            int tempX = x + dict[i][0];
            int tempY = y + dict[i][1];

            if(isContain(tempX, tempY) && board[tempX][tempY] == 1
                    && !visit[tempX][tempY]) {
                findCharacter(tempX, tempY);
            }

        }
    }

    static boolean isContain(int x, int y) {
        return x >= 0 && x < n && y >=0 && y < m;
    }
}

