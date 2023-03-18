#include<iostream>
using namespace std;

int main()
{
    int n;
    cin >> n;
    int x = 0,y = 0;
    int arr[100][100] = {0};
    int count = 0;
    while(n--)
    {
        cin >> x >> y;
        for(int i = x; i < x + 10; i++)
        {
            for(int j = y; j < y + 10; j++)
            {
                if(arr[j][i] == 0)
                {
                    arr[j][i] = 1;
                    count++;
                }
            }
        }
    }
    cout << count;
}