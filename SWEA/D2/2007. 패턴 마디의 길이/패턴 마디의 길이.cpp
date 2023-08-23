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
        string str = "";
        cin >> str;
        
        string tmp = "";
        tmp = str[0];
        
        for(int i = 1; i <= 10; i++){
            if(tmp != str.substr(tmp.size(),i)){
                tmp += str[i];
            }
            else{
                break;
            }
        }
		cout << "#" << test_case << " " << tmp.size() << "\n";
	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}