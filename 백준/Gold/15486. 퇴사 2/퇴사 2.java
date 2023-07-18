import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().leaveCompany();
    }

    public void leaveCompany() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int timeTable [][] = new int [n+2][2];

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            timeTable[i][0] = Integer.parseInt(st.nextToken());
            timeTable[i][1] = Integer.parseInt(st.nextToken());
        }

        int [] dp = new int [n+2];
        int max = 0;
        for(int i = 1; i < n+2; i++) {
            max = (max < dp[i]) ? dp[i] : max;

            if( i + timeTable[i][0] < n + 2) {
                dp[i + timeTable[i][0]] = Math.max(dp[i+timeTable[i][0]], max + timeTable[i][1]);
            }
        }

        System.out.println(max);

    }

}