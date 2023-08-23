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
        
    
        cout << "#" << test_case << " " << N*N << "\n";

	}
	return 0;
}