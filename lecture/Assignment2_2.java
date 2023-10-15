import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Event {
      public int eventPersonAtTime;
      public Event() {
      }
      public Event(int eventPersonAtTime) {
            this.eventPersonAtTime = eventPersonAtTime;
      }
}
class Assignment2_2 {

      public static void main(String[] args) throws IOException
      {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken()); // n명의 사람

            // 들어오는 시간과 나가는 시간만 체크하면 됨.
            // 그 사람이 누군지는 필요하지 않기 때문에 배열 리스트 준비

            List<int []> personTime = new ArrayList<>(); // 들어오는 시간을 기록한 큐

            int maxOutTime = 0;

             for(int i = 0; i < n; i++) {
                   st = new StringTokenizer(br.readLine());
                   int inTime = Integer.parseInt(st.nextToken());
                   int outTime = Integer.parseInt(st.nextToken());

                   maxOutTime = Math.max(maxOutTime, outTime);
                   personTime.add(new int [] {inTime, outTime});

             }

             // List 정렬
             Collections.sort(personTime, (list1, list2) -> list1[0] - list2[0]);
             printAnswer(personTime, maxOutTime);
      }

      public static void printAnswer(List<int[]> personTime, int maxOutTime)
      {
            // 있었던 최대시간
            // 처음 사람이 들어왔을 때 부터, 마지막 사람이 나간 시간 체크
            int firstInTime = personTime.get(0)[0];
            int lastOutTime = maxOutTime;

            Event [] events = new Event[lastOutTime-firstInTime];

            for(int i = 0; i < events.length; i++) {
                  events[i] = new Event();
            }

            for(int i = 0; i < personTime.size(); i++) {
                  int inTime = personTime.get(i)[0];
                  int outTime = personTime.get(i)[1];
                  for(int j = inTime-firstInTime; j < outTime-firstInTime; j++) {
                        events[j].eventPersonAtTime++;
                  }
            }

            int timePersonInRoom = 0;
            int maxPersonInRoom = 0;

            for(Event event : events) {
                  if(event.eventPersonAtTime > 0) {
                        timePersonInRoom++;
                  }
                  if(maxPersonInRoom < event.eventPersonAtTime) {
                        maxPersonInRoom = event.eventPersonAtTime;
                  }
            }

            System.out.println(timePersonInRoom + " " + maxPersonInRoom);


      }
}
