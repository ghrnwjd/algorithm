import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());

            int [][] nums = new int [N][2];

            for(int i = 0; i < N; i++) {
                  st = new StringTokenizer(br.readLine());
                  nums[i][0] = Integer.parseInt(st.nextToken());
                  nums[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(nums, new Comparator<int[]>() {
                  @Override
                  public int compare(int[] o1, int[] o2) {
                        if(o1[1] == o2[1]) {
                              return o1[0] - o2[0];
                        }
                        return o1[1] - o2[1];
                  }
            });

            for(int i = 0; i < N; i++) {
                  System.out.println(nums[i][0] + " " + nums[i][1]);
            }
      }
}