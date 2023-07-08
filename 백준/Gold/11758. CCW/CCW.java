import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().ccw();
    }

    public void ccw() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Point [] points = new Point[3];
        for(int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            Point point = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            points[i] = point;
        }

        System.out.println(getAngle(points));

    }

    public int getAngle(Point [] points) {
        
        // 신발끈 공식
        
        int a = points[0].x * points[1].y + points[1].x * points[2].y + points[2].x * points[0].y;
        int b = points[0].y * points[1].x + points[1].y * points[2].x + points[2].y * points[0].x;

        if(a - b > 0) return 1;
        else if (a - b == 0) return 0;
        else return -1;

    }

}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}