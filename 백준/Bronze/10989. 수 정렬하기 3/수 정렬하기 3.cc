#include <iostream>

using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);cout.tie(0);
    int N = 0;
    cin >> N;
    int arr[10001] = {0};
    
    int temp = 0;
    for(int i =0 ; i < N; i++)
    {
        cin >> temp;
        arr[temp]++;
    }
    
    for(int i = 1; i < 10001; i++)
    {
        if(arr[i] != 0)
        {
            for(int j = 0 ; j < arr[i]; j++)
            {
                cout << i << "\n";
            }
        }
    }
    

    return 0;
}