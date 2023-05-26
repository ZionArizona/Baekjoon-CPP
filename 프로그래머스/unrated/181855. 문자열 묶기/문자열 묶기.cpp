#include <string>
#include <vector>

using namespace std;

int solution(vector<string> strArr) {
    vector<int> len(31,0);
    int answer = 0;
    
    for(int i = 0; i < strArr.size(); i++){
        len[strArr[i].length()]++;
    }
    answer = len[0];
    for(int i = 1 ; i< len.size(); i++){
        if(answer <= len[i]){
            answer = len[i];
        }
    }
    
    
    return answer;
}