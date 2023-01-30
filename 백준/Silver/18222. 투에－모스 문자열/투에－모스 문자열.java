import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 증가할때마다 길이가 두배씩 늘어난다.
        long x = Long.parseLong(st.nextToken());
        // 0/1/10/1001/10010110/1001011001101001/1001011001101001

        // x가 2^n 이면 바로 결과 출력
        String pattern = "01101001";
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        while (true) {

            if (x <= 8) break;

            int tempExp = getExp(x);
            if(Math.pow(2, tempExp) == x) {
                if(tempExp % 2 == 0) {
                    if(!flag) sb.append(1);
                    else sb.append(0);
                }
                else{
                    if(!flag) sb.append(0);
                    else sb.append(1);
                }
                break;
            }

            // true - 그대로, false - 뒤집혔다.
            if (flag) flag = false;
            else flag = true;

            int exp = getExp(x);
            x -= (long) Math.pow(2, exp);
        }
        if(sb.toString().length() == 0) {
            if (!flag) {
                System.out.println(sb.append(pattern.charAt(8 - (int) x)));
            } 
            else {
                System.out.println(sb.append(pattern.charAt((int) x - 1)));
            }
        }
        else{
            System.out.println(sb.toString());
        }


    }

    static int getExp(long num) {
        int exp = 0;
        while(num != 1) {
            num = num / 2;
            exp++;
        }
        return exp;
    }
}

