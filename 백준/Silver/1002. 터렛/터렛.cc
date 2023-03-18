#include <iostream>
#include<algorithm>
#include<cmath>

using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);cout.tie(0);
    int T;
    cin >> T;
    int x1,y1,r1,x2,y2,r2;
   
    for(int i =0; i < T; i++)
    {
        
        cin >> x1 >> y1 >> r1 >> x2 >> y2 >>r2;    
        double d = sqrt((x1-x2)*(x1-x2) + (y1 - y2)*(y1-y2));
        if(d == 0 && r1 == r2)
        {
            cout << "-1" << "\n";
        }
        else if(d == (r1 + r2) || d*d == ((r1-r2)*(r1-r2))) 
        {
            cout << "1" << "\n";
        }
        else if(d  > (r1 + r2) || d*d < (r1 - r2) * (r1 - r2))
        {
            cout << "0" << "\n";
        }
        else if(d < r1 + r2)
        {
            cout << "2" << "\n";
        }
        
        
    }

    return 0;
}