
#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	
	cin>>T;
	for(test_case = 1; test_case <= T; ++test_case)
	{
        cout << "#" << test_case << "\n";
        int N = 0;
        cin >> N;
        
        int a1 = 0;
int a2 = 0; int a3 = 0; int a4 =0; int a5 = 0; int a6 = 0; int a7=0; int a8=0;
        
        a1 = N/50000;
        a2 = (N%50000)/10000;
        a3 = (N%10000)/5000;
        a4 = (N%5000)/1000;
        a5 = (N%1000)/500;
        a6 = (N%500)/100;
        a7 = (N%100)/50;
        a8 = (N%50)/10;

        cout << a1 << " " << a2 << " " << a3 << " " << a4 << " " << a5 << " " << a6 << " " << a7 << " " << a8 << "\n";
	}
	return 0;
}