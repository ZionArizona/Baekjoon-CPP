#include <iostream>

using namespace std;

int self[301];
int dp[301] =  {0};
int check[301];

int main()
{
    int  N;
    cin >> N;
    check[1] = 1;
    for(int i = 1; i <= N; i++)
    {
        cin >> self[i];
    }
    
    dp[1] = self[1];
    dp[2] = self[1] + self[2];
    dp[3] = max(self[1] + self[3], self[2] + self[3]);
    
    for(int i = 4; i <= N; i++)
    {
        dp[i] = max(dp[i-2], dp[i-3] + self[i-1]) + self[i];       
    }
    
    cout << dp[N];
    
    return 0;
}
