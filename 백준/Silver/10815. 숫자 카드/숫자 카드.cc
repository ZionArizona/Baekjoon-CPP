#include<iostream>
#include<algorithm>
using namespace std;


int binarysearch(int n, int arr1[], int k) //배열 arr1에 k값이 있는지 없는지를 검사해야한다.(이진탐색 이용)
{
    int low = 0;
    int high = n -1;
    
    
    while(low <= high)
    {
        int mid = (low + high)/2;
        
        if(k == arr1[mid])
        {
            cout << "1 ";
            return 0;
        }
        else
        {
            if(k > arr1[mid])
            {
                low = mid + 1;
            }
            else
            {
                high = mid -1;
            }
        }
        
        
    }
    cout << "0 ";
    return 0;
}


int main()
{
    int n =0;
    cin >> n;
    int *arr1 = new int[n];
    
    for(int i = 0; i < n; i++)
    {
        cin >> arr1[i];
    }
    int m;
    cin >> m;
    
    int arr2[m] = {};
    for(int i = 0; i < m; i++)
    {
        cin >> arr2[i];
    }
    sort(arr1, arr1+n);
    
    
    
    for(int i = 0; i < m; i++)
    {
        binarysearch(n, arr1, arr2[i]);
    }
    delete[] arr1;

}