#include <iostream>
#include<algorithm>
#include<cmath>

using namespace std;

int main() {
  
  int N;
  cin >> N;
  
  int val = 0;
  
  for(int i = 0; i < N; i++){
    int arr[7];
    
    int a,b,c;
    cin >> a >> b >> c;
    
    int money = 0;
    
    if(a== b && a == c){
        money = 10000 + a*1000;
    }
    else if(a == b){
        money = 1000 + 100 * a;
    }
    else if(b == c){
        money = 1000 + 100 * b;
    }
    else if(a == c){
        money = 1000 + 100 * a;
    }
    else{
        money = 100 * max(a,max(b,c));
    }
    
    
    if(val < money){
      val = money;
    }
    
    
  }
  
  cout << val;

  return 0;
}