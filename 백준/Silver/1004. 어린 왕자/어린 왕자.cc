#include<iostream>
using namespace std;
bool inCir(int x1,int y1, int x2,int y2, int Cx, int Cy, int r)
{
	if ((Cx - x1) * (Cx - x1) + (Cy - y1) * (Cy - y1) < r * r && (Cx - x2) * (Cx - x2) + (Cy - y2) * (Cy - y2) > r * r) return true;
	else if ((Cx - x1) * (Cx - x1) + (Cy - y1) * (Cy - y1) > r * r && (Cx - x2) * (Cx - x2) + (Cy - y2) * (Cy - y2) < r * r) return true;
	else if ((Cx - x1) * (Cx - x1) + (Cy - y1) * (Cy - y1) < r * r && (Cx - x2) * (Cx - x2) + (Cy - y2) * (Cy - y2) < r * r) return false;
	else if ((Cx - x1) * (Cx - x1) + (Cy - y1) * (Cy - y1) > r * r && (Cx - x2) * (Cx - x2) + (Cy - y2) * (Cy - y2) > r * r) return false;
	
}



int main()
{
	int T;
	cin >> T;
	int x1, y1, x2, y2;
	int Cx, Cy, r;
	for (int i = 0; i < T; i++)
	{
		int count = 0;
		cin >> x1 >> y1 >> x2 >> y2;
		int n;
		cin >> n;
		for (int i = 0; i < n; i++)
		{
			cin >> Cx >> Cy >> r;
			if (inCir(x1, y1, x2, y2, Cx, Cy, r) == true) count++;
		}
		cout << count << endl;
	}
	

}
