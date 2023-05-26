#include <string>
#include <vector>

using namespace std;

vector<string> solution(string my_string) {
    vector<string> answer;
    string str;
    for(int i = 0 ; i< my_string.length(); i++){   
        
        if(my_string[i] == ' ' && str == ""){
            continue;
        }
        else if(my_string[i] == ' ' && str != ""){
            
            answer.push_back(str);
            str = "";
            continue;
        }
        else if(i == (my_string.size() -1) && my_string[i] == ' '){
           answer.push_back(str);
            return answer;
        }
        else if(i == (my_string.size() - 1) && my_string[i] != ' '){
            str += my_string[i];
            answer.push_back(str);
            return answer;
        }
        
        
        str += my_string[i];
    }
    return answer;
}