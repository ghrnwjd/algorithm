import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int [] nums, operaterCnt, operater;
    static int N;
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static boolean visited [];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        nums = new int [N];
        operater = new int [N-1];
        operaterCnt = new int [4];
        visited = new boolean[N-1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            operaterCnt[i] = Integer.parseInt(st.nextToken());
        }

        int idx = 0;
        for(int i = 0; i < 4; i++) {
            while (operaterCnt[i] > 0) {
                operater[idx++] = i;
                operaterCnt[i] --;
            }
        }

        calc(nums[0], 1);
        System.out.println(max + "\n" + min);
    }

    public static void calc(int now, int count) {


        if(count == N) {
            min = Math.min(now, min);
            max = Math.max(now, max);
            return;
        }
        int tempNow = now;

        for(int i = 0; i < N - 1; i++) {
            if(!visited[i]) {
                visited[i] = true;
                switch (operater[i]) {
                    case 0:
                        now += nums[count];
                        break;
                    case 1:
                        now -= nums[count];
                        break;
                    case 2:
                        now *= nums[count];
                        break;
                    case 3:
                        if (now < 0) {
                            now = -1 * now;
                            now /= nums[count];
                            now = -1 * now;
                        } else {
                            now /= nums[count];
                        }
                        break;
                }
                calc(now, count+1);
                now = tempNow;
                visited[i] = false;
            }
        }
    }
}