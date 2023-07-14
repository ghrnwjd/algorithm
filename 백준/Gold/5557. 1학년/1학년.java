import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        new Main().oneGrade();
    }

    public void oneGrade() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int nums [] = new int [n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        long dp [][] = new long [n][21];
        int plus = 0;
        int minus = 0;
        dp[0][nums[0]] = 1;

        for(int i = 1; i < n-1; i++) {
            for(int j = 0; j < 21; j++) {
                if(dp[i-1][j] != 0) {
                    plus = nums[i] + j;
                    minus = j - nums[i];
                    if(plus <= 20) {
                        dp[i][plus] += dp[i-1][j];
                    }
                    if(minus >= 0) {
                        dp[i][minus] += dp[i-1][j];
                    }
                }
            }
        }      
        System.out.println(dp[n-2][nums[n-1]]);

    }

}