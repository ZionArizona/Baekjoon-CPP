#include<iostream>
#include<string>

using namespace std;

int main(){
    string str;
    cin >> str;

    int ans = 0;
    string str2;

    for(int i = 0; i < str.length(); i++){
        str2 += str[i];
        if(str2.find("dz=") != string::npos){
             if(str2.length() == 3){
                 ans++;
                 str2 = "";
             }
             else{
                 str2 = str2.substr(0,str2.length()-3);
                 ans += str2.length() + 1;
                 str2 = "";
             }
        }
        else if(str2.find("c=") != string::npos || str2.find("c-") != string::npos || str2.find("d-") != string::npos || str2.find("lj") != string::npos || str2.find("nj") != string::npos || str2.find("s=") != string::npos || str2.find("z=") != string::npos){
            if(str2.length() == 2 ){
                ans++;
                str2 = "";
            }
            else{
                str2 = str2.substr(0,str2.length()-2);
                ans += str2.length() +1;
                str2 = "";
            }
        }
        
    }
     ans += str2.length();
     cout << ans;
}