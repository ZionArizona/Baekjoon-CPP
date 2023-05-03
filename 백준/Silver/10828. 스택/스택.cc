#include <iostream>
#include<stack>

using namespace std;

stack<int> stk;


int main()
{
    ios::sync_with_stdio;
    cin.tie(0);cout.tie(0);
    int N = 0;
    cin >> N;
    string inst = "";
    int temp = 0;
    for(int i = 0 ; i < N; i++){
        cin >> inst;
        //push , pop, size, empty, top
        if(inst == "push"){
            cin >> temp;
            stk.push(temp);
        }
        else if(inst == "pop"){
            if(stk.size() != 0){
                cout << stk.top() << "\n";
                stk.pop();
            }
            else{
                cout << "-1" << "\n";
            }
        }
        else if (inst == "size"){
             cout << stk.size() << "\n";
        }
        else if (inst == "empty"){
            if(stk.size() == 0){
                cout << "1" << "\n";
            }    
             else {
                cout << "0" << "\n";
            }
        }
        else if(inst == "top"){
            if(stk.size() != 0){
                cout << stk.top() << "\n";
            }
            else {
            cout << "-1" << "\n";
            }
        }
    }
    
    
    return 0;
}
