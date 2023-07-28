#include<iostream>
#include<utility>
#include<algorithm>
#include<cmath>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);


    int n = 0;
    cin >> n;


    for (int i = 0; i < n; i++) {
        long long temp = 0;
        cin >> temp;
        bool flag = true;

        if (temp == 0 || temp == 1 || temp == 2) {
            cout << 2 << "\n";
            continue;
        }
        else if (temp == 3) {
            cout << temp << "\n";
            continue;
        }
       
        while(flag){
            for (long long j = 2; j <= int(sqrt(temp)); j++ ) {
                if(j == int(sqrt(temp)) && temp%j != 0){
                    flag = false;
                    break;
                }
                else if (temp % j == 0) {
                    temp++;
                    break;
                }
                else if (temp%j != 0) {
                    continue;
                }
            }
        }
        cout << temp << endl;
    }
}