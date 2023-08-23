#include<iostream>
using namespace std;
 
int main(int argc, char** argv)
{
    int test_case;
    int T;
    cin>>T;
     
    string test[T + 1] = {"yes"};
     
    for(int i = 1; i <= T; i++){
        test[i] = "yes";
    }
     
    for(test_case = 1; test_case <= T; ++test_case)
    {
        int p = 0; 
        int q = 0;
        cin >> p >> q;
         
        int arr[p][q] = {0};
        int a[p] = {0};
        int b[q] = {0};
         
        for(int i = 0; i < p; i++){
            string str = "";
            cin >> str;
            for(int j = 0; j < q; j++){
                arr[i][j] = str[j] - '0';
            }
        }
 
        for(int i = 0; i <q; i++){
            if(arr[0][i] == 0) b[i] = 0;
            else b[i] = 1;
        }
         
        for(int i = 1; i < p; i++){
            if(arr[i][0] == 0){
                if(b[0] == 0) a[i] = 0;
                else a[i] = 1;
            }
            else{
                if(b[0] == 0) a[i] = 1;
                else a[i] = 0;
            }
        }
         
        for(int i = 1; i < p; i++){
            for(int j = 1; j < q; j++){
                if(arr[i][j] != a[i]^b[j]){
                    test[test_case] = "no";
                }
            }
        }
        
         
    }
     
     
    for(int i = 1; i <= T; i++){
        cout << "#" << i << " " << test[i] << "\n";
    }
     
    return 0;
}