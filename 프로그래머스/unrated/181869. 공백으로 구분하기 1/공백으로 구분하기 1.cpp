#include <string>
#include <vector>

using namespace std;

vector<string> solution(string my_string) {
    vector<string> answer;
    vector<int> index;
    string str;
    for(int i = 0 ; i< my_string.size(); i++){
        
        if(my_string[i] == ' '){
            answer.push_back(str);
            str = "";
        }else{
            str += my_string[i];
        }
        
    }
    
    answer.push_back(str);
    
    
    return answer;
}