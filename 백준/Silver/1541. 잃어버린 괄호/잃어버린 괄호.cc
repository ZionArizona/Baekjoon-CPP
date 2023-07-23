#include<iostream>
#include<vector>
#include<algorithm>
#include<string>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	string str = "";
	cin >> str;
	
	string strR = "";

	int ans = 0;
	bool mi = false;

	for (int i = 0; i <= str.size(); i++) {
		if (str[i] == '-' || str[i] == '+' || i == str.size()) {
			if (mi == true) {
				ans -= stoi(strR);
				strR = "";
			}
			else {
				ans += stoi(strR);
				
				strR = "";
			}
		}
		else {
			strR += str[i];	
		}

		if (str[i] == '-') {
			mi = true;
		}

	}


	cout << ans;

}