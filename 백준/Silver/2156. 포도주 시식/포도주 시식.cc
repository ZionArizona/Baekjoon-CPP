#include <iostream>
#include<cmath>
#include<algorithm>

using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    
    int N = 0;
    cin >> N;
    
    int arr[N+1] = {0};
    
    int dp[N+1] = {0};
    
    for(int i = 1 ; i <= N; i++){
        cin >> arr[i];
    }
    dp[1] = arr[1];
    dp[2] = arr[1] + arr[2];
    
    for(int i = 3; i <= N; i++){
        dp[i] = max(dp[i-1], max(dp[i-3] + arr[i] + arr[i - 1], dp[i-2] + arr[i]));
    }

    cout << dp[N];

    return 0;
}