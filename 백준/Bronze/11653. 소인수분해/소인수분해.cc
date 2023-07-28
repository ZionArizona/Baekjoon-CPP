#include<iostream>
#include<utility>
#include<algorithm>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	int N =0;
	cin >> N;
	
	if (N == 1) {
		return 0;
	}

	while (true) {
		for (int i = 2; i <= N; i++) {
			if (i == 2 || i == 3 || (i % 2 != 0 && i % 3 != 0)) {
			    if(N %i == 0){
				    cout << i << "\n";
				    N /= i;
			        
				    break;
			    }
			}
		}
		if (N == 1) {
			break;
		}
	}



}