import java.util.*;
import java.io.*;

public class Main {

    static int N,M,D;
    static int[][] arr;
    static StringBuilder sb;
    static int[] pos;
    static long ans;
    static List<Point> list;
    static List<Point> tmplist;
    static class Point{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        ans = 0;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        pos = new int[3];
        list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1){
                    list.add(new Point(i,j));
                }
            }
        }

//        for(Point chk : list){
//            System.out.println(chk.x + "   " + chk.y);
//        }
        //조합
        go(0,0);

        System.out.println(ans);
    } // main

    static void go(int start, int depth) {

        if(depth == 3) {

            tmplist = new ArrayList<>();
            for(Point copy : list){
                tmplist.add(new Point(copy.x, copy.y));
            }
            //System.out.println(Arrays.toString(pos));
//            tmp = new int[N][M];
//            // 공격 실시
//            for(int i = 0; i < N; i++) {
//                tmp[i] = arr[i].clone();
//            }

            int sum = 0;
            //System.out.println(Arrays.toString(pos));

            // list가 비어있지 않으면 공격을 해야한다.
            while(!tmplist.isEmpty()) { // 몬스터가 있다면 공격 진행

                Set<Point> removeSet = new HashSet<>();
                //공격 진행
                for(int at = 0; at < 3; at++){
                    List<Point> remove = new ArrayList<>();
                    for(Point chkP : tmplist){
                        int dis = Math.abs(chkP.x - N) + Math.abs(chkP.y - pos[at]);
                        //System.out.println(chkP.x + "   " + chkP.y + "    " + N + "     " + pos[at] +   "    "  + dis);

                        if(dis <= D) remove.add(chkP);

                    }

                    final int colNum = pos[at];
                    Collections.sort(remove, (p1,p2) ->{
                        int dis1 = Math.abs(p1.x - N) + Math.abs(p1.y - colNum);
                        int dis2 = Math.abs(p2.x - N) + Math.abs(p2.y - colNum);
                        if(dis1 != dis2) return Integer.compare(dis1,dis2);

                        return p1.y - p2.y;
                    });

                    if(!remove.isEmpty()){
                        removeSet.add(remove.get(0));
                    }

                } //for

                //list에서 몬스터 제거
                for(Point r : removeSet){
                    sum++;
                    //System.out.println(r.x + "    " + r.y);
                    tmplist.remove(r);
                }

                // 몬스터 이동
                move();

            }  // while
            //System.out.println(sum);
            ans = Math.max(ans, sum);

            return;
        } // 조합 if문

        for(int i = start; i < M; i++) {
            pos[depth] = i;
            go(i+1, depth+1);
        }
    } // go

    static void move() {

        List<Point> remove = new ArrayList<>();
        for(Point m : tmplist){

            int nextrow = m.x + 1;
            if(nextrow == N){
                remove.add(m);
            }
            else{
                m.x = nextrow;
            }

        }

        for(Point m : remove){
            tmplist.remove(m);
        }

//        for(Point chk : list){
//            System.out.println(chk.x + "    " + chk.y);
//        }

    } // move

}