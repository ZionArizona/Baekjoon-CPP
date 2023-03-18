#include<iostream>
#include<vector>
#include<algorithm>
#include<cmath>
using namespace std;



int findgcd(int a, int b)
{
    int temp = 0;
    while (b != 0)
    {
        temp = a % b;
        a = b;
        b = temp;
    }

    return a; 
}

void findDiviser(int a)
{
    vector<int> vec;
    for (int i = 1; i <= sqrt(a); i++)
    {
        if (a % i == 0)
        {
            vec.push_back(i);
            if(i != a/i) vec.push_back(a/i);
        }
    }

    
    sort(vec.begin(), vec.end());
    for (int i = 1; i < vec.size(); i++)
    {
        cout << vec[i] << " ";
    }
    
}


int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    int T = 0;
    cin >> T;
    vector<int> vec;
    int temp = 0;
    vector<int> rvec;
    for (int i = 0; i < T; i++)
    {
        cin >> temp;
        vec.push_back(temp);
    }
    sort(vec.begin(), vec.end());

    int gcd = vec[1] - vec[0];

    for (int i = 2; i < T; i++)
    {
        int next_gcd = vec[i] - vec[i - 1];
        gcd = findgcd(gcd, next_gcd);
    }

    findDiviser(gcd);
    
}