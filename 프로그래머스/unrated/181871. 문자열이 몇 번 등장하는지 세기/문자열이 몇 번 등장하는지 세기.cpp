#include <string>
#include <vector>

using namespace std;

int solution(string myString, string pat) {
    
    int answer = 0;
    
    int index = 0;
    
    while(true){
        int index = myString.find(pat,index);
        if(index != string::npos){
            answer++;
            index++;
        }
        else{
            break;
        }
    }
    
    return answer;
}