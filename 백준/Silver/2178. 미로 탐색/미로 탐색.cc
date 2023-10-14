#include <bits/stdc++.h>
#define max 105
using namespace std;

int arr[max][max];
int visited[max][max];

int dy[4] = {-1,0,1,0};
int dx[4] = {0,1,0,-1};

queue<pair<int,int>> q;

int main()
{
    int N = 0;
    int M = 0;
    
    cin >> N >> M;
    
    
    for(int i = 0; i < N; i++){
        string row;
        cin >> row;
        for(int j = 0; j < M; j++){
            arr[i][j] = row[j] - '0';
        }
    }
    
    q.push({0,0});
    
    visited[0][0] = 1;
    
    while(q.size()){
        int y = q.front().first;
        int x = q.front().second;
        q.pop();
        
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= N || nx >= M  || arr[ny][nx] == 0 ) continue;
            if(visited[ny][nx]) continue;
            visited[ny][nx] = visited[y][x] + 1;
            q.push({ny,nx});
        }
        
    }
    
    
    cout << visited[N-1][M-1];
    
    
    return 0;
}
