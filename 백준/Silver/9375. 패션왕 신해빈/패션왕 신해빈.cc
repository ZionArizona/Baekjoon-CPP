#include<map>
#include<iostream>
using namespace std;



int main()
{
	ios::sync_with_stdio(0);
	
	int N;
	cin >> N;
	int test = 0;
	string wear = "";
	string type = "";

	for (int i = 0; i < N; i++)
	{
		map<string, int> mp;

		cin >> test;
		for (int i = 0; i < test; i++)
		{
			cin >> wear >> type;
			if (mp.find(type) == mp.end()) mp[type] = 1;
			else
			{
				mp[type]++;
			}
		}
		
		int ans = 1;
		map<string, int>::iterator iter;
		for (iter = mp.begin(); iter != mp.end(); iter++)
		{
			ans *= (iter->second + 1);
			//or ans *= (mp[iter->first] + 1);
		}

		ans -= 1;

		cout << ans << "\n";


	}

}