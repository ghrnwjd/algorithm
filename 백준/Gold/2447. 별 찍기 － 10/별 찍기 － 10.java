import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

      static char starMap[][];
      public static void main(String[] args) throws IOException {
            new Main().pointStars();
      }

      public void pointStars() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());

            starMap= new char [N][N];
            for(int i = 0; i < N; i++) {
                  Arrays.fill(starMap[i], '*');
            }

            reculsive(0, 0, N);

            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < N; i++) {
                  for(int j =0; j < N; j++) {
                        sb.append(starMap[i][j]);
                  }
                  sb.append("\n");
            }
            System.out.println(sb.toString());
      }

      public void reculsive(int sP, int eP, int N) {
            if (N == 1) return;

            for(int i = sP + N/3; i < sP + (N/3) * 2; i++) {
                  for(int j = eP + N/3; j < eP +  (N/3) * 2; j++) {
                        starMap[i][j] = ' ';
                  }
            }

            for(int i = 0; i < 3; i++) {
                  for(int j = 0; j < 3; j++) {
                        if(i==1 && j == 1) continue;
                        reculsive(sP + i * (N/3), eP + j * (N/3), N / 3);
                  }
            }

      }
}