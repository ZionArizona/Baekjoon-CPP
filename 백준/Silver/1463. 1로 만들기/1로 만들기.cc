#include<iostream>
#include<utility>
#include<algorithm>
#include<cmath>
using namespace std;

int d[1000001];

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);


    int n = 0;
    cin >> n;

    d[1] = 0;
    
    if(n  == 1){
        cout << d[1];
        return 0;
    }
    
    for(int i = 2; i <= n; i++){
        d[i] = d[i-1] + 1;
        if(i % 2 == 0){
            d[i] = min(d[i/2] + 1, d[i]);
        }
        if(i % 3 == 0){
            d[i] = min(d[i/3] + 1, d[i]);
        }
    }
    
    cout << d[n];
    
}