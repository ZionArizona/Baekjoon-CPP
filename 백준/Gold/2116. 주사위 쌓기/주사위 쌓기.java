import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    static int n;
    static List<List<Integer>> list = new ArrayList<>();
    static int[][] index = {{0,5}, {1,3}, {2,4}};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i = 0; i < n; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 6; j++){
                list.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }


        int ans = Integer.MIN_VALUE;

        for(int len = 0; len < index.length; len++){
            int[] idx = index[len];
            int one = idx[0];
            int two = idx[1];

            // top과 bot의 값은 다른 주사위에서 사용될 수 없다. top, bot의 값을 제외한 값의 큰 값을 찾아야 한다.

            ans = Math.max(ans, dfs(0, one, two));
            ans = Math.max(ans, dfs(0, two, one));
        }

        System.out.println(ans);
    } // main

    //cnt 번째 top, bot
    static int dfs(int cnt, int topIdx, int botIdx){


        // 맨 마지막 주사위
        if(cnt == n-1){

            int Max = 0;
            for(int i = 0; i < 6; i++){
                if(list.get(cnt).get(i) == list.get(cnt).get(topIdx) || list.get(cnt).get(i) == list.get(cnt).get(botIdx)){
                    continue;
                }

                Max = Math.max(Max, list.get(cnt).get(i));
            }

            return Max;

        }

        // cnt + 1번째 주사위의 bot 인덱스를 찾아고 top 인덱스를 찾아야 한다.
        int top_idx = 0;
        int bot_idx = 0;
        int topNum = list.get(cnt).get(topIdx);
        int botNum = list.get(cnt).get(botIdx);
        int num = 0;
        for(int i = 0; i < 6; i++){

            if(topNum == list.get(cnt+1).get(i)){ // 이때 i는 cnt + 1의 bot_idx가 되는 것이다.
                switch(i){
                    case 0:
                        top_idx = 5;
                        break;
                    case 1:
                        top_idx = 3;
                        break;
                    case 2:
                        top_idx = 4;
                        break;
                    case 3:
                        top_idx = 1;
                        break;
                    case 4:
                        top_idx = 2;
                        break;
                    case 5:
                        top_idx = 0;
                        break;
                }
                bot_idx = i;
                break;
            }
        }

        num = dfs(cnt + 1, top_idx, bot_idx);

        // num은 현제 리턴 받은 cnt+1 주사위의 최대값이다. 이제 cnt 주사위의 최대값을 찾아야 한다.
        int Max = 0;
        for(int i = 0; i < 6; i++){

            if(list.get(cnt).get(i) == list.get(cnt).get(topIdx) || list.get(cnt).get(i) == list.get(cnt).get(botIdx)){
                continue;
            }

            Max = Math.max(Max, list.get(cnt).get(i));
        }
        return (num+Max);
    }
}