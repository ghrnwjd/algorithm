import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine().trim());

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
						
						
						if(n == k) {
							System.out.println("yes");
						}
						else if(k == 1 && n != 1) {
							System.out.println("no");
						}
						else {
							System.out.println(isPower(n, k) ? "yes" : "no");
						}
            
      }

      public static boolean isPower(int n, int k) {

        
					if (n == 1 || n == 0) {
            return true;
        	}
					
        
        if (n % k != 0) {
            return false;
        }
        return isPower(n / k, k);
            
      }
}
