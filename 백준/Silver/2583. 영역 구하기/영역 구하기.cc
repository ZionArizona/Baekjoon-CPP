#include <bits/stdc++.h>
using namespace std;

int dy[4] = {-1,0,1,0};
int dx[4] = {0,1,0,-1};

int arr[105][105];
int visited[105][105];
vector<int> vec;
int N,M,K;
int cnt;
int ret = 0;

void dfs(int y, int x){
    visited[y][x] = 1;
    
    cnt++;
    
    int ny;
    int nx;
    
    for(int i =0; i < 4; i++){
        ny = y + dy[i];
        nx = x + dx[i];
        if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
        if(visited[ny][nx] == 0 && arr[ny][nx] == 0){
            dfs(ny,nx);
        }
    }
}


int main()
{
    cin >> M >> N >> K;
    
    for(int i = 0; i < K; i++){
        int a,b,c,d;
        cin >> a >> b >> c >> d;
        for(int j = a; j < c; j++){
            for(int k = b; k < d; k++){
                arr[k][j] = 1;
            }
        }
    }
    
    
    for(int i = 0; i < M; i++){
        for(int j = 0; j < N; j++){
            if(arr[i][j] == 0 && visited[i][j] == 0){
                ret++;
                dfs(i,j);
                vec.push_back(cnt);
                cnt =0;
            }
        }
    }
    
    sort(vec.begin(), vec.end());

    cout << ret << "\n";
    
    for(int i = 0; i < vec.size(); i++){
        cout << vec[i] << " ";
    }
    
    return 0;
}
