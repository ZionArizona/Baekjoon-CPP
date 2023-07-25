#include<iostream>
#include<vector>
using namespace std;


int main(){
    int N;
    vector<int> dis;
    vector<int> gas;

    cin >> N;

    for(int i = 0 ; i < N-1; i++){
        int temp = 0;
        cin >> temp;
        dis.push_back(temp);
    }
    for(int i = 0 ; i < N; i++){
        int temp = 0;
        cin >> temp;
        gas.push_back(temp);
    }
    
    int min = gas[0];
    int ans = gas[0] * dis[0];
    
    for(int i = 1; i < N- 1; i++){
        if(gas[i] > min){
            ans += min * dis[i];
        }
        else{
            min = gas[i];
            ans += min * dis[i];
        }
    }
    cout << ans;
}