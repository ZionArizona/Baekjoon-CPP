#include<iostream>
using namespace std;
long long arr[101];

int main()
{
	ios::sync_with_stdio;
	cin.tie(0); cout.tie(0);
	int N = 0;
	cin >> N;
	
	int temp = 0;
	arr[1] = 1;
	arr[2] = 1;
	arr[3] = 1;

	for (int i = 0; i < N; i++)
	{
		cin >> temp;
		if (temp == 1 || temp == 2 || temp == 3){
			cout << "1" << "\n";
			continue;
		}
		for (int j = 4; j <= temp; j++)
		{
			arr[j] = arr[j - 3] + arr[j - 2];
		}
		cout << arr[temp] << "\n";
	}

}