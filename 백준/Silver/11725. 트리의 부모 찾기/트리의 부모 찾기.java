import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] node;
    static int ans [];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        node = new ArrayList[n+1];
        ans = new int [n+1];
        for(int i = 1; i <= n; i++) {
            node[i] = new ArrayList<>();
        }

        for(int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            // 어떤 노드가 부모노드일지 모른다.
            node[n1].add(n2);
            node[n2].add(n1);
        }

        findParent(1, 0);
        for(int i = 2; i <= n; i++) {
            System.out.println(ans[i]);
        }
    }

    public static void findParent(int tempNode, int parent) {
        for(int i = 0; i < node[tempNode].size(); i++) {
            int temp = node[tempNode].get(i);
            if(temp != parent) {
                ans[temp] = tempNode;
                findParent(temp, tempNode);
            }
        }
    }
}

