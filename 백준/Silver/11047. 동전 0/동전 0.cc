#include <iostream>

using namespace std;

int main()
{
    int n = 0;
    int k = 0;
    int ans = 0;
    
    cin >> n >> k;
    
    int a[n] = {0};
    for(int i = 0; i < n; i++) cin >> a[i];
    for(int i = n-1; i >= 0 ; i--){
        ans += k/a[i];
        k = k%a[i];
    }
    
    
    cout << ans;
    
    
    return 0;
}