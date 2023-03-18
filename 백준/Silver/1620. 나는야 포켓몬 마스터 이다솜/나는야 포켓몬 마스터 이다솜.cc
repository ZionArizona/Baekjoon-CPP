#include<iostream>
#include<map>
#include<vector>
#include<string>
using namespace std;

int main()
{
    
    ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
    
    int n, m;
    map<string, int > mp;
    string temp;
    cin >> n  >> m;
    vector<string> name;
    vector<string> result;
    
    for(int i =1 ; i <=n ; i++)
    {
        cin >> temp;
        mp.insert(make_pair(temp,i));
        name.push_back(temp);
    }
    for(int i =0; i < m; i++)
    {
        cin >> temp;
        if(temp[0] >= 65 && temp[0] <= 90)
        {
            result.push_back(to_string(mp[temp]));
        }
        else
        {
            result.push_back(name[stoi(temp) - 1]);
        }
    }
    
    
    for(int i = 0; i < m; i++)
    {
        cout << result[i] << "\n";
    }


    return 0;
}
