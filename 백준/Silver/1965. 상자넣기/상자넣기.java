import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().putBox();
    }

    public void putBox() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int [] boxSize = new int [N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            boxSize[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getAnswer(boxSize, N));
    }

    public int getAnswer(int [] boxSizeList, int N) {
        int dp [] = new int [N];
        dp[0] = 1;
        int ans = 0;
        // max case : 1000 * 1000 = 1,000,000번
        for(int i = 1; i < N; i++) {
            dp[i] = 1;
            for(int j = i-1; j >= 0 ; j--) {
                if (boxSizeList[i] > boxSizeList[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);                    
                }
            }
            ans = (ans > dp[i]) ? ans : dp[i];
        }

        return ans;

    }

}