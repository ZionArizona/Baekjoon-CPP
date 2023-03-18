#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    vector<int> vec;
    int N;
    cin >> N;
    int temp = 0;
    int T = 0;

    for (int i = 0; i < N; i++)
    {
        cin >> temp;
        vec.push_back(temp);
    }
    sort(vec.begin(), vec.end());
    T = vec[0] * vec[N - 1];
    cout << T;
}