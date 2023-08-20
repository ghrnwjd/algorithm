import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    final int MOD = 1000000;
    public static void main(String [] args) throws IOException {
        new Main().secretCode();
    }

    public void secretCode() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String code = br.readLine();
        int dp [] = new int [code.length() +1];
        StringBuilder sb = new StringBuilder();
        if(code.charAt(0) == '0') {
            sb.append(0);
        }
        else {
            dp[0] = 1; dp[1] = 1;
            for(int i = 2; i < code.length() + 1 ; i++) {
                if(code.charAt(i-1) == '0') {
                    if(code.charAt(i-2) == '1' || code.charAt(i-2) == '2') {
                        dp[i] = dp[i-2] % MOD;
                    }
                    else {
                        break;
                    }
                }
                else {
                    int temp = (code.charAt(i-2) - '0') * 10 + code.charAt(i-1) - '0';
                    if(temp < 27 && temp > 9) {
                        dp[i] = (dp[i-1] + dp[i-2]) % MOD;
                    }
                    else {
                        dp[i] = dp[i-1];
                    }
                }
            }
            sb.append(dp[code.length()] % MOD);
        }

        System.out.println(sb.toString());

    }

}
