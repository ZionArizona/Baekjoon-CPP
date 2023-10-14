#include <bits/stdc++.h>
#define max 55
using namespace std;

int dy[4] = {-1,0,1,0};
int dx[4] = {0,1,0,-1};

int arr[55][55];
bool visited[55][55];


int N, M, K;
int cnt;
int ny;
int nx;

void dfs(int y, int x){
    visited[y][x] = 1;
    for(int i = 0; i < 4; i++){
        ny = y + dy[i];
        nx = x + dx[i];
        if(ny < 0 || ny >=N || nx <0 || nx >= M) continue;
        if(visited[ny][nx] == 0 && arr[ny][nx]){
            dfs(ny,nx);
        }
    }
}


int main()
{
    
    int T = 0;
    cin >> T;
    
    for(int i = 0; i < T; i++){
        cnt = 0;
        fill(&arr[0][0], &arr[0][0] + 55 * 55, 0);
        fill(&visited[0][0], &visited[0][0] + 55 * 55, 0);
        cin >> M >> N >> K;
        int a,b;
        for(int i = 0 ; i < K; i++){
            cin >> a >> b;
            arr[b][a] = 1;
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(arr[i][j] == 1 && visited[i][j] == 0){
                    dfs(i,j);
                    cnt++;
                }
            }
        }
        
        cout << cnt << "\n";
        
    }
    
    
    return 0;
}