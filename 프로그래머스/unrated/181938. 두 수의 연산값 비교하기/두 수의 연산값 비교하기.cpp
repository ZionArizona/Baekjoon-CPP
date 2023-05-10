#include <string>
#include <vector>

using namespace std;

int solution(int a, int b) {
    int answer = 0;
    string A = to_string(a)+to_string(b);
    
    answer = stoi(A) > (2*a*b) ? stoi(A): 2*a*b;
    
    return answer;
}