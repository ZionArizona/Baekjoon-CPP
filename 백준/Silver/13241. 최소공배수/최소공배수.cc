#include<iostream>
using namespace std;

long long int t_ans(long long int a, long long int b)
{
	long long gcd = 1, lcm = 1;
	long long int temp_a = a, temp_b = b;
	
	while (gcd != 0)
	{
		
		gcd = temp_a % temp_b;
		temp_a = temp_b;
		temp_b = gcd;

	}
	a /= temp_a;
	b /= temp_a;

	lcm = a * b * temp_a;

	return lcm;

}


int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	int a, b,temp;
	long long ans;
	cin >> a >> b;

	if (b > a)
	{
		temp = a;
		a = b;
		b = temp;
	}

	ans = t_ans(a, b);

	cout << ans;

}