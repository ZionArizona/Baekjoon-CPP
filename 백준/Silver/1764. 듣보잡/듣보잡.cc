#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    
    vector<string> vec1;
    vector<string> vec2;
    int n,m;
    cin >> n >> m;
    string temp;
    for(int i = 0; i < n; i++)
    {
        cin >> temp;
        vec1.push_back(temp);
    }
    
    
    for(int i =0; i < m; i++)
    {
        cin >> temp;
        vec2.push_back(temp);
    }
    
    
    sort(vec1.begin(), vec1.end());
    sort(vec2.begin(), vec2.end());
    
    vector<int>::iterator it;
    vector<string> answer;
    
 
    if(n > m)
    {
        for(int i =0; i < n; i++)
        {
            if(binary_search(vec2.begin(),vec2.end(), vec1[i]))
            {
                answer.push_back(vec1[i]);
            }
        }
    }
    else
    {
        for(int i =0; i < m; i++)
        {
            if(binary_search(vec1.begin(),vec1.end(), vec2[i]))
            {
                answer.push_back(vec2[i]);
            }
        }
    }
      
    sort(answer.begin(), answer.end());
    cout << answer.size() << "\n";
    for(int i =0; i < answer.size(); i++)
    {
        cout << answer[i] << "\n";
    }
}