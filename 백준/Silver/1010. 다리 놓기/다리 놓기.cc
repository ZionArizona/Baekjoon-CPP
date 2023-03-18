#include<vector>
#include<iostream>
using namespace std;



int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
	int M;
	cin >> M;
	int n, m;
	vector<int> vec;

	int arr[31][31] = { 0 };

	for (int i = 1; i < 31; i++)
	{
		for (int j = 0; j < 31; j++)
		{
			if (i == j || i == 1 || j == 0) arr[i][j] = 1;
			else arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
			//cout << "i: " << i << " j: " << j << "    " << arr[i][j] << endl;
		}
	}

	for (int i = 0; i < M; i++)
	{
		cin >> n >> m;
		cout << arr[m][n] << "\n";
	}
	

}