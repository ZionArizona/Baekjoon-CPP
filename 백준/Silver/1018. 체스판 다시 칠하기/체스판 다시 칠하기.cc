#include<iostream>
using namespace std;


char str[50][50];


int main()
{
    
    ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

    int n = 0;
    int m = 0; 
    cin >> n >> m;
    int ans = 1250000;    
    

  
    for(int i = 0; i < n; i++)
    {
        for(int j = 0; j < m; j++)
        {
            cin >> str[i][j];
        }
    }

    
    for(int i = 0; i <= n- 8; i++)
    {
        for(int j = 0 ; j <= m-8; j++)
        {
            int cntW = 0, cntB = 0;    
            for(int k = i; k < 8 + i; k++)
            {
                
                for(int p = j; p < 8 + j; p++)
                {
                    if((k+p)%2 == 0)
                    {
                       (str[k][p] == 'B')? cntW++:cntB++; 
                    }
                    else
                    {
                        (str[k][p] == 'B')? cntB++:cntW++; 
                    }
                }
            }
            ans = (ans > cntW) ? cntW : ans;
			ans = (ans > cntB) ? cntB : ans;

        }
    }
    
    
    cout << ans;
    
    

    return 0;
}