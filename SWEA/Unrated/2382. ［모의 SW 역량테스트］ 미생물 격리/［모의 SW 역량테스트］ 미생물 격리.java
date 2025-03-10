import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static int N,M,K;
    static StringBuilder sb;
    static List<Point> list;
    static int[][] dir = {{}, {-1,0}, {1,0}, {0,-1}, {0,1}};  //  1:상   2:하    3:좌    4:우
    static List<Point>[][] map;


    static class Point{
        int x;
        int y;
        int num;
        int direction;

        Point(int x, int y, int num, int direction){
            this.x = x;
            this.y = y;
            this.num = num;
            this.direction = direction;
        }

    } //point


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int test = 1; test <= T; test++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
            map = new ArrayList[N][N];

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    map[i][j] = new ArrayList<Point>();
                }
            }


            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());
                int tmpdir = Integer.parseInt(st.nextToken());
                Point Ad = new Point(x,y,cnt,tmpdir);
                list.add(Ad);

            }

            for(int i = 0; i < list.size(); i++){
                Point Ad = list.get(i);
                map[Ad.x][Ad.y].add(Ad);
            }

            for(int time = 0; time < M; time++) {
                List<Point> removeList = new ArrayList<>();
                // 미생물 움직이기 --> 이때 미생물은 각 셀에 1개 아니면 0개 이다.
                for(int i = 0; i < list.size(); i++){

                    Point tmp = list.get(i);
                    int x = tmp.x;
                    int y = tmp.y;
                    int tmpdir = tmp.direction;
                    int nextrow = tmp.x + dir[tmp.direction][0];
                    int nextcol = tmp.y + dir[tmp.direction][1];

                    if(!(nextrow >= 1 && nextrow < N-1 && nextcol >= 1 && nextcol < N-1)) {
                        tmp.num = tmp.num/2;

                        if(tmpdir == 1) {
                            tmp.direction = 2;
                        }
                        else if(tmpdir == 2) {
                            tmp.direction = 1;
                        }
                        else if(tmpdir == 3) {
                            tmp.direction = 4;
                        }
                        else {
                            tmp.direction = 3;
                        }


                        if(tmp.num == 0) {
                            removeList.add(tmp);
                        }
                        else {
                            tmp.x = nextrow;
                            tmp.y = nextcol;
                        }


                    }
                    else {
                        tmp.x = nextrow;
                        tmp.y = nextcol;
                    }

                        map[nextrow][nextcol].add(tmp);
                        map[x][y].remove(tmp);

                }

                // 제거
                for(int i = 0; i < removeList.size(); i++){
                    list.remove(removeList.get(i));
                }


                // 합병
                for(int i = 0; i < N; i++){
                    for(int j = 0; j < N; j++){
                        int chk = map[i][j].size();
                        if(chk > 1){ //크기가 1이상이면 병합을 해야한다.
                            int maxNum = map[i][j].get(0).num;
                            int sum = 0;
                            int maxdir = map[i][j].get(0).direction;
                            for(Point p : map[i][j]){
                                sum += p.num;
                                if(p.num > maxNum){
                                    maxNum = p.num;
                                    maxdir = p.direction;
                                }
                                list.remove(p);

                            }
                            Point Ad = new Point(i,j, sum, maxdir);
                            map[i][j].clear();
                            map[i][j].add(Ad);
                            list.add(Ad);

                        } // if문

                    }
                } // for


            } // M 초
            int ans = 0;
            for(int i = 0; i < list.size(); i++){
                //Point chk = list.get(i);
                ans += list.get(i).num;
                //System.out.println(chk.x + "    " + chk.y + "     " + chk.num);
            }

            sb.append("#" + test + " " + ans + "\n");

        } // test

        System.out.println(sb);

    } // main

}