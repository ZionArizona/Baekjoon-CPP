#include <iostream>
#include <map>
using namespace std;
 
int main(){
    
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    map<string, string, greater<string>> m;
    int n; cin >> n;
    for(int i = 0; i<n; i++){
        string name, EorL;
        
        cin >> name >> EorL;
        m[name] = EorL;
        
    }
    
    
    for(auto it: m){
        if(it.second == "enter"){
            cout << it.first << "\n";
        }
    }
    
    
    
    return 0;
}