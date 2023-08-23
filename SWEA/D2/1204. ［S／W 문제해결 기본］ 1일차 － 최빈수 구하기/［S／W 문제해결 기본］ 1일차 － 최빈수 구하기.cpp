#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin>>T;
	for(test_case = 1; test_case <= T; ++test_case)
	{
        int test_Num = 0;
        cin >> test_Num;
        
        int arr[101] ={0};
        
        for(int i = 0; i < 1000; i++){
            int tmp = 0;
            cin >> tmp;
            arr[tmp]++;
        }
        
        int index = 0;
        
        
        for(int i = 0; i < 100; i++){
            if(arr[index] <= arr[i] && index < i ){
                index = i;
            }
        }    
        cout << "#" << test_case << " " << index << "\n";
        }
	return 0;
}