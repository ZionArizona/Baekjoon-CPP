#include<bits/stdc++.h>

using namespace std;
int main()
{
    ios::sync_with_stdio(0);
    cout.tie(0);
    cin.tie(0);
    
    int N, K;
    
    cin >> N >> K;
    
    int arr[N+1] = {0};
    
    int Max = -1000000;
    
    int temp = 0;
    
    for(int i = 1; i <= N; i++){
        cin >> temp;
        arr[i] = arr[i-1] + temp;
    }
    
    for(int i = K; i <= N; i++){
        Max = max(Max, arr[i] - arr[i - K]);
    }
    
    cout << Max;
    
    
    return 0;
}