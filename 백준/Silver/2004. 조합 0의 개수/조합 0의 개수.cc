#include<iostream>
using namespace std;
int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	int n, m;
	cin >> n >> m;

	int denR = n - m;
	
	long long ans_five = 0;
	long long ans_fiveL = 0;
	long long ans_fiveR = 0;
	
	long long ans_two = 0;
	long long ans_twoL = 0;
	long long ans_twoR = 0;


	if (m == 0 || n == m)
	{
		cout << 0;
		return 0;
	}
	



	for (long long i = 5; i <= n; i *= 5)
	{
		ans_five += n / i;
		ans_fiveL += m / i;
		ans_fiveR += denR / i;
	}

	ans_five -= (ans_fiveL + ans_fiveR);
	
	for (long long i = 2; i <= n; i *= 2)
	{
		ans_two += n / i;
		ans_twoL += m / i;
		ans_twoR += denR / i;
	}

	ans_two -= (ans_twoL + ans_twoR);
	
	
	if ((ans_five >= 1 && ans_two == 0) || (ans_five == 0 && ans_two >= 1) || (ans_five == 0 && ans_two == 0))
	{
		cout << 0;
		return 0;
	}
	else if (ans_five >= 1 && ans_two >= 1)
	{
		if (ans_five >= ans_two)
		{
			cout << ans_two;
			return 0;
		}
		else if (ans_two >= ans_five)
		{
			cout << ans_five;
			return 0;
		}
	}

	return 0;
}