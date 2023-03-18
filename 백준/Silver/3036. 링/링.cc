#include<vector>
#include<iostream>
using namespace std;

int pr(int a, int b)
{
	
	int temp = 0;

	while (b != 0)
	{
		temp = a % b;
		a = b;
		b = temp;
	}

	return a;
}

int main()
{
	int N = 0;
	int temp = 0;
	cin >> N;
	int gcd = 0;
	
	vector<int> vec;

	for (int i = 0; i < N; i++)
	{
		cin >> temp;
		vec.push_back(temp);
	}

	for (int i = 1; i < N; i++)
	{
		gcd = pr(vec[0], vec[i]);

		cout << (vec[0] / gcd) << "/" << (vec[i] / gcd) << "\n";
	}

}