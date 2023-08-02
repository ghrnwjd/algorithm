
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {

    static int N;
    public static void main(String[] args) throws IOException {
        new Main().toctocHead();
    }

    public void toctocHead() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int [] numCount = new int [1000001];
        int [] memberNums = new int [N];

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            memberNums[i] = num;
            numCount[num] ++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(getDivisorMembers(numCount,memberNums, i)).append("\n");
        }
        
        System.out.println(sb.toString());
    }

    public int getDivisorMembers(int [] numCount, int [] memberNums, int myIndex) {

        int cnt = 0;

        int myNum = memberNums[myIndex];

        for(int j = 1; j * j <= myNum; j++) {
            if(j*j == myNum) {
                cnt += numCount[j];
            }
            else {
                if(myNum % j == 0) {
                    cnt += numCount[j];
                    cnt += numCount[myNum / j];
                }
            }
        }
        return (cnt == 0) ? 0 : cnt - 1;
    }
}

