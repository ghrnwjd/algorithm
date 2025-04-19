import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, countOdds = 0, maxEvens = 0;
        
        for (int right = 0; right < N; right++) {
            if (nums[right] % 2 == 1) countOdds++;
            
            while (countOdds > K) {
                if (nums[left] % 2 == 1) countOdds--;
                left++;
            }
            
            int currentEvens = (right - left + 1) - countOdds;
            maxEvens = Math.max(maxEvens, currentEvens);
        }

        System.out.println(maxEvens);
    }
}
