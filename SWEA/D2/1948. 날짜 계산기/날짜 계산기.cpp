#include<iostream>
#include<cmath>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	
	int T;
	
	cin>>T;
	
	for(test_case = 1; test_case <= T; ++test_case)
	{
	   int mon1 = 0;
	   int day1 = 0;
	   int mon2 = 0;
	   int day2 = 0;
	   
	   cin >> mon1 >> day1 >> mon2 >> day2;
	   
	   int arr[12] = {31,28,31,30,31,30,31,31,30,31,30,31};
	   
	   if(mon1 == mon2){
	       cout << "#" << test_case << " " << (day2 - day1 +1) << "\n";
	       
	   }
	   else if(mon2 - mon1 > 1){
	       int ans = 0;
	       for(int i = mon1; i < mon2 - 1; i++){
	           ans += arr[i];
	       }
	       cout << "#" << test_case << " " << (arr[mon1-1] - day1 +1) + day2 + ans << "\n";
	   }
	   else{
	       int ans = 0;
	       cout << "#" << test_case << " " << (arr[mon1-1] -day1 +1) + day2 << "\n";
	   }
       

	}
	
	return 0;
}