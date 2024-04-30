import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int nums [] = new int [N];
            int dp[] = new int [N];
            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i++) {
                  nums[i] = Integer.parseInt(st.nextToken());
            }

            dp[0] = nums[0];
            int ans = dp[0];
            for(int i = 1; i < N; i++) {
                  if(nums[i] > 0 && dp[i-1] < 0) {
                        dp[i] = nums[i];
                  }
                  else {
                        dp[i] = dp[i-1] + nums[i];
                  }
                  if(dp[i] < 0) {
                        dp[i] = Math.max(dp[i], nums[i]);
                  }
                  ans = Math.max(ans, dp[i]);
            }

            System.out.println(ans);

      }
}