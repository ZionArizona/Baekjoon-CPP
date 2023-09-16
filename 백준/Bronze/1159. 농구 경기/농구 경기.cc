#include <bits/stdc++.h>

using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cout.tie(0);
    cin.tie(0);
    
    int N = 0;
    
    int count[123] = {0};
    
    cin >> N;
    
    for(int i = 0; i < N; i++){
        string str = "";
        cin >> str;
        
        count[str[0]]++;
    }
    
    int ctn = 0;
    
    for(int i = 97; i < 123; i++){
        if(count[i] >= 5){
            cout << char(i);
            continue;
        }
        else{
            ctn++;
        }
    }
    
    if(ctn == 26){
        cout << "PREDAJA";
    }

    return 0;
}
