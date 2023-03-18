#include<vector>
#include<iostream>
using namespace std;

int main()
{
	int N = 0;
	int K = 0;
	cin >> N >> K;

	vector<vector<int>>vec(N + 1, vector<int>(K + 1 , 0));

	//nCk = (n-1)Ck + (n-1)C(k-1)

	for (int i = 1; i <= N; i++)
	{
		for (int j = 0; j <= K; j++)
			if (j == 0 || i == j) vec[i][j] = 1;
			else vec[i][j] = ((vec[i - 1][j] + vec[i - 1][j - 1]) % 10007);
	}
	
	cout << vec[N][K];
}