
#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	
	int N = 0;
	cin >> N;
	
	for(int i = 1; i <= N; i++){
	    int count = 0;
	    if((i/100 == 3) || (i/100 == 6) || (i/100 == 9)) count++;
	    if((i%100)/10 == 3 || (i%100)/10 == 6 || (i%100)/10 ==9 ) count++;
	    if(i%10 == 3 || i%10 == 6 || i % 10 == 9) count++;
	    
	    if(count == 0){
	        cout << i << " ";
	    }
	    else if(count == 1){
	        cout << "- ";
	    }
	    else if(count == 2){
	        cout << "-- ";
	    }
	    else{
	        cout << "--- ";
	    }
	}
	
	
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}