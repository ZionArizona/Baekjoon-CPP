#include<iostream>
using namespace std;


int main()
{
    int N;
    cin >> N;
    int x[N] = {};
    int y[N] = {};
    int count[N] = {};
    
    for(int i = 0; i < N; i++)
    {
        cin >> x[i] >> y[i];
    }
    for(int i = 0; i < N; i++)
    {
        int cnt = 1;
        for(int j = 0; j < N; j++)
        {
            if(x[i] < x[j] && y[i] < y[j])
            {
                cnt++;
            }
        }
        count[i] = cnt;
    }
    for(int i = 0; i < N; i++)
    {
        cout << count[i] << " ";
    }
    
    return 0;
}