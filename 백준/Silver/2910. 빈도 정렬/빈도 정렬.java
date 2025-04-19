import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Map<Integer, Num> numsMap = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            if(numsMap.containsKey(x)) {
                numsMap.get(x).count++;
            }
            else {
                numsMap.put(x, new Num(x, 1, i));
            }
        }

        List<Integer> keys = new ArrayList<>(numsMap.keySet());
        keys.sort((o1, o2) -> {
            if(numsMap.get(o1).count == numsMap.get(o2).count) {
                return numsMap.get(o1).firstIdx - numsMap.get(o2).firstIdx;
            }
            return numsMap.get(o2).count - numsMap.get(o1).count;
        });

        for(int i = 0; i < keys.size(); i++) {
            numsMap.get(keys.get(i)).print();
        }
    }
}

class Num {
    int data;
    int count;
    int firstIdx;

    public Num(int data, int count, int firstIdx) {
        this.data = data;
        this.count = count;
        this.firstIdx = firstIdx;
    }

    public void print() {
        for(int i = 0; i < count; i++) {
            System.out.print(this.data + " ");
        }
    }
}