import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st= new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            StringBuilder ans = new StringBuilder();
            for(int i = 0; i < N; i++) {
                  int temp = Integer.parseInt(br.readLine());
                  int [][] map = new int [2][temp];
                  for(int j = 0; j < 2; j++) {
                        st = new StringTokenizer(br.readLine());
                        for(int k = 0; k < temp; k++){
                              map[j][k] = Integer.parseInt(st.nextToken());
                        }
                  }
                  ans.append(dp(map, temp)).append("\n");
            }

            System.out.println(ans.toString());

      }

      static int dp(int [][] map, int temp) {

            int [][] dp = new int [2][temp];
            dp[0][0] = map[0][0];
            dp[1][0] = map[1][0];

            int answer = Math.max(dp[0][0], dp[1][0]);

            for(int i =1 ; i < temp; i++) {
                  if(i - 2 < 0) {
                        dp[0][i] = Math.max(dp[1][i-1] + map[0][i], dp[0][i-1]);
                        dp[1][i] = Math.max(dp[0][i-1] + map[1][i], dp[1][i-1]);
                  }
                  else {
                        dp[0][i] = Math.max(Math.max(dp[1][i-1], dp[0][i-2]), dp[1][i-2]) + map[0][i];
                        dp[1][i] = Math.max(Math.max(dp[0][i-1], dp[0][i-2]), dp[1][i-2]) + map[1][i];
                  }

                  answer = Math.max(dp[0][i], dp[1][i]);
            }
            return answer;
      }
}