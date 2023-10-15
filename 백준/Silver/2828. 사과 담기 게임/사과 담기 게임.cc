#include<bits/stdc++.h>

using namespace std; 

int main(){

    int n,m,j;
    cin >> n >> m;
    cin >> j;
    
    int k = 0;
    
    int cnt = 0;
    int l = 1;
    int r = 0;
    
    for(int i = 0; i < j; i++){
        r = l + m  -1;
        cin >> k;
        
        if(k >= l && k <= r) continue;
        else{
            if(k>r){
                cnt += (k-r);
                l += (k - r);
            }
            else{
                cnt += (l - k);
                l = k;
            }
        }
        
    }
    
    cout << cnt;
        
    return 0;

}