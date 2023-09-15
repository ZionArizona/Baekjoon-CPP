#include<iostream>
#include<string>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
	
	string str = "";
	cin >> str;



	for (int i = 0; i < str.length() / 2; i++) {
		if (str[i] == str[str.length() - i - 1]) {
			continue;
		}
		else {
			cout << "0";
			return 0;
		}
	}

	cout << "1";

}