#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

//sort() 함수 말고 퀵 정렬로도 가능하다.
int main()
{
    int num;
    int tmp;
    vector<int> a;
    cin >> num;
    for(int i = 0; i < num; i++)
    {
        cin >> tmp;
        a.push_back(tmp);
    }
    sort(a.begin(),a.end());
    for(int i = 0; i < num; i++)
        cout << a[i] << '\n';

	
}