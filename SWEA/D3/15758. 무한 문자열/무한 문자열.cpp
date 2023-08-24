#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin>>T;
	
	string ans[T+1];
	
	for(int i = 1; i <=T; i++){
	    ans[i] = "yes";
	}
	
	
	for(test_case = 1; test_case <= T; ++test_case)
	{
        string s;
        string t;
        cin >> s >> t;
        string sAns = s;
        string tAns = t;
        int inNum = s.size() * t.size();
        if(s.length() == t.length()){
            for(int i = 0; i < s.length(); i++){
                if(s[i] != t[i]){
                    ans[test_case] = "no";
                    break;
                }
            }
        }
        else{
            for(int i = t.size(); i < inNum; i += t.size()){
                tAns += t;
            }
            for(int i = s.size(); i < inNum; i += s.size()){
                sAns += s;
            }
            
            for(int i = 0; i < tAns.size(); i++){
                if(tAns[i] != sAns[i]){
                    ans[test_case] = "no";
                }
            }
            
        }
	}
	
	for(int i = 1; i <= T; i++){
	    cout << "#" << i << " " << ans[i] << "\n";
	}
	
	
	return 0;
}