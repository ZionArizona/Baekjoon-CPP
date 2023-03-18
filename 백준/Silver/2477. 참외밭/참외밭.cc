#include <iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main()
{
    vector<int> dir;
    vector<int> len;
    int count = 0;
    cin >> count;
    //sort(vec1.begin(), vec1.end(), greater<int>());
    int west =0;
    int east =0;
    int north = 0;
    int south = 0;
    
    int temp_dir = 0;
    int temp_len = 0;
    for(int i =0 ; i< 6; i++)
    {
        cin >> temp_dir >> temp_len;
        if(temp_dir == 1) east++;
        if(temp_dir == 2) west++;
        if(temp_dir == 3) south++;
        if(temp_dir == 4) north++;
        
        dir.push_back(temp_dir);
        len.push_back(temp_len);
    }
    
  
    
    int index =0;
    int index1 = 0;
    if(east == 2 && west == 1 && south == 2 && north == 1)
    {
        index = find(dir.begin(), dir.end(), 2) - dir.begin();
        index1 = find(dir.begin(), dir.end(), 4) - dir.begin();
    }
    else if(east == 2 && west == 1 && south == 1 && north == 2 )
    {
        index = find(dir.begin(), dir.end(), 3) - dir.begin();
        index1 = find(dir.begin(), dir.end(), 2) - dir.begin();
    }
    else if(east == 1 && west == 2 && south == 1 && north == 2)
    {
        index = find(dir.begin(), dir.end(), 1) - dir.begin();
        index1 = find(dir.begin(),dir.end(), 3) - dir.begin();
    }
    else
    {
        index = find(dir.begin(), dir.end(), 4) - dir.begin();
        index1 = find(dir.begin(), dir.end(), 1) - dir.begin();
    }
    
    int out_width = len[index];
    int out_height = len[index1];
    
    int in_width = len[(index+2)%6];
    int in_height = len[(index+3)%6];

    
    cout << count * ((out_width * out_height) - (in_width * in_height));

    return 0;
}
