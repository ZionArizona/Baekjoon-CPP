#include<iostream>

using namespace std;

int main(int argc, char** argv)
{

	int test_case;
	int T;
	cin>>T;
	for(test_case = 1; test_case <= T; ++test_case)
	{
        
        int P = 0, Q = 0, R = 0, S = 0, W = 0;
        
        cin >> P >> Q >> R >> S >> W;
        int Bmoney = W <= R ? Q : Q + (W-R)*S;
        
        int money = P*W < Bmoney ? P * W : Bmoney;
        
        
        cout << "#" << test_case << " " << money << "\n";
	}
	return 0;
}