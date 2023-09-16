#include<bits/stdc++.h>

using namespace std;

string pattern = "";

int main()
{
    ios::sync_with_stdio(0);
    cout.tie(0);
    cin.tie(0);
    
    int N = 0;
    
    cin >> N;
    cin >> pattern;
    
    string tmp = "";
    
    int strfind = pattern.find("*");
    
    string pre = pattern.substr(0,strfind);
    string aft = pattern.substr(strfind+1);
    
    for(int i = 0; i < N; i++){
        cin >> tmp;
        //첫 if를 하지 않으면 runtime에러 발생. 첫 if를 통해 시간 복잡도를 줄인다!!!
        if(pre.size() + aft.size() > tmp.size()){
            cout << "NE\n";
        }
        else{
            if(pre == tmp.substr(0,pre.size()) && aft == tmp.substr(tmp.size() - aft.size())){
                cout << "DA\n";
            }
            else{
                cout << "NE\n";
            }
        }
    }

    return 0;
}