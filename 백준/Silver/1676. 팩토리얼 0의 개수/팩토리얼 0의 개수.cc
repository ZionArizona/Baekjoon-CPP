#include<iostream>
using namespace std;



int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	int n;
	int ans = 0;
	cin >> n;

    
    
	for (int i = 5; i <= n; i *= 5)
	{
		ans += (n / i);
	}

	cout << ans;

	return 0;
}