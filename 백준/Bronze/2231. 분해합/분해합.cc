#include<iostream>
using namespace std;


int main()
{
    int N;
    cin >> N;
    int num = 0; 
    int d = 0;
    for(int i = 1; i <= N; i++)
    {
        num =i;
        d = i;
        while(d)
        {
            num += (d%10);
            d /= 10;
        }
        if(num == N)
        {
            cout << i << endl;
            return 0;
        }
            
    }
    cout << "0" << endl;
    
    return 0;
}
