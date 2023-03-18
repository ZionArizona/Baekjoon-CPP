#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    int n;
    cin >>n;
    vector<int> vec1;
    int temp = 0;
    for(int i = 0; i < n; i++)
    {
        cin >> temp;
        vec1.push_back(temp);
    }
    
    sort(vec1.begin(),vec1.end());
    
    int m;
    cin >> m;
    vector<int> vec2;
    for(int i = 0; i < m; i++)
    {
        cin >> temp;
        vec2.push_back(temp);
    }
    
    vector<int>::iterator upper, lower;
    vector<int> answer(m);
    
    for(int i =0 ; i < m; i++)
    {
        upper = upper_bound(vec1.begin(), vec1.end(), vec2[i]);
        lower = lower_bound(vec1.begin(), vec1.end(), vec2[i]);\
        answer[i] = upper - lower;     
    }
    for(int i =0; i < m; i++)
    {
        cout << answer[i] << " ";
    }
}