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
        int a = 0, b = 0 , c =0 , d = 0, e = 0;
        
        
        while(N!=1){
            if(N %2 == 0){
                a++;
                N /= 2;
            }
            else if(N % 3 == 0){
                b++;
                N /=3;
            }
            else if(N % 5 == 0){
                c++;
                N /= 5;
            }
            else if(N % 7 == 0){
                d++;
                N /= 7;
            }
            else if(N % 11 == 0){
                e++;
                N /= 11;
            }
        }
        
        cout << "#" << test_case << " " << a << " " << b << " " << c << " " << d << " " << e << "\n";
        
	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}