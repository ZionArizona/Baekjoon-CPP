#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr, vector<int> query) {
    vector<int> answer;
    string str;
    for(int i = 0; i < arr.size(); i++){
        str += arr[i];
    }
    
    for(int i = 0 ; i < query.size(); i++){
        if(i % 2 == 0){
            str = str.substr(0, query[i]+1);
        }
        else{
            str = str.substr(query[i],query[i]+100000);
        }
    }
    
    for(int i = 0 ; i < str.length(); i++){
        answer.push_back(str[i]);
    }
    
    return answer;
}