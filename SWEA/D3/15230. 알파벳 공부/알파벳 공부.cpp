#include<iostream>

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
                
        int count = 0;
        
        int num = 97;
        
        for(int i = 0; i < str.length(); i++){
            if(str[i] == num){
                count++;
            }
            else{
                break;
            }
            num++;
        }
        
    
        cout << "#" << test_case << " " << count << "\n";

	}
	return 0;
}