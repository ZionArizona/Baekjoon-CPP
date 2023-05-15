#include <string>
#include <vector>

using namespace std;

string solution(string my_string, vector<vector<int>> queries) {
    string answer = "";
    answer = my_string;
    for(int i = 0; i < queries.size(); i++){
        char temp;
        for(int j = 0; j < (queries[i][1] - queries[i][0]+1)/2; j++){
            temp = answer[queries[i][0] + j];
            answer[queries[i][0]+j] = answer[(queries[i][1] - j)];
            answer[queries[i][1] - j] = temp;
        }
    }
    return answer;
}