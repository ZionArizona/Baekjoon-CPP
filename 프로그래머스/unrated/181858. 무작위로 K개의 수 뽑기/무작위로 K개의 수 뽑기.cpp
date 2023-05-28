#include <string>
#include <vector>
#include<algorithm>

using namespace std;

vector<int> solution(vector<int> arr, int k) {
    vector<int> answer;
    int key = k;
    vector<int> mem(100001, 0); 
    
    
    for(int i = 0 ; i < arr.size(); i++){
       
        if(key == 0)
            break;
        
        if(mem[arr[i]] == 0){
            key--;
            mem[arr[i]]++;
            answer.push_back(arr[i]);
        }
        else if(mem[arr[i]] == 1){
            continue;
        }
    }
    
    if(key != 0){
        for(int i = 0; i < key ; i++){
            answer.push_back(-1);
        }
    }
    
    return answer;
}