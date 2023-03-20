#include <iostream>
using namespace std;


int dp[1000001];

int main()
{
    int N;
    cin >> N;
    
    dp[1] = 0;
    dp[2] = 1;
    dp[3] = 1;

    if(N == 1){
        cout << dp[1];
    }
    else if(N == 2){
        cout << dp[2];
    }
    else if(N == 3){
        cout << dp[3];
    }
    else{
        for(int i = 4; i <= N; i++)
        {
            dp[i] = dp[i - 1] + 1;
            if(i%3 == 0)
                dp[i] = min(dp[i], dp[i/3] + 1);
            if(i%2 == 0)
                dp[i] = min(dp[i], dp[i/2] + 1);
            
        }  
        cout << dp[N];
    }
    
    return 0;
}
