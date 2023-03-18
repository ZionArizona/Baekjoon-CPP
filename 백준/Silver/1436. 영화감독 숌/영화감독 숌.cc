#include<iostream>
#include<string>

using namespace std;

int showserious(int n)
{
    int i = 666; //제목 이름, i는 첫번째(1번) 시리즈 제목
    int serious = 0;
    string make; //i를 문자열로 만들어 저장하는 변수
    
    
    while(1)
    {    
        make = to_string(i);
        for(int a = 0; a < make.length()-2; a++)
        {
            if(make[a] == '6' && make[a+1] =='6' && make[a+2] == '6')
            {
                serious++;
                if(serious == n)
                    return i;
                break;
            }
        }
        i++;
    }
    
}

int main()
{
    int n;
    cin >> n;
    cout << showserious(n);
}