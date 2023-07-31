#include <iostream>

using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    
    long long d[105][11] = {0};
    
    int N = 0;
    cin >> N;
    
    long long ans = 0;
    
    for(int i = 1; i <=9 ; i++){ d[1][i] = 1; }
    
    for(int i = 2; i <= N; i++){
        for(int j = 0; j <= 9; j++){
            if(j == 0){
                d[i][j] = (d[i-1][1]) % 1000000000 ;
            }
            else if(j == 9){
                d[i][j] = (d[i -1 ][8]) % 1000000000;
            }
            else{
                d[i][j] = (d[i-1][j-1] + d[i - 1][j+1]) % 1000000000;
            }
            
        }
    }
    
    
    for(int j = 0; j <=9; j++){
        ans += d[N][j];
    }
    
    cout << (ans%1000000000);
    
    return 0;
}