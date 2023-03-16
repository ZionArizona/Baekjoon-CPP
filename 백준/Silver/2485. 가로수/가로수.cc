#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int gcd(int a, int b)
{
    int temp = 0;
    while(a != 0)
    {
        temp = b % a;
        b = a;
        a = temp;
    }
    
    return b;
    
}


int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);cout.tie(0);
    
    int n = 0;
    cin >> n;
    int temp = 0;
    int count = 0;
    vector<int> vec;
    vector<int> m_vec;
    sort(vec.begin(),vec.end());
    for(int i =0; i < n; i++)
    {
        cin >> temp;
        vec.push_back(temp);
    }
    
    for(int i = 0; i < n -1; i++)
    {
        temp = vec[i+1] - vec[i];
        m_vec.push_back(temp);
    }
    
    
    int bet = gcd(m_vec[0], m_vec[1]);
    
    for(int i =0 ; i < n - 1; i++)
    {
        count += ((m_vec[i])/bet - 1);   
    }
    
    cout << count;
}