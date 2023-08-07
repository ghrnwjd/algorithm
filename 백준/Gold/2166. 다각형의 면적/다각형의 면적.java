import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().area();
    }

    public void area() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        long x [] = new long [N+1];
        long y [] = new long [N+1];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());

        }

        x[N] = x[0];
        y[N] = y[0];

        long sum1 = 0L;
        long sum2 = 0L;

        for(int i = 0; i < N; i++) {
            sum1 += x[i] * y[i+1];
            sum2 += x[i+1] * y[i];
        }

        System.out.println(String.format("%.1f", Math.abs(sum1 - sum2) / 2.0));
    }

}

