import java.io.*;
 
public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(in.readLine());
 
      int[] tree = new int[N];
      int gcd = 0;
      for(int i=0;i<N;i++){
         tree[i] = Integer.parseInt(in.readLine());
         if(i==1) gcd = tree[1]-tree[0];
         if(i<2) continue;
         gcd = gcd(tree[i]-tree[i-1],gcd);
      }
 
      int total = (tree[N-1]-tree[0])/gcd + 1;
      int answer = total-N;
 
      System.out.println(answer);
   }
   
   public static int gcd(int a, int b){
      if(a<b){
         int tmp = a;
         a = b;
         b = tmp;
      }
      if(b==0) return a;
      return gcd(b,a%b);
   }
}