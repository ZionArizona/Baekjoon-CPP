#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
	int N;
	int k;
	cin >> N >> k;
	int temp = 0;
	vector<int> vec;
	for (int i = 0; i < N; i++)
	{
		cin >> temp;
		vec.push_back(temp);
	}

	sort(vec.begin(), vec.end(), greater<int>());

	cout << vec[k - 1];

}