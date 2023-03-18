#include<vector>
#include<iostream>
using namespace std;

int Factorial(int a)
{
	int result = 1;

	if (a == 0) return 1;

	for (int i = a; i >= 1; i--)
	{
		result *= i;
	}

	return result;
}


int ans(int a, int b)
{
	int fac = Factorial(a);
	int gcd = Factorial(a - b) * Factorial(b);

	return fac / gcd;

}
int main()
{
	int N = 0;
	int K = 0;

	cin >> N >> K;

	cout << ans(N, K);

}