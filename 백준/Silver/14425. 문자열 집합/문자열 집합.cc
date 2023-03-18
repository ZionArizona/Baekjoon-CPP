#include<iostream>
#include<string>
#include<map>
using namespace std;
int main()
{
    int n =0;
    int m =0;
    cin >> n >> m;
    map<string,bool> mp;
    for(int i =0 ; i < n; i ++)
    {
        string str;
        cin >> str;
        mp[str] = true;
    }
    int count = 0;
    for(int i =0; i < m; i++)
    {
        string str1;
        cin >> str1;
        if(mp[str1] == true)
        {
            count++;
        }
    }
    cout << count;
}