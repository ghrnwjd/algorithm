import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] dp = new int [n+1];

        // 4보다 작아야 되니 5의 값으로 다 넣어준다.
        Arrays.fill(dp, 5);
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            for(int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - (j * j)] + 1);
            }
        }

        System.out.println(dp[n]);

    }
}

