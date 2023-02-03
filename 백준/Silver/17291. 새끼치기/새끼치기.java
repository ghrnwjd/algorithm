import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 현재 벌레수를 기록할 배열.
        int [] bugs = new int [n+1];
        bugs[0] = 1;
        bugs[1] = 1;
        // 새로 태어나는 벌레 bugs[i-1] 만큼 태어남.
        for(int i = 2; i <= n; i++) {
            bugs[i] = bugs[i-1] * 2;

            // 홀수년에 태어나면 3년뒤 죽는다 1->4 홀수에서 짝수년도.
            // 짝수년에 태어나면 4년뒤 죽는다. 2->6 짝수에서 짝수년도.
            // 짝수년에만 벌레가 죽는다.

            if(i % 2 == 0) {
                // 3년전 홀수년에서 태어난 벌레를 뺀다.
                if(i >= 4)
                    bugs[i] -= bugs[i-4];

                // 4년전 짝수년에서 태어난 벌레를 뺀다.
                if(i >= 5)
                    bugs[i] -= bugs[i-5];
            }
        }
       
        System.out.println(bugs[n]);
    }
}

