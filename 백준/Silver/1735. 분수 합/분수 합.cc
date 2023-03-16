#include<iostream>
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
    
    int a,b,c,d;
    cin >> a >> b >> c >> d;
    
    int up = a*d+b*c;
    int down = b *d;
    
    int min = gcd(up,down);
    
    cout << (up/min) << " " << (down/min);
    
}