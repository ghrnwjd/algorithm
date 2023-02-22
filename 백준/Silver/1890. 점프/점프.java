import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int board[][];
    static long dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        board  = new int [n][n];
        dp = new long [n][n];
        dp[0][0] = 1;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int temp = board[i][j];
                if(temp == 0) break;
                if(isOut(i + temp, j)) dp[i+temp][j] += dp[i][j];
                if(isOut(i, temp+j)) dp[i][j+temp] += dp[i][j];

            }
        }


        System.out.println(dp[n-1][n-1]);

    }

//    static void dp(int x, int y) {
//        int temp = board[x][y];
//
//        if(temp == 0) return;
//
//        if(isOut(x+temp, y)) {
//            dp[x+temp][y] += dp[x][y];
//            dp(x+temp, y);
//        }
//        if(isOut(x, y+temp)) {
//            dp[x][y+temp] += dp[x][y];
//            dp(x, y + temp);
//        }
//    }

    static boolean isOut(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}

