#include <iostream>
#include<algorithm>
#include<vector>
using namespace std;

class findXY{
private:
    int x1, y1, x2, y2, x3, y3;
    int x4, y4;
    
public:
    findXY(int x1, int y1, int x2, int y2, int x3, int y3)
    {
        this->x1 = x1;
        this->y1 = y1;
        this->x2 = x2;
        this->y2 = y2;
        this->x3 = x3;
        this->y3 = y3;
    }
    
    void findX4Y4();
    
    void show();
};

void findXY:: findX4Y4()
{
    if(x1 == x2)
    {
        this->x4 = x3;
    }
    else
    {
        if(x1 == x3) this->x4 = x2;
        else this->x4 = x1;
    }
    
    if(y1 == y2)
    {
        this->y4 = y3;
    }
    else
    {
        if(y1 == y3) this->y4 = y2;
        else this->y4 = y1;
    }
    
}

void findXY:: show()
{
    cout << x4 << " " << y4;
}


int main()
{
    int x1, y1, x2, y2, x3, y3;
    cin >> x1 >> y1 >> x2 >> y2 >> x3 >> y3;
    
    findXY XY(x1, y1, x2, y2, x3, y3);
    
    XY.findX4Y4();
    
    XY.show();
    
    return 0;
}