#include<iostream>
using namespace std;
int gcd(int a, int b)
{
    ios::sync_with_stdio(0);
    cin.tie(0);cout.tie(0);
    int c = 0;
    while(b!=0)
    {
        c = a % b;
        a = b;
        b = c;
    }
    return a;
}

int main()
{
    int a = 0, b = 0;
    cin >> a >> b;
    int g = gcd(a,b);
    int q = (a*b)/g;
    
    cout << g << "\n" << q << "\n";
}