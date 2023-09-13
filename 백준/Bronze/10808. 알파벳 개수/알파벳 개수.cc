#include <bits/stdc++.h>

using namespace std;

int arr[123] = {0};

int main()
{

    ios::sync_with_stdio(0);
    cout.tie(0);
    cin.tie(0);
    
    string str = "";
    cin >> str;
    
    for(int i = 0; i < str.length(); i++){
        arr[str[i]]++;
    }
    
    for(int i = 97; i < 123; i++){
        cout << arr[i] << " ";
    }
    
    
    return 0;
}