#include<iostream>
using namespace std;


int main()
{
    int N;
    int M;
    cin >> N >> M;
    int arr[N] = {0};
    int max = 0;
    int temp = 0;
    for(int i = 0; i < N ; i++)
    {
        cin >> arr[i];
    }
    
    for(int i = 0; i < N -2 ; i++)
    {
        for(int j = i + 1; j < N -1 ; j++)
        {
            for(int k = j + 1; k < N; k++)
            {
                temp = arr[i] + arr[j] + arr[k];
                if(temp <= M && temp > max)
                {
                    max = temp;
                }
            }
        }
    }
    cout << max << endl;
    
}
