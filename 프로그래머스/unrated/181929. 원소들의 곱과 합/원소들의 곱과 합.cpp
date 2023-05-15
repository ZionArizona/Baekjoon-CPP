#include <string>
#include <vector>

using namespace std;

int solution(vector<int> num_list) {
    int answer = 0;
    int mul = 1;
    int sq = 0;
    for(int i = 0; i < num_list.size(); i++){
        mul *= num_list[i];
        sq += num_list[i];
    }
    
    if(mul < sq*sq){
        return 1;
    }
    else{
        return 0;
    }
    
    return answer;
}