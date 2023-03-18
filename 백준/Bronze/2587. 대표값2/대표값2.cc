#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
	vector<int> vec;
	int temp = 0;
	for (int i = 0; i < 5; i++)
	{
		cin >> temp;
		vec.push_back(temp);
	}

	sort(vec.begin(), vec.end());

	int sum = 0;

	for (int i = 0; i < 5; i++)
	{
		sum += vec[i];
	}

	cout << sum/5 << endl;
	cout << vec[2];

}