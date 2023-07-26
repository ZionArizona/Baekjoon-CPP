#include<iostream>
#include<string>
using namespace std;


int main() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	int N = 0;
	cin >> N;

	int count = 0;

	for (int i = 0; i < N; i++) {
		bool flag[26] = {false} ;
		string str = "";
		cin >> str;
		for (int j = 0; j < str.length(); j++) {
			if(j == (str.length() - 1) && (flag[int(str[j] - 97)] == false || (flag[int(str[j] - 97)] == true && str[j] == str[j - 1]))) {
				count++;
			}
			else if (flag[int(str[j] - 97)] == false) {
				flag[int(str[j] - 97)] = true;
				continue;
			}
			else if (flag[int(str[j] - 97)] == true && str[j] != str[j - 1]) {
				break;
			}
		}
	}
	
    
	cout << count;
	
}