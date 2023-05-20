#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr, vector<vector<int>> queries) {
    vector<int> answer;
    for(int i = 0; i < queries.size(); i++){
        int m = queries[i][2];
        for(int j = queries[i][0]; j <= queries[i][1]; j++){
            if(j%m == 0){
                arr[j]++;
            }
        }
    }
    return arr;
}