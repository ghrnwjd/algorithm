import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().SortCard();
    }

    public void SortCard() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> cardSet = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            cardSet.add(Integer.parseInt(br.readLine()));
        }
        int ans = 0;

        while(true) {
            if(cardSet.size() >= 2) {
                int card1 = cardSet.poll();
                int card2 = cardSet.poll();

                ans += card1 + card2;
                cardSet.add(card1 + card2);
            }
            else {
                break;
            }
        }

        System.out.println(ans);
    }

}
