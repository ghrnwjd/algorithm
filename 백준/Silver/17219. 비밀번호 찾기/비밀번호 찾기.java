import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        HashMap<String, String> sitePassword = new HashMap<>();

        for(int i = 0; i < n; i += 1){
            String[] temp = br.readLine().split(" ");

            String saveSite = temp[0];
            String savePassword = temp[1];
            
            sitePassword.put(saveSite, savePassword);
        }

        for(int i = 0; i < m; i += 1) {
            String tempSite = br.readLine();
            bw.write(sitePassword.get(tempSite.toString()) + "\n");
        }
        
        bw.flush();
        bw.close();

    }
}