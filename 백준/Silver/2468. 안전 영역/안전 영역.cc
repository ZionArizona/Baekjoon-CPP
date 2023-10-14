#include <bits/stdc++.h>
using namespace std;

int dy[4] = {-1,0,1,0};
int dx[4] = {0,1,0,-1};

int arr[105][105];
int visited[105][105];
int a[105][105];
int N;
int cnt;

void dfs(int y, int x){
    visited[y][x] = 1;
    
    int ny;
    int nx;
    
    for(int i =0; i < 4; i++){
        ny = y + dy[i];
        nx = x + dx[i];
        if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
        if(visited[ny][nx] == 0 && a[ny][nx] == 1){
            dfs(ny,nx);
        }
    }
}


int main()
{
    
    cin >> N;
    
    int Max = 0;
    int Min = 100;
    
    for(int i = 0; i < N; i++){
        for(int j = 0; j < N; j++){
            cin >> arr[i][j];
            Min = min(Min,arr[i][j]);
            Max = max(Max,arr[i][j]);
        }
    }
    
    
    int FMax = 1;
    
    for(int H = Min; H <= Max; H++){
        cnt = 0;
        fill(&a[0][0], &a[0][0] + 105*105, 0);
        fill(&visited[0][0], &visited[0][0] + 105*105, 0);
        
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(arr[i][j] > H){
                    a[i][j] = 1; 
                }
            }
        }
        
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(a[i][j] == 1 && visited[i][j] == 0){
                    dfs(i,j);
                    cnt++;
                }
            }
        }
        
        
        FMax = max(FMax, cnt);
        
    }
    
    cout << FMax;
    
    return 0;
}