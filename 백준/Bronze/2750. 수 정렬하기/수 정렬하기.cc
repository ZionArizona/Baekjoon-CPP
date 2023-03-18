#include<iostream>
#include<vector>
using namespace std;

void sort(vector<int> vec, int num)
{
	int temp = 0;
	for (int i = 0; i < num - 1; i++)
	{
		for(int j =0; j < num - 1; j++)
		{
			if (vec[j] > vec[j + 1])
			{
				temp = vec[j];
				vec[j] = vec[j + 1];
				vec[j + 1] = temp;
			}
		}
	}

	for (int i = 0; i < num; i++)
	{
		cout << vec[i] << endl;
	}
}



int main()
{
	int N = 0;
	cin >> N;

	vector<int> v(N);
	for (int i = 0; i < N; i++)
	{
		cin >> v[i];
	}
	sort(v,N);
}