#include <iostream>
#include<algorithm>
using namespace std;

int main()
{
    int x,y,w,h;
    cin >> x >> y >> w >> h;
    
    int arr[4] = {};
    
    arr[0] = x;
    arr[1] = w -x;
    arr[2] = y;
    arr[3] = h -y;
    
    sort(arr, arr+4);
    
    cout << arr[0];

    return 0;
}
