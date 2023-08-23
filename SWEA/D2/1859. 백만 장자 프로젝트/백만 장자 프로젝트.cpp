#include<iostream>

using namespace std;
long long arr[1000005] = {0};

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;
    
	for(test_case = 1; test_case <= T; ++test_case)
	{
        int N = 0;
        cin >> N;
        int count = 0;
        
        long long save = 0;
        
        long long ans = 0;
        
        for(int i = 0; i < N; i++){
            cin >> arr[i];
        }
        
        int max = arr[N-1];
        
        for(int i = N-1; i >= 0; i--){
            if(max < arr[i]){
                max = arr[i];
                continue;
            }
            else{
                ans += max - arr[i];
            }
        }
		
		cout << "#" << test_case << " " << ans << "\n";

	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}
