import java.util.*;
import java.io.*;

public class Main {

    static class Meeting implements Comparable<Meeting>{
        int start, end;
        public Meeting(int start, int end){
            this.start = start;
            this.end = end;
        }

        // 회의 시작, 종료 시간이 같은 경우도 있을 경우 : 종료시간이 빠른 순, 같다면 시작시간이 빠른 순
        // (1,2),  (2,3),  (3,3) ==> 답
        // (1,2),  (3,3),  (2,3)
        @Override
        public int compareTo(Meeting o) {
            return this.end != o.end ? this.end - o.end : this.start - o.start;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        Meeting[] meet = new Meeting[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            meet[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(meet); // 오름차순 정렬
        List<Meeting> result = new ArrayList<>();
        result.add(meet[0]); // 첫 회의 배정

        for(int i = 1; i < N; i++){
            if(result.get(result.size() -1).end <= meet[i].start){ //배정된 마지막 회의의 종료시간보다 고려하는 회의의 시작시간이 갇거나 이후라면 배정 가능
              result.add(meet[i]);
            }
        }
        System.out.println(result.size());  // 총 배정된 회의 수
//        for(Meeting meeting : result){
//            System.out.println(meeting.start + "" + meeting.end);
//        }

    } //main

}