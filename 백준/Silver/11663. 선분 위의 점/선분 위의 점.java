import java.util.*;
import java.io.*;

public class Main {

    static int points[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        points = new int [n];
        st = new StringTokenizer(br.readLine());
        // 이분탐색 (log2(n)) <= Tree 탐색 (log2n)
        for(int i = 0; i < n; i++) {
            points[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(points);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            int start = binarySearchStart(p1, 0, n-1);
            int end = binarySearchEnd(p2, 0, n-1);

            sb.append(end - start + "\n");
            // subset(시작점, bool , 끝점, bool) bool 이 true 면 이상/이하, false 면 초과 미만
//            int count_point = points.subSet(p1, true, p2, true).size();
//            sb.append(count_point + "\n");

        }

        System.out.println(sb.toString());
    }

    public static int binarySearchStart(int p, int sIndex, int eIndex) {
        while(sIndex <= eIndex) {
            int mid = (sIndex + eIndex) / 2;

            if(points[mid] >= p) {
                eIndex = mid-1;
            }
            else {
                sIndex = mid + 1;
            }
        }
        return sIndex;
    }

    public static int binarySearchEnd(int p, int sIndex, int eIndex) {
        while(sIndex <= eIndex) {
            int mid = (sIndex + eIndex) / 2;

            if(points[mid] > p) {
                eIndex = mid-1;
            }
            else {
                sIndex = mid + 1;
            }
        }
        return eIndex + 1;
    }
}
