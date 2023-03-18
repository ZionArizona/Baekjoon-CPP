#include <iostream>
using namespace std;

int main()
{
    int n;
    int m;
    cin >> n >> m;
    
    int A[n][m] = {{0}};
    int B[n][m] = {{0}};
    
    for(int i =0; i < n ; i++)
    {
        for(int j = 0; j < m ; j++)
        {
            cin >> A[i][j];
        }
    }
    for(int i =0; i < n; i++)
    {
        for(int j = 0; j < m ;j++)
        {
            cin >> B[i][j];
        }
    }
    
    for(int i = 0; i < n; i++)
    {
        for(int j = 0; j < m; j++)
        {
            cout << A[i][j] + B[i][j] << " ";
        }
        cout << endl;
    }
    

    return 0;
}
