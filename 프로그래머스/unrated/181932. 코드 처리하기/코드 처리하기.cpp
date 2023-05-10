#include <string>
#include <vector>

using namespace std;

string solution(string code) {
    string answer = "";
    string ret = "";
    int mode = 0;
    
    for(int idx = 0; idx < code.length(); idx++){
        if(mode == 0){
            if(code[idx] != '1')
            {
                if(idx % 2 == 0){
                    ret += code[idx];
                }
            }
            else{
                mode = 1;
            }
            
        }
        else{
            if(code[idx] != '1' ){
                if(idx %2 != 0){
                    ret += code[idx];
                }
            }
            else{
                mode = 0;
            }
        }
    }
    answer = ret;
    if(answer == ""){
        answer = "EMPTY";
    }
    return answer;
}