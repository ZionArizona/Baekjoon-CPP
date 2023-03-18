#include<iostream>
using namespace std;

int main()
{
	int  N = 0; 
	cin >> N;

	int ans = 0;

	while (N >= 0)
	{
		if (N % 5 == 0)
		{
			ans += (N / 5);
			cout << ans;
			return 0;
		}
		N -= 3;
		ans++;
		if (N == 0)
		{
			cout << ans;
			return 0;
		}
	}

	cout << "-1";
}