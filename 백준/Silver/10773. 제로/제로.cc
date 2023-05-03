#include <iostream>
#include<stack>

using namespace std;

stack<int> stk;

int main()
{
    ios::sync_with_stdio;
    cin.tie(0);cout.tie(0);
    int k = 0;
    cin >> k;
    int temp;
    for(int i = 0 ; i < k ; i++){
        cin >> temp;
        if(temp == 0){
            stk.pop();
            continue;
        }
        stk.push(temp);
    }
    
    int sum = 0;
    int size = stk.size();
    for(int i = 0; i < size; i++){
        sum += stk.top();
        stk.pop();
    }
    
    cout << sum;
    
    return 0;
}
