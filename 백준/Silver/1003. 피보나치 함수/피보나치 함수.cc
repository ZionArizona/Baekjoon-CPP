#include<iostream>
#include<vector>
using namespace std;

long long R0[41] = {1,0};
long long R1[41] = {0,1};

int main(){
    int N;

    cin >> N;

    for(int i = 0 ; i < N; i++){
        int temp = 0;
        cin >> temp;
        if(temp == 0 || temp == 1){
            if(temp == 0){
                cout << "1 0" << "\n";
                continue;
            }
            else{
                cout << "0 1" <<"\n";
                continue;
            }
            
        }
        for(int i = 2; i <= temp; i++){
            R0[i] = R0[i-1] + R0[i - 2];
            R1[i] = R1[i-1] + R1[i - 2];
        }
        
        cout << R0[temp] << " " << R1[temp] << endl;
    }
}