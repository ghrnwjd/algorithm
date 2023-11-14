import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Assignment3_2 {
      static int m, n;
      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            int map [][] = new int [m][n];
            for(int i = 0; i < m; i++) {
                  st = new StringTokenizer(br.readLine());
                  for(int j = 0; j < n; j++) {
                        map[i][j] = Integer.parseInt(st.nextToken());
                  }
            }

            int dp [][] = new int [m][n];

            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            // (p,q) 이전
            for(int i = 0; i < m; i++) {
                  for(int j = 0; j < n; j++) {


                        int leftup = Integer.MAX_VALUE; int up = Integer.MAX_VALUE; int rightup = Integer.MAX_VALUE;

                        // 왼쪽 위에서
                        if(isBoundary(i-1, j-1)) {
                              leftup = dp[i-1][j-1];
                        }
                        if(isBoundary(i-1, j)) {
                              up = dp[i-1][j];
                        }
                        if(isBoundary(i-1, j+1)) {
                              rightup = dp[i-1][j+1];
                        }

                        dp[i][j] = Math.min(Math.min(leftup, rightup), up) + map[i][j];

                        if (i == 0) {
                              dp[i][j] = map[i][j]; // 첫번째 줄은 같음.
                        }

                        if(i == p-1 && j != q-1) {
                              dp[i][j] = 1000000;
                        }
                  }
            }

            int ans = Integer.MAX_VALUE;
            for(int lastCost : dp[m-1]){
                  ans = Math.min(ans, lastCost);
            }

            System.out.println(ans);
      }

      public static boolean isBoundary(int x, int y) {
            return x >= 0 && x <  m &&  y >= 0 && y < n;
      }
}
