#include <string>
#include <vector>

using namespace std;

vector<int> solution(string myString) {
    vector<int> answer;
    int idx = myString.find("x");
    
    while(idx != -1){
        answer.push_back(idx);
        myString = myString.substr(idx+1);
        idx = myString.find("x");
    }
    
    answer.push_back(myString.size());
    
    return answer;
}