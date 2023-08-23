#include<iostream>

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
        
        int count = 0;
        
        for(int i = -N; i <= N; i++){
            for(int j = - N; j <= N; j++){
                if(i*i + j*j <= N*N){
                    count++;
                }
            }
        }
    
        cout << "#" << test_case << " " << count << "\n";

	}
	return 0;
}