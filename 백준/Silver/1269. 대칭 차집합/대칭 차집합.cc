#include <iostream>
#include<vector>
#include<map>
using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);cout.tie(0);
    int n,m;
    cin >> n >> m;
    int ans = 0;
    map<int, bool> map1;
    
    int temp;
    
    for(int i= 0; i < n; i++)
    {
        cin >> temp;
        map1[temp] = true;
    }
    
    for(int i= 0; i < m; i++)
    {
        cin >> temp;
        if(map1[temp] == true) 
            ans++;
        
        
    }

    cout << n+m - (ans * 2);
    
    return 0;
}
