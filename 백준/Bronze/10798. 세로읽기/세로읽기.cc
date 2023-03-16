#include<iostream>
#include<string>
using namespace std;
char str[5][16];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);cout.tie(0);
    
    
    
    for(int i =0; i < 5; i++)
    {
        cin >> str[i];
    }
    
    
    for(int i = 0;  i< 15; i++)
    {
        for(int j = 0; j < 5; j++)
        {
            if(str[j][i] != '\0')
                cout << str[j][i];
        }
    }
    
}