#include <bits/stdc++.h>

using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cout.tie(0);
    cin.tie(0);
    
    string str = "";
    
    getline(cin,str);
    
    for(int i = 0; i < str.length(); i++){  
        if(str[i] >= 97 && str[i] < 123){
            if(str[i] + 13 > 122){
                cout << char(str[i] + 13 - 26);
            }
            else{
                cout << char(str[i] + 13);
            }
        }
        else if(str[i] >=65 && str[i] <= 90){
            if(str[i] + 13 > 90){
                cout << char(str[i] + 13 -26);
            }
            else{
                cout << char(str[i] + 13);
            }
        }
        else{
            cout << str[i];
        }
    }
    
    return 0;
}