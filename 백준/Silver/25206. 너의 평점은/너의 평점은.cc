#include<iostream>
#include<string>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
	
	string str1 = "";
	double gpa = 0;
	string str2 = "";

	double sum = 0;
	double sumgpa = 0;

	double score[20] = { 0 };


	for (int i = 0; i < 20; i++) {
		cin >> str1 >> gpa >> str2;
		if (str2 == "A+") score[i] = 4.5;
		else if (str2 == "A0") score[i] = 4.0;
		else if(str2 == "B+") score[i] = 3.5;
		else if(str2 == "B0") score[i] = 3.0;
		else if(str2 == "C+") score[i] = 2.5;
		else if(str2 == "C0") score[i] = 2.0;
		else if(str2 == "D+") score[i] = 1.5;
		else if(str2 == "D0") score[i] = 1.0;
		else if(str2 == "F") score[i] = 0;
		else if (str2 == "P") {
			gpa = 0;
			score[i] = 0;
		}
		sum += (gpa * score[i]);
		sumgpa += gpa;
	}

	double ans = sum / sumgpa;

	cout << fixed;
	cout.precision(6);
	cout << ans;
	

}