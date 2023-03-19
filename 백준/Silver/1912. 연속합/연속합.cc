#include<iostream>
#include<algorithm>
using namespace std;

int arr[100001];
int serious[100001];
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);cout.tie(0);
    
    int N;
    cin >> N;
    int temp = 0;
    int Max = 0;
    for(int i =0; i < N; i++)
    {
        cin >> temp;
        serious[i] = temp;
    }
    arr[0] = serious[0];
    Max = arr[0];
    for(int i =1; i < N; i++)
    {
        arr[i] = max(serious[i], arr[i - 1] + serious[i]);
        Max = max(arr[i], Max); 
    }
    cout << Max;
}