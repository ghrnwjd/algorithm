import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Assignment3_1 {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(br.readLine());
            final int MOD = 99999;
            int temp_n = (n < 5) ? 6 : n+1;
            int dp[] = new int [temp_n];

            // 초기화
            dp[1] = 1; dp [2] = 1; dp[3] = 2; dp[4] = 4; dp[5] =7;

            for(int i = 6; i < temp_n; i++) {
                  dp[i] = (dp[i-1] + dp[i-3] + dp[i-4] + dp[i-5]) % MOD;
            }

            System.out.println(dp[n]);

      }
}
