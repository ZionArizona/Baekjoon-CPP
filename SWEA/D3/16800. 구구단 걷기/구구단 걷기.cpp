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
        long long N = 0;
        cin >> N;
        
        long long path = N-1;
        for(int i = 2; i <= sqrt(N); i++){
            if(N%i == 0){
                if(path > i + (N/i) - 2){
                    path = i + (N/i) - 2;
                }
            }
        }
        
        cout << "#" << test_case << " " << path << "\n";
        
	}
	return 0;
}
