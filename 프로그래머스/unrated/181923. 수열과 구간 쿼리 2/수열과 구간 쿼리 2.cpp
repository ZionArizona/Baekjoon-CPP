#include <string>
#include <vector>
#include<algorithm>

using namespace std;

vector<int> solution(vector<int> arr, vector<vector<int>> queries) {
    vector<int> answer;
    for(int i = 0; i < queries.size(); i++){
        int Max = queries[i][2];
        vector<int> an;
        bool flag = false;
        for(int j = queries[i][0] ; j <= queries[i][1] ; j++){
            if(arr[j] > Max){
                flag = true;
                an.push_back(arr[j]);
            }
        }
        if(flag == true){
            sort(an.begin(), an.end());
            answer.push_back(an[0]);
        }
        else{
            answer.push_back(-1);
        }
    }
    return answer;
}