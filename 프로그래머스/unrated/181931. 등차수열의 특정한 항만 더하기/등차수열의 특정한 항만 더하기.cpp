#include <string>
#include <vector>

using namespace std;

int solution(int a, int d, vector<bool> included) {
    int answer = 0;
    vector<int> vec;
    vec.push_back(a);
    for(int i = 1; i < included.size(); i++){
        vec.push_back(a+d);
    }
        
    for(int i = 0; i < included.size(); i++){
        if(included[i] == true){
            answer += vec[i];
        }
    }
    return answer;
}