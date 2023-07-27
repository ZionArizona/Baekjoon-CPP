#include<iostream>
#include<string>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
	
	int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0;

	cin >> a >> b >> c >> d >> e >> f;

	cout << (1 - a) << " " << (1 - b) << " " << (2 - c) << " " << (2 - d) << " " << (2 - e) << " " << (8 - f);

}