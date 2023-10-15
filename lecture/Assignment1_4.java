import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Minimum {
      int num1;
      int num2;
      int minus;
      public Minimum(int num1, int num2, int minus) {
            this.num1 = num1;
            this.num2 = num2;
            this.minus = minus;
      }
      public Minimum() {
            this.num1 = -1;
            this.num2 = -1;
            this.minus = 10000000;
      }

      public void print() {
            System.out.println(this.minus);
            System.out.println(num1 + " " + num2);
      }
}

public class Main {

      static int [] numsA, numsB;
      static int m, n, K;

      static Minimum minimum;


      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());

            numsA = new int [m];
            st = new StringTokenizer(br.readLine().trim());
            for(int i = 0; i < m; i++) {
                  numsA[i] = Integer.parseInt(st.nextToken());
            }

            n = Integer.parseInt(br.readLine().trim());
            numsB = new int [n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                  numsB[i] = Integer.parseInt(st.nextToken());
            }

            Minimum ans = new Minimum();

            for(int i = 0; i < m; i++) {
                  K = numsA[i];
                  binarySearch(0, n-1);
                  if(ans.minus >= minimum.minus) {
                        ans = minimum;
                  }
            }

            ans.print();
      }

      public static void binarySearch(int s, int e) {

            if( s >= n ) {
                  minimum = new Minimum(K, numsB[e], Math.abs(K - numsB[e]));
                  return;
            }
            if ( e < 0) {
                  minimum = new Minimum(K, numsB[0], Math.abs(K-numsB[0]));
                  return;
            }

            if(s > e) {

                  int left = Math.abs(K - numsB[e]);
                  int right = Math.abs(numsB[s] - K);

                  if(left < right) {
                        minimum = new Minimum(K, numsB[e], left);
                  }
                  else {
                        minimum = new Minimum(K, numsB[s], right);
                  }
                  return;
            }
            // binary Search Algorithm
            int mid = (s + e) / 2;

            if(numsB[mid] == K) {
                  minimum = new Minimum(K, numsB[mid], 0);
                  return;
            }
            else if(numsB[mid] > K) {
                  binarySearch(s, mid-1);
            }
            else {
                  binarySearch(mid+1, e);
            }
      }
}