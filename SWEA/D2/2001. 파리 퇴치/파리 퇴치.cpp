#include<iostream>
#include<string>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	
	cin>>T;

	for(test_case = 1; test_case <= T; ++test_case)
	{
        int N = 0;
        int M = 0;
        cin >> N >> M;
        
        int arr[15][15] = {0};
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                cin >> arr[i][j];
            }
        }
        
        int max = 0;
        int tmp = 0;
        
        for(int i = 0; i < N-M +1; i++){
            for(int j = 0; j < N-M + 1; j++){
                tmp = 0;
                for(int k = i; k < i+M; k++){
                    for(int l = j; l < j + M; l++){
                        tmp += arr[k][l];
                    }
                }
                if(tmp > max){
                    max = tmp;
                   
                }
            }
        }
        
        
        
        cout << "#" <<test_case << " " << max << "\n";
        
        
	}
	return 0;
}