#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin>>T;
	for(test_case = 1; test_case <= T; ++test_case)
	{
	    bool flag[10] = {false};
        int N = 0;
        int count = 0;
        cin >> N;
        int i = 1;
        while(true){
            
            int M = N * i;
            while(M != 0){
                if(flag[M%10] == false){
                    count++;
                    flag[M%10] = true;
                    M /= 10;
                }
                else{
                    M /= 10;
                }
            }
            if(count == 10){
                break;
            }else{
                i++;
            }
            
        }
        
        cout << "#" << test_case << " " << i*N << "\n";
	}
	return 0;
    
}