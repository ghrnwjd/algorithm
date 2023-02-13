import java.util.*;
import java.io.*;

public class Main {
    static int n, h, t;
    static PriorityQueue<Integer> giants;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 키 제한 20억 -> int 가능
        n = Integer.parseInt(st.nextToken()); // 거인 나라 인구수
        h = Integer.parseInt(st.nextToken()); // 센티의 키
        t = Integer.parseInt(st.nextToken()); // 뿅망치 횟수

        giants = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < n; i++) {
            giants.add(Integer.parseInt(br.readLine()));
        }
        sentiHammer();
    }

    public static void sentiHammer() {
        int cnt = 0;
        while(true) {
            int tallest_giant = giants.peek();

            if(tallest_giant < h) {
                System.out.println("YES");
                System.out.println(cnt);
                return; // cnt 를 리턴한다.
            }
            if(cnt == t || tallest_giant == 1) {
                System.out.println("NO");
                System.out.println(tallest_giant);
                return;
            }

            int half_giant = giants.poll() / 2;
            giants.add(half_giant);
            cnt ++;
        }
    }

}

