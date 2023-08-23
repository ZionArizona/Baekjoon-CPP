#include<iostream>
#include<cmath>
using namespace std;
 
int main(int argc, char** argv)
{
    int test_case;
    int T;
    cin>>T;
    for(test_case = 1; test_case <= T; ++test_case)
    {
        int N = 0;
        cin >> N;
        bool flag = true;
         
        int y = 0;
        int x = 0;
         
        int count = 0;
        int i = 2;
         
        while(flag){
            y = i;
            x= N+y;
            for(int j = 2; j < sqrt(x); j++){
                if(x%j == 0){
                    count++;
                    break;
                }
            }
             
            for(int j = 2; j < sqrt(y); j++){
                if(y%j == 0){
                    count++;
                    break;
                }
            }
             
            if(count == 2){
                flag = false;
            }
            else{
                i++;
                count = 0;
            }
             
        }
         
        cout << "#" << test_case << " " << x << " " << y << "\n";
    }
    return 0;
}