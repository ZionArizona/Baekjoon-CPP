#include <string>
#include <vector>

using namespace std;

string solution(string myString, string pat) {
    string answer = "";
    int n = myString.rfind(pat);
    answer = myString.substr(0,n+pat.length());
    
    
    return answer;
}