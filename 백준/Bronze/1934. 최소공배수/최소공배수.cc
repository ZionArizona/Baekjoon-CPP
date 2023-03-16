#include<iostream>
#include<vector>
using namespace std;
int gcd(int a, int b)
{
    ios::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    int c = 0;
    while (b != 0)
    {
        c = a % b;
        a = b;
        b = c;
    }
    return a;
}

int main()
{
    int T = 0;
    cin >> T;
    int a = 0, b = 0;
    vector<int> vec;
    for (int i = 0; i < T; i++)
    {
        cin >> a >> b;
        int g = gcd(a, b);
        int q = (a * b) / g;
        vec.push_back(q);

    }
    for(int i = 0; i < T; i++)
    {
        cout << vec[i] << "\n";
    }
    
}