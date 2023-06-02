#include <string>
#include <vector>

using namespace std;

string solution(string my_string, int s, int e) {
    string answer = "";
    
    int temp = 0;
    
    for(int i = 0 ; i < (e-s+1)/2; i++){
        temp = my_string[s+i];
        my_string[ s + i] = my_string[ e - i];
        my_string[e - i] = temp;
    }
    
    
    return my_string;
}