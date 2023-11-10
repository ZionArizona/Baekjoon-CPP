#include <iostream>
#include<algorithm>
using namespace std;

int GCD(int a, int b){
  int lcd = 0;
  while(a != 0){
    lcd = b % a;
    b = a;
    a = lcd;
  }
  
  return b;
}

int main() {
  
  int N;
  cin >> N;
  
  int arr[100005] = {0};
  int Marr[100005] = {0};
  
  
  for(int i = 0; i < N; i++){
    cin >> arr[i];
  }
  
  //sort(arr, arr+N);
  
  for(int i = 0; i < N- 1; i++){
    Marr[i] = arr[i+1] - arr[i];
  }
  
  int gcd = Marr[0];
  
  for(int i = 1; i < N-1; i++){
    gcd = GCD(gcd, Marr[i]);
  }
  
  
  int count = 0;
  
  for(int i = 0; i < N - 1; i++){
    count += (Marr[i]/gcd - 1);
  }
  
  cout << count;
  
  return 0;
}