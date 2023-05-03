#include <iostream>
#include<stack>

using namespace std;


int VPS(string str){
    stack<int> stk;
    if((str.length())%2 != 0){
        cout << "NO" << "\n";
    }
    else{
        for(int i = 0 ; i < str.length(); i++){
            if(str[i] == '('){
                stk.push(true);
            }
            else{
                if(stk.size() > 0){
                    stk.pop();
                }
                else{
                    cout << "NO" << "\n";
                    return 0;
                }
            }
        }
        
        if(stk.size() != 0){
            cout << "NO" << "\n";
        }
        else {
            cout << "YES" << "\n";
        }
        
        
    }
    return 0;
}


int main()
{
    ios::sync_with_stdio;
    cin.tie(0);cout.tie(0);
    int N = 0;
    cin >> N;
    string str = "";
    
    for(int i = 0; i < N; i++){
        cin >> str;
        VPS(str);
    }
    
    
    return 0;
}
