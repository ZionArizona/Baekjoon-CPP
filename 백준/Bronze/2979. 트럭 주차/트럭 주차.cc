#include<bits/stdc++.h>

using namespace std;

int A,B,C,a,b,sum;


int main()
{
    ios::sync_with_stdio(0);
    cout.tie(0);
    cin.tie(0);
    
    int count[105] = {0};
    
    cin >> A >> B >> C;
    
    for(int i = 0 ; i < 3; i++){
        cin >> a >> b;
        for(int j = a; j < b; j++){
            count[j]++;
        }
    }
    
    for(int i = 0; i <= 100; i++){
        if(count[i] == 0) continue;
        else if(count[i] == 1) sum += A;
        else if(count[i] == 2) sum += (2*B);
        else sum += (3*C);
    }
    
    cout << sum;
    

    return 0;
}
