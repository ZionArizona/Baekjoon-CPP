#include <string>
#include <vector>

using namespace std;

vector<int> solution(int l, int r) {
    vector<int> answer;
    for(int i = l; i <= r; i++){
        string temp = to_string(i);
        bool f = false;
        for(int j = 0; j < temp.length();j++){
            if(temp[j] != '5' && temp[j] != '0'){
                f = true;
                break;
            }
        }
        if(f == false){
            
            answer.push_back(stoi(temp));
        }
    }
    if(answer.size() == 0){
        answer.push_back(-1);
    }
    
    return answer;
}