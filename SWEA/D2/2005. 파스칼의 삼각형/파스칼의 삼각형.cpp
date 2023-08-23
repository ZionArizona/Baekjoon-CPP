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
        cin >> N;
        
        cout << "#" << test_case << "\n";
        
        int arr[N+1][11] = {0};
        for(int i = 0; i < N; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    arr[i][j] = 1;
                    cout << arr[i][j] << " ";
                }
                else{
                    arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                    cout << arr[i][j] << " ";
                }
            }
            cout << "\n";
        }
        
	}
	return 0;
}