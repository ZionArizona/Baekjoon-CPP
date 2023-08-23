#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin>>T;
	
	string test[T+1];
	
	for(int i = 1; i <= T; i++){
	    test[i] = "Yes";
	}
	
	
	
	for(test_case = 1; test_case <= T; ++test_case)
	{
        int N = 0;
        cin >> N;
        
        string str = "";
        cin >> str;
        
        if(N%2 != 0){
            test[test_case] = "No";
        }    
        else{
            for(int i = 0; i < str.length()/2; i++){
                if(str[i] == str[i+(str.length()/2)]){
                    continue;
                }
                else{
                    test[test_case] = "No";
                    break;
                }
            }
        }
        
    }
    
    for(int i = 1; i <= T; i++){
        cout << "#" << i << " " << test[i] << "\n";
    }
	
	return 0;
}