import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Assignment4_2 {
      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            List<Node> nodes = new ArrayList<>();
            for(int i = 0; i < N; i++) {
                  Node n = new Node(i);
                  nodes.add(n);
            }

            for (int i = 0; i < M; i++) {
                  st = new StringTokenizer(br.readLine());
                  int t1 = Integer.parseInt(st.nextToken());
                  int t2 = Integer.parseInt(st.nextToken());

                  Node tempNode = new Node(t1);
                  nodes.get(t2).addNode(tempNode);
            }

            List<Integer> subjects = new ArrayList<>();
            st = new StringTokenizer(br.readLine());

            int nSubjects = Integer.parseInt(st.nextToken());
            for (int i = 0; i < nSubjects; i++) {
                  subjects.add(Integer.parseInt(st.nextToken()));
            }

            dfs(N, nodes, subjects);

      }

      public static void dfs(int N, List<Node> nodes, List<Integer> subjects) {
            boolean visit[] = new boolean[N];

            Stack<Integer> stack = new Stack<>();

            for (int subject : subjects) {
                  stack.add(subject);
            }

            while (!stack.isEmpty()) {
                  int tempSubject = stack.pop();
                  for (int i = 0; i < N; i++) {
                        if (i == tempSubject) continue;
                        if (!visit[i] && nodes.get(tempSubject).containNode(i)) {
                              stack.add(i);
                              visit[i] = true;
                        }
                  }
            }

            for(int i = 0; i < N; i++) {
                  if(visit[i]) {
                        System.out.print(i + " ");
                  }
            }
      }

}
//
//class Node{
//      int data;
//      List<Node> nodes;
//
//      public Node(int data) {
//            this.data = data;
//            nodes = new ArrayList<>();
//      }
//
//      public void addNode(Node n) {
//            nodes.add(n);
//      }
//
//      public boolean containNode(int data) {
//            for(Node n : nodes) {
//                  if(n.data == data) {
//                        return true;
//                  }
//            }
//            return false;
//      }
//}
