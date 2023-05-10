#include <string>
#include <vector>
#include<cstdio>

using namespace std;

int solution(int a, int b) {
    int answer = 0;
    
    string A = to_string(a) + to_string(b);
    string B = to_string(b) + to_string(a);
    
    answer = stoi(A) > stoi(B) ? stoi(A): stoi(B);
    
    return answer;
}