#include <iostream>
#include<algorithm>
using namespace std;
int house_price[1001][3];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);cout.tie(0);
    int N;
    cin >> N;
    
    int cost[3];
    house_price[0][0] = 0;
    house_price[0][1] = 0;
    house_price[0][2] = 0;
    
    for(int i = 1; i <= N; i++)
    {
        cin >> cost[0] >> cost[1] >> cost[2];
        house_price[i][0] = min(house_price[i-1][1],house_price[i-1][2]) + cost[0];
        house_price[i][1] = min(house_price[i-1][0],house_price[i-1][2]) + cost[1];
        house_price[i][2] = min(house_price[i-1][0],house_price[i-1][1]) + cost[2];
    }
    cout << min(house_price[N][0],min(house_price[N][1], house_price[N][2]));
    return 0;
}