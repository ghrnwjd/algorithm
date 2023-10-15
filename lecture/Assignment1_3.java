import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

      static int [] nums;
      static int n, K;

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());

            nums = new int [n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                  nums[i] = Integer.parseInt(st.nextToken());
            }
            K = Integer.parseInt(br.readLine());

            binarySearch(0, n-1);
      }

      public static void binarySearch(int s, int e) {
            if(s > e) {
							if (s >= n) {
								System.out.println(nums[e]);
								return;
							}
							if ( e < 0) {
								System.out.println(nums[0]);
								return;
							}
                  int left = Math.abs(K - nums[e]);
                  int right = Math.abs(nums[s] - K);

                  if(left < right) {
                        System.out.println(nums[e]);
                  }
                  else {
                        System.out.println(nums[s]);
                  }
                  return;
            }
            // binary Search Algorithm
            int mid = (s + e) / 2;
            if(nums[mid] > K) {
                  binarySearch(s, mid-1);
            }
            else if(nums[mid] == K) {
                  System.out.println(nums[mid]);
                  return;
            }
            else {
                  binarySearch(mid+1, e);
            }
      }
}