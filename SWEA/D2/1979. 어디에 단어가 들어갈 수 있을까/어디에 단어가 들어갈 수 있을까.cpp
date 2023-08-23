#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
    ios::sync_with_stdio;
    cin.tie(0);
    cout.tie(0);
	int test_case;
	int T;
	
	cin>>T;
	
	for(test_case = 1; test_case <= T; ++test_case)
	{
        int N =0;
        int K =0;
        cin >> N >> K;
        int arr[N][N] = {0};
        
        for(int i = 0; i < N; i++){
            for(int j = 0 ; j < N; j++){
                cin >> arr[i][j];
            }
        }
        
        int count = 0;
        int ans = 0;
        
        for(int i = 0; i < N; i++){
            for(int j = 0 ; j < N; j++){
                if(arr[i][j] == 0){
                    if(count == 0){
                        continue;
                    }
                    else{
                        if(count == K){
                            ans++;
                            count = 0;
                            continue;
                        }
                        else{
                            count = 0;
                            continue;
                        }
                    }
                }
                else{
                    count++;
                }
            }
            if(count == K){
                ans++;
            }
            count = 0;
        }
        
        
        for(int i = 0; i < N; i++){
            for(int j = 0 ; j < N; j++){
                if(arr[j][i] == 0){
                    if(count == 0){
                        continue;
                    }
                    else{
                        if(count == K){
                            ans++;
                            count = 0;
                            continue;
                        }
                        else{
                            count = 0;
                            continue;
                        }
                    }
                }
                else{
                    count++;
                }
            }
            if(count == K){
                ans++;
            }
            count = 0;
        }
        
        
        
        
        
        cout << "#" << test_case << " " << ans << "\n";
		
	}
	return 0;
}