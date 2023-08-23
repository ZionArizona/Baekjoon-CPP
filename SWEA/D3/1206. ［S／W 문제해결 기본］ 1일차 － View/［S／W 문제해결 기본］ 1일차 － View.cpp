#include<iostream>
#include<algorithm>

using namespace std;

int main(int argc, char** argv)
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    
	int test_case;
	int T = 10;
	
	
	for(test_case = 1; test_case <= T; ++test_case)
	{
	    int N = 0;
	    cin >> N;
	    
        int arr[1001] = {0};
        long long ans = 0;
        
        for(int i = 0; i < N; i++){
            cin >> arr[i];
        }
        
        if(N == 4) {
            cout << "#" << test_case << " 0" << "\n";
            continue;
        }
        else if(N == 5) {
            cout << "#" << test_case << " " << arr[2] << "\n";
            continue;
        }

        for(int i =2; i < N - 2; i++){
            if(((arr[i] - arr[i-2]) > 0 )&&( (arr[i] - arr[i-1]) > 0) && ((arr[i] - arr[i+1]) > 0) && ((arr[i] - arr[i+2]) > 0)){
                ans += min(min((arr[i] - arr[i-2]), (arr[i] - arr[i-1])), min((arr[i] - arr[i+1]), (arr[i] - arr[i+2])));
            }
        }
        cout << "#" << test_case << " " << ans << "\n";
	}
	return 0;
}
